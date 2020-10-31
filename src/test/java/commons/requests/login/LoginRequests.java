package commons.requests.login;

import static commons.HandleProperties.getValue;

import commons.client.HttpClient;
import commons.client.TemplatesJson;
import integrations.serverest.login.PostLoginIT;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

public class LoginRequests {

  private final HttpClient httpClient = new HttpClient();

  public Response postLoginRequest(String endpoint, String email, String password) {

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

    return httpClient.post(getValue("APP_URL"), endpoint, headers, body).orElse(null);
  }

  public Response postLoginJsonRequest(String endpoint, String email, String password) {

    LoginData params = LoginData.builder().email(email).password(password).build();

    Map<String, String> headers =
        new HashMap<String, String>() {
          {
            put("Content-Type", "application/json");
          }
        };

    return httpClient
        .postJsonFile(
            getValue("APP_URL"),
            endpoint,
            headers,
            TemplatesJson.getModel("/login.json", params, PostLoginIT.class))
        .orElse(null);
  }
}
