package integrations.serverest.login;

import integrations.commons.requests.LoginRequests;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PostLoginTests {

  private static final LoginRequests request = new LoginRequests();

  @Test
  public void postLoginSuccess() {
    Response response = request.postLoginRequest("EMAIL_ADMIN", "PASSWORD_ADMIN");
    assertEquals(HttpStatus.SC_OK, response.statusCode());
    assertEquals("Login realizado com sucesso", response.getBody().jsonPath().get("message"));
  }

  @Test
  public void postLoginEmailInvalid() {
    Response response = request.postLoginRequest("EMAIL_INVALID", "PASSWORD_ADMIN");
    assertEquals(HttpStatus.SC_BAD_REQUEST, response.statusCode());
    assertEquals(
        "\"email\" must be a valid email",
        response.getBody().jsonPath().get("error.details[0].email"));
  }

  @Test
  public void postLoginPasswordInvalid() {
    Response response = request.postLoginRequest("EMAIL_ADMIN", "PASS_INVALID");
    assertEquals(HttpStatus.SC_UNAUTHORIZED, response.statusCode());
    assertEquals("Email e/ou senha inválidos", response.getBody().jsonPath().get("message"));
  }

  @Test
  public void postLoginEmailAndPasswordInvalid() {
    Response response = request.postLoginRequest("EMAIL_INVALID", "PASS_INVALID");
    assertEquals(HttpStatus.SC_BAD_REQUEST, response.statusCode());
    assertEquals(
        "\"email\" must be a valid email",
        response.getBody().jsonPath().get("error.details[0].email"));
  }

  @Test
  public void postLoginEmailAndWithoutPassword() {
    Response response = request.postLoginRequest("EMAIL_ADMIN", "");
    assertEquals(HttpStatus.SC_BAD_REQUEST, response.statusCode());
    assertEquals(
        "\"password\" must be a string",
        response.getBody().jsonPath().get("error.details[0].password"));
  }

  @Test
  public void postLoginWithoutEmailAndWithPassword() {
    Response response = request.postLoginRequest("", "PASSWORD_ADMIN");
    assertEquals(HttpStatus.SC_BAD_REQUEST, response.statusCode());
    assertEquals(
        "\"email\" must be a string", response.getBody().jsonPath().get("error.details[0].email"));
  }

  @Test
  public void postLoginWithoutEmailAndPassword() {
    Response response = request.postLoginRequest("", "");
    assertEquals(HttpStatus.SC_BAD_REQUEST, response.statusCode());
    assertEquals(
        "\"email\" must be a string", response.getBody().jsonPath().get("error.details[0].email"));
    assertEquals(
        "\"password\" must be a string",
        response.getBody().jsonPath().get("error.details[0].password"));
  }
}
