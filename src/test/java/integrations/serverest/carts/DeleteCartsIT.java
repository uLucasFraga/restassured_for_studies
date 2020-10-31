package integrations.serverest.carts;

import static commons.HandleProperties.getValue;
import static org.junit.Assert.assertEquals;

import commons.requests.TokenRequest;
import commons.requests.carts.CartsRequests;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

@DisplayName("TESTES DE INTEGRAÇÃO")
public class DeleteCartsIT {

  private final CartsRequests request = new CartsRequests();
  private final TokenRequest tokenRequest = new TokenRequest();

  @Before
  public void getToken() {
    tokenRequest.requestToken("/login", getValue("EMAIL_ADMIN"), getValue("PASSWORD_ADMIN"));
  }

  @Test
  public void deleteWithoutCarts() {
    Response response = request.deleteCartsRequests(tokenRequest.token);
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
