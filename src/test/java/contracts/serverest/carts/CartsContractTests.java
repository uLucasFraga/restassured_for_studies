package contracts.serverest.carts;

import integrations.commons.requests.CartsRequests;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertEquals;

public class CartsContractTests {

  private static final CartsRequests request = new CartsRequests();

  @Test
  public void cartsSchemaValidator() {
    Response response = request.getCartsRequests();
    assertEquals(HttpStatus.SC_OK, response.statusCode());
    response.then().body(matchesJsonSchemaInClasspath("schemas/carts/carts-schema.json"));
  }
}