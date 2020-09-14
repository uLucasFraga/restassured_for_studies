package integrations.serverest.products;

import commons.requests.products.ProductsRequests;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetProductsIT {

  private final ProductsRequests request = new ProductsRequests();

  @Test
  public void getProductsAmount() {
    Response response = request.getProductsRequests();
    assertEquals(HttpStatus.SC_OK, response.statusCode());
    assertEquals(Integer.valueOf(2), response.getBody().jsonPath().get("quantidade"));
  }
}
