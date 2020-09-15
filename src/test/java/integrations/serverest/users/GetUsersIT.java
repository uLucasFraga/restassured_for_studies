package integrations.serverest.users;

import commons.requests.users.UsersRequests;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static commons.HandleProperties.getValue;
import static org.junit.Assert.assertEquals;

public class GetUsersIT {

  private final UsersRequests request = new UsersRequests();

  @Test
  public void getUsers() {
    Response response = request.getUsersRequests();
    assertEquals(HttpStatus.SC_OK, response.statusCode());
    assertEquals(Integer.valueOf(1), response.getBody().jsonPath().get("quantidade"));
  }

  @Test
  public void getUsersByName() {
    Response response = request.getUsersRequests();
    assertEquals(HttpStatus.SC_OK, response.statusCode());
    assertEquals("Fulano da Silva", response.getBody().jsonPath().get("usuarios[0].nome"));
  }

  @Test
  public void getUsersByEmail() {
    Response response = request.getUsersRequests();
    assertEquals(HttpStatus.SC_OK, response.statusCode());
    assertEquals("fulano@qa.com", response.getBody().jsonPath().get("usuarios[0].email"));
  }

  @Test
  public void getUsersByID() {
    Response response = request.getUsersRequests();
    assertEquals(HttpStatus.SC_OK, response.statusCode());
    assertEquals(getValue("ID_ADMIN_USER"), response.getBody().jsonPath().get("usuarios[0]._id"));
  }

  @Test
  public void getUsersByQueryID() {
    Response response = request.getUsersQueryParamRequests("_id", getValue("ID_ADMIN_USER"));
    assertEquals(HttpStatus.SC_OK, response.statusCode());
    assertEquals("Fulano da Silva", response.getBody().jsonPath().get("usuarios[0].nome"));
  }

  @Test
  public void getUsersByQueryName() {
    Response response = request.getUsersQueryParamRequests("nome", "Fulano da Silva");
    assertEquals(HttpStatus.SC_OK, response.statusCode());
    assertEquals(getValue("EMAIL_ADMIN"), response.getBody().jsonPath().get("usuarios[0].email"));
  }

  @Test
  public void getUsersByQueryEmail() {
    Response response = request.getUsersQueryParamRequests("email", getValue("EMAIL_ADMIN"));
    assertEquals(HttpStatus.SC_OK, response.statusCode());
    assertEquals("Fulano da Silva", response.getBody().jsonPath().get("usuarios[0].nome"));
  }

  @Test
  public void getUsersByQueryPassword() {
    Response response = request.getUsersQueryParamRequests("password", getValue("PASSWORD_ADMIN"));
    assertEquals(HttpStatus.SC_OK, response.statusCode());
    assertEquals("Fulano da Silva", response.getBody().jsonPath().get("usuarios[0].nome"));
  }

  @Test
  public void getUsersByQueryAdmin() {
    Response response = request.getUsersQueryParamRequests("administrador", String.valueOf(true));
    assertEquals(HttpStatus.SC_OK, response.statusCode());
    assertEquals(getValue("EMAIL_ADMIN"), response.getBody().jsonPath().get("usuarios[0].email"));
  }

  @Test
  public void getUsersByQueryInvalid() {
    Response response = request.getUsersQueryParamRequests("nome", "Nome inválido");
    assertEquals(HttpStatus.SC_OK, response.statusCode());
    assertEquals(Integer.valueOf(0), response.getBody().jsonPath().get("quantidade"));
  }
}
