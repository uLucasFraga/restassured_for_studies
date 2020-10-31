package commons;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.Version;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class TemplatesJson {

  public static String getTemplateString(
      String layout, Map<String, Object> params, Class operationClass) {
    Configuration conf = new Configuration(new Version(2, 3, 28));
    conf.setClassForTemplateLoading(operationClass, "/jsonFiles");
    Template template = null;
    Writer out = null;
    try {
      template = conf.getTemplate(layout);
      out = new StringWriter();
      template.process(params, out);
    } catch (IOException | TemplateException e) {
      throw new RuntimeException(e);
    }
    return out.toString();
  }

  public static String getModel(String layout, Object params, Class operationClass) {
    HashMap<String, Object> dataModel = new HashMap<>();
    dataModel.put("params", params);
    return TemplatesJson.getTemplateString(layout, dataModel, operationClass);
  }
}
