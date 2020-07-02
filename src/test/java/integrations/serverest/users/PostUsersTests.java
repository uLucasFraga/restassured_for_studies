package integrations.serverest.users;

import com.github.javafaker.Faker;
import integrations.commons.HandleProperties;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.json.simple.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class PostUsers {

  Faker faker = new Faker();
  String name = faker.name().fullName();
  String email = faker.internet().emailAddress();
  String pass = faker.random().hex(5);

  @Test
  public void postCreateUser() {
    JSONObject requestParams = new JSONObject();
    requestParams.put("nome", name);
    requestParams.put("email", email);
    requestParams.put("password", pass);
    requestParams.put("administrador", "true");

    given()
        .contentType(ContentType.JSON)
        .body(requestParams.toJSONString())
        .when().post(HandleProperties.getValue("APP_URL") + HandleProperties.getValue("ENDPOINT_USERS"))
        .then().statusCode(HttpStatus.SC_CREATED)
        .body("message", equalTo("Cadastro realizado com sucesso"));
  }

  @Test
  public void postEqualUser() {
    JSONObject requestParams = new JSONObject();
    requestParams.put("nome", "Lucas Fraga");
    requestParams.put("email", HandleProperties.getValue("EMAIL_USER"));
    requestParams.put("password", HandleProperties.getValue("PASSWORD_USER"));
    requestParams.put("administrador", "true");

    given()
        .contentType(ContentType.JSON)
        .body(requestParams.toJSONString())
        .when().post(HandleProperties.getValue("APP_URL") + HandleProperties.getValue("ENDPOINT_USERS"))
        .then().statusCode(HttpStatus.SC_BAD_REQUEST)
        .body("message", equalTo("Este email já está sendo usado"));
  }
}
