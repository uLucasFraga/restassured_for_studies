package integrations.serverest.products;

import integrations.commons.requests.ProductsRequests;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetProductsTests {

  private static final ProductsRequests request = new ProductsRequests();

  @Test
  public void getProductsAmount() {
    Response response = request.getProductsRequests();
    assertEquals(HttpStatus.SC_OK, response.statusCode());
    assertEquals(Integer.valueOf(2), response.getBody().jsonPath().get("quantidade"));
  }
}
