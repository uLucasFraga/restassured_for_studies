package integrations.serverest.carts;

import integrations.commons.HandleProperties;
import integrations.commons.Hooks;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import integrations.serverest.login.PostLogin;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;

public class DeleteCarts {

  @Before
  public void getJWT() {
    Hooks.getJWT();
  }

  @Test
  public void deleteCarts() {
    given()
        .header("Authorization", PostLogin.token)
        .when()
        .delete(
            HandleProperties.getValue("APP_URL")
                + HandleProperties.getValue("ENDPOINT_PURCHASE_CARTS"))
        .then()
        .statusCode(HttpStatus.SC_OK)
        .body("message", equalTo("Não foi encontrado carrinho para esse usuário"));
  }

  @Test
  public void deleteCartsUnauthorized() {
    when()
        .delete(
            HandleProperties.getValue("APP_URL")
                + HandleProperties.getValue("ENDPOINT_PURCHASE_CARTS"))
        .then()
        .statusCode(HttpStatus.SC_UNAUTHORIZED);
  }
}
