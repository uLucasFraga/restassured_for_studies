package integrations.serverest.users;

import integrations.commons.requests.UsersRequests;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PostUsersTests {

  private static final UsersRequests request = new UsersRequests();

  @Test
  public void postCreateUser() {
    Response response = request.postUsersRequests();
    assertEquals(HttpStatus.SC_CREATED, response.statusCode());
    assertEquals("Cadastro realizado com sucesso", response.getBody().jsonPath().get("message"));
  }

  @Test
  public void postCreateUserFaker() {
    Response response = request.postUsersFakerRequests();
    assertEquals(HttpStatus.SC_CREATED, response.statusCode());
    assertEquals("Cadastro realizado com sucesso", response.getBody().jsonPath().get("message"));
  }

  @Test
  public void postEqualUser() {
    Response response = request.postUsersRequests();
    assertEquals(HttpStatus.SC_BAD_REQUEST, response.statusCode());
    assertEquals("Este email já está sendo usado", response.getBody().jsonPath().get("message"));
  }
}
