package contracts.serverest.carts;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertEquals;

import commons.requests.carts.CartsRequests;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;

@DisplayName("TESTES DE CONTRATO")
public class CartsContractIT {

  private final CartsRequests request = new CartsRequests();

  @Test
  public void cartsSchemaValidator() {
    Response response = request.getCartsRequests();
    assertEquals(HttpStatus.SC_OK, response.statusCode());
    response.then().body(matchesJsonSchemaInClasspath("schemas/carts/carts-schema.json"));
  }
}
