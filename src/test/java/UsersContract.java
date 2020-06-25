import integrations.commons.HandleProperties;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class UsersContract {

		private final String PATH_USERS = "./src/test/resources/schemas/users/";

		@Test
  public void userSchemaValidator() {

				given()
								.contentType(ContentType.JSON)
								.when().get(HandleProperties.getValue("APP_URL") + HandleProperties.getValue("ENDPOINT_USERS"))
				    .then().statusCode(HttpStatus.SC_OK)
				    .body(matchesJsonSchemaInClasspath(PATH_USERS + "users-schema.json"));
  }
}
