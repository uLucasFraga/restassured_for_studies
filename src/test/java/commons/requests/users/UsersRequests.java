package commons.requests.users;

import commons.client.HttpClient;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static commons.HandleProperties.getValue;

public class UsersRequests {

  public static String _id;
  private final HttpClient httpClient = new HttpClient();

  public Response getUsersRequests() {

    Map<String, String> headers =
        new HashMap<String, String>() {
          {
            put("Content-type", "application/json");
          }
        };

    return httpClient.getHeaders(getValue("APP_URL"), "/usuarios", headers).orElse(null);
  }

  public Response getUsersQueryParamRequests(String key, String value) {

    Map<String, String> headers =
        new HashMap<String, String>() {
          {
            put("Content-type", "application/json");
          }
        };

    Map<String, String> params =
        new HashMap<String, String>() {
          {
            put(key, value);
          }
        };

    return httpClient.getQuery(getValue("APP_URL"), "/usuarios", headers, params).orElse(null);
  }

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

  public Response putUsersRequests(String _id, String name, String email, String password) {

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
    return httpClient.put(getValue("APP_URL"), "/usuarios/" + _id, headers, body).orElse(null);
  }

  public void getUserId(String name, String email, String password) {
    Response response = postUsersRequests(name, email, password);
    _id = response.getBody().jsonPath().get("_id").toString();
  }
}
