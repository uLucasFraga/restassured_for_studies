package contracts.serverest.users;

import integrations.commons.HandleProperties;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class UsersContract {

  @Test
  public void userSchemaValidator() {

    when()
        .get(HandleProperties.getValue("APP_URL") + HandleProperties.getValue("ENDPOINT_USERS"))
        .then().statusCode(HttpStatus.SC_OK)
        .body(matchesJsonSchemaInClasspath("schemas/users/users-schema.json"));
  }
}
