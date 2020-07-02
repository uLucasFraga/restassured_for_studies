package integrations.serverest.carts;

import integrations.commons.TokenRequest;
import integrations.commons.requests.CartsRequests;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeleteCartsTests {

  private static final CartsRequests request = new CartsRequests();

  @Before
  public void getToken() {
    TokenRequest.getToken();
  }

  @Test
  public void deleteWithoutCarts() {
    Response response = request.deleteCartsRequests(TokenRequest.token);
    assertEquals(HttpStatus.SC_OK, response.statusCode());
    assertEquals(
        "Não foi encontrado carrinho para esse usuário",
        response.getBody().jsonPath().get("message"));
  }

  @Test
  public void deleteCartsUnauthorized() {
    Response response = request.deleteCartsRequests(null);
    assertEquals(HttpStatus.SC_UNAUTHORIZED, response.statusCode());
    assertEquals(
        "Token de acesso ausente, inválido, expirado ou usuário do token não existe mais",
        response.getBody().jsonPath().get("message"));
  }
}
