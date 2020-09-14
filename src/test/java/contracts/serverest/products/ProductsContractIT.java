package contracts.serverest.products;

import commons.requests.products.ProductsRequests;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertEquals;

public class ProductsContractIT {

  private final ProductsRequests request = new ProductsRequests();

  @Test
  public void productSchemaValidator() {
    Response response = request.getProductsRequests();
    assertEquals(HttpStatus.SC_OK, response.statusCode());
    response.then().body(matchesJsonSchemaInClasspath("schemas/products/products-schema.json"));
  }
}
