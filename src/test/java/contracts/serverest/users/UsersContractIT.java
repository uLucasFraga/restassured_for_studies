package contracts.serverest.users;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertEquals;

import commons.requests.users.UsersRequests;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;

@DisplayName("TESTES DE CONTRATO")
public class UsersContractIT {

  private final UsersRequests request = new UsersRequests();

  @Test
  public void userSchemaValidator() {
    Response response = request.getUsersRequests();
    assertEquals(HttpStatus.SC_OK, response.statusCode());
    response.then().body(matchesJsonSchemaInClasspath("schemas/users/users-schema.json"));
  }
}
