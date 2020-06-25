package integrations.serverest.login;

import integrations.commons.HandleProperties;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;

@SuppressWarnings("unchecked")
public class PostLogin {

  public static String token;

  @Test
  public void postLogin() {
    JSONObject requestParams = new JSONObject();
    requestParams.put("email", HandleProperties.getValue("EMAIL_ADMIN"));
    requestParams.put("password", HandleProperties.getValue("PASSWORD_ADMIN"));

    Response response =
        RestAssured.given()
            .header("Content-type", "application/json")
            .body(requestParams.toJSONString())
            .when().post(
                HandleProperties.getValue("APP_URL") + HandleProperties.getValue("ENDPOINT_LOGIN"))
            .then().statusCode(HttpStatus.SC_OK)
            .body("message", equalTo("Login realizado com sucesso"))
            .extract().response();

    token = response.path("authorization").toString();
  }
}
