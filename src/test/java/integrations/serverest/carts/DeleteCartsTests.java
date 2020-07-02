package integrations.serverest.carts;

import integrations.commons.HandleProperties;
import integrations.commons.TokenRequest;
import integrations.requests.CartsRequests;
import integrations.serverest.login.PostLogin;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.core.IsEqual.equalTo;

public class DeleteCarts {

  private static final CartsRequests request = new CartsRequests();

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

  @Test
  public void deleteWithoutCarts() {
    Response response = request.deleteCartsRequests(TokenRequest.token);
    Assert.assertEquals(
        response.getBody().jsonPath().get("message"),
        "Não foi encontrado carrinho para esse usuário");
  }
}
