package contracts.serverest.users;

import integrations.commons.requests.UsersRequests;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertEquals;

public class UsersContractTests {

  private static final UsersRequests request = new UsersRequests();

  @Test
  public void userSchemaValidator() {
    Response response = request.getUsersRequests();
    assertEquals(HttpStatus.SC_OK, response.statusCode());
    response.then().body(matchesJsonSchemaInClasspath("schemas/users/users-schema.json"));
  }
}
