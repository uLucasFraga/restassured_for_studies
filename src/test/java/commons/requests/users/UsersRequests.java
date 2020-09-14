package commons.requests.users;

import commons.client.HttpClient;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static commons.HandleProperties.getValue;

public class UsersRequests {

  private final HttpClient httpClient = new HttpClient();

  public Response postUsersRequests(String name, String email, String password) {

    Map<String, String> headers =
        new HashMap<String, String>() {
          {
            put("Content-type", "application/json");
          }
        };

    Map<String, String> body =
        new HashMap<String, String>() {
          {
            put("nome", name);
            put("email", email);
            put("password", password);
            put("administrador", "true");
          }
        };
    return httpClient.post(getValue("APP_URL"), "/usuarios", headers, body).orElse(null);
  }

  public Response getUsersRequests() {
    Map<String, String> headers =
        new HashMap<String, String>() {
          {
            put("Content-type", "application/json");
          }
        };

    return httpClient.getHeaders(getValue("APP_URL"), "/usuarios", headers).orElse(null);
  }
}
