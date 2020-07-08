package integrations.commons.requests;

import integrations.client.HttpClient;
import integrations.commons.HandleProperties;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginRequests {

  HttpClient httpClient = new HttpClient();

  public Response postLoginRequest(String email, String pass) {
    JSONObject requestParams = new JSONObject();
    requestParams.put("email", HandleProperties.getValue(email));
    requestParams.put("password", HandleProperties.getValue(pass));

    Map<String, String> headers =
        new HashMap<String, String>() {
          {
            put("Content-type", "application/json");
          }
        };
    return httpClient
        .post(
            HandleProperties.getValue("APP_URL"),
            HandleProperties.getValue("ENDPOINT_LOGIN"),
            headers,
            requestParams.toJSONString())
        .orElse(null);

  }
}
