package integrations.serverest.login;

import integrations.commons.requests.LoginRequests;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PostLoginTests {

  private static final LoginRequests request = new LoginRequests();

  @Test
  public void postLogin() {
    Response response = request.postLoginRequest();
    assertEquals(HttpStatus.SC_OK, response.statusCode());
    assertEquals("Login realizado com sucesso", response.getBody().jsonPath().get("message"));
  }
}
