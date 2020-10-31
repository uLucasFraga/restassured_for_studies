package integrations.serverest.login;

import static commons.HandleProperties.getValue;
import static org.junit.Assert.assertEquals;

import commons.requests.login.LoginRequests;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;

@DisplayName("TESTES DE INTEGRAÇÃO")
public class PostLoginIT {

  private final LoginRequests request = new LoginRequests();

  @Test
  public void postLoginSuccess() {
    Response response =
        request.postLoginRequest("/login", getValue("EMAIL_ADMIN"), getValue("PASSWORD_ADMIN"));
    assertEquals(HttpStatus.SC_OK, response.statusCode());
    assertEquals("Login realizado com sucesso", response.getBody().jsonPath().get("message"));
  }

  @Test
  public void postLoginEmailInvalid() {
    Response response =
        request.postLoginRequest("/login", getValue("EMAIL_INVALID"), getValue("PASSWORD_ADMIN"));
    assertEquals(HttpStatus.SC_BAD_REQUEST, response.statusCode());
    assertEquals("email deve ser um email válido", response.getBody().jsonPath().get("email"));
  }

  @Test
  public void postLoginPasswordInvalid() {
    Response response =
        request.postLoginRequest("/login", getValue("EMAIL_ADMIN"), getValue("PASSWORD_INVALID"));
    assertEquals(HttpStatus.SC_UNAUTHORIZED, response.statusCode());
    assertEquals("Email e/ou senha inválidos", response.getBody().jsonPath().get("message"));
  }

  @Test
  public void postLoginEmailAndPasswordInvalid() {
    Response response =
        request.postLoginRequest("/login", getValue("EMAIL_INVALID"), getValue("PASSWORD_INVALID"));
    assertEquals(HttpStatus.SC_BAD_REQUEST, response.statusCode());
    assertEquals("email deve ser um email válido", response.getBody().jsonPath().get("email"));
  }

  @Test
  public void postLoginEmailAndWithoutPassword() {
    Response response = request.postLoginRequest("/login", getValue("EMAIL_ADMIN"), "");
    assertEquals(HttpStatus.SC_BAD_REQUEST, response.statusCode());
    assertEquals(
        "password não pode ficar em branco", response.getBody().jsonPath().get("password"));
  }

  @Test
  public void postLoginWithoutEmailAndWithPassword() {
    Response response = request.postLoginRequest("/login", "", getValue("PASSWORD_ADMIN"));
    assertEquals(HttpStatus.SC_BAD_REQUEST, response.statusCode());
    assertEquals("email não pode ficar em branco", response.getBody().jsonPath().get("email"));
  }

  @Test
  public void postLoginWithoutEmailAndPassword() {
    Response response = request.postLoginRequest("/login", "", "");
    assertEquals(HttpStatus.SC_BAD_REQUEST, response.statusCode());
    assertEquals("email não pode ficar em branco", response.getBody().jsonPath().get("email"));
    assertEquals(
        "password não pode ficar em branco", response.getBody().jsonPath().get("password"));
  }

  @Test
  public void postLoginWithJsonFile() {
    Response response = request.postLoginJsonRequest("/login", "fulano@qa.com", "teste");
    assertEquals(HttpStatus.SC_OK, response.statusCode());
  }

  @Test
  public void postLoginWithJsonFileInvalid() {
    Response response = request.postLoginJsonRequest("/login", "fulano@qa.com", "error_pass");
    assertEquals(HttpStatus.SC_UNAUTHORIZED, response.statusCode());
  }
}
