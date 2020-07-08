package integrations.commons.requests;

import com.github.javafaker.Faker;
import integrations.client.HttpClient;
import integrations.commons.HandleProperties;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class UsersRequests {

  HttpClient httpClient = new HttpClient();

  Faker faker = new Faker();
  String name = faker.name().fullName();
  String email = faker.internet().emailAddress();
  String pass = faker.random().hex(5);

  public Response postUsersRequests() {
    JSONObject requestParams = new JSONObject();
    requestParams.put("nome", "Lucas Fraga");
    requestParams.put("email", HandleProperties.getValue("EMAIL_USER"));
    requestParams.put("password", HandleProperties.getValue("PASSWORD_USER"));
    requestParams.put("administrador", "true");

    Map<String, String> headers =
        new HashMap<String, String>() {
          {
            put("Content-type", "application/json");
          }
        };
    return httpClient
        .post(
            HandleProperties.getValue("APP_URL"),
            HandleProperties.getValue("ENDPOINT_USERS"),
            headers,
            requestParams.toJSONString())
        .orElse(null);
  }

  public Response postUsersFakerRequests() {
    JSONObject requestParams = new JSONObject();
    requestParams.put("nome", name);
    requestParams.put("email", email);
    requestParams.put("password", pass);
    requestParams.put("administrador", "true");

    Map<String, String> headers =
        new HashMap<String, String>() {
          {
            put("Content-type", "application/json");
          }
        };
    return httpClient
        .post(
            HandleProperties.getValue("APP_URL"),
            HandleProperties.getValue("ENDPOINT_USERS"),
            headers,
            requestParams.toJSONString())
        .orElse(null);
  }

  public Response getUsersRequests() {
    Map<String, String> headers =
        new HashMap<String, String>() {
          {
            put("Content-type", "application/json");
          }
        };
    return httpClient
        .getHeaders(
            HandleProperties.getValue("APP_URL"),
            HandleProperties.getValue("ENDPOINT_USERS"),
            headers)
        .orElse(null);
  }
}
