package commons.requests.login;

import static commons.HandleProperties.getValue;

import commons.TemplatesJson;
import commons.client.HttpClient;
import integrations.serverest.login.PostLoginIT;
import integrations.serverest.login.TemplateLogin;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

public class LoginRequests {

  private final HttpClient httpClient = new HttpClient();

  public Response postLoginRequest(String email, String password) {

    Map<String, String> headers =
        new HashMap<String, String>() {
          {
            put("Content-type", "application/json");
          }
        };

    Map<String, String> body =
        new HashMap<String, String>() {
          {
            put("email", email);
            put("password", password);
          }
        };

    return httpClient.post(getValue("APP_URL"), "/login", headers, body).orElse(null);
  }

  public Response postLoginJsonRequest() {
    TemplateLogin params = TemplateLogin.builder().email("fulano@qa.com").password("teste").build();

    Map<String, String> headers =
        new HashMap<String, String>() {
          {
            put("Content-Type", "application/json");
          }
        };

    return httpClient
        .postJsonFile(
            getValue("APP_URL"),
            "/login",
            headers,
            TemplatesJson.getModel("loginResources/login.json", params, PostLoginIT.class))
        .orElse(null);
  }
}
