package contracts.serverest.carts;

import commons.requests.carts.CartsRequests;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertEquals;

public class CartsContractTests {

  private final CartsRequests request = new CartsRequests();

  @Test
  public void cartsSchemaValidator() {
    Response response = request.getCartsRequests();
    assertEquals(HttpStatus.SC_OK, response.statusCode());
    response.then().body(matchesJsonSchemaInClasspath("schemas/carts/carts-schema.json"));
  }
}
