package integrations.commons;

import integrations.client.HttpClient;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TokenRequest {

  public static String token;
  static HttpClient httpClient = new HttpClient();

  public static Response postToGetToken() {
    JSONObject requestParams = new JSONObject();
    requestParams.put("email", HandleProperties.getValue("EMAIL_ADMIN"));
    requestParams.put("password", HandleProperties.getValue("PASSWORD_ADMIN"));

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

  public static void getToken() {
    Response response = postToGetToken();
    token = response.getBody().jsonPath().get("authorization").toString();
  }
}
