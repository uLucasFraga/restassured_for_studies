package commons.requests.login;

import commons.client.HttpClient;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static commons.HandleProperties.getValue;

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
}
