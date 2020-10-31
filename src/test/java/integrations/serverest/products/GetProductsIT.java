package integrations.serverest.products;

import static org.junit.Assert.assertEquals;

import commons.requests.products.ProductsRequests;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;

@DisplayName("TESTES DE INTEGRAÇÃO")
public class GetProductsIT {

  private final ProductsRequests request = new ProductsRequests();

  @Test
  public void getProductsAmount() {
    Response response = request.getProductsRequest("/produtos");
    Integer products = response.getBody().jsonPath().get("quantidade");
    assertEquals(HttpStatus.SC_OK, response.statusCode());
    assertEquals(products, response.getBody().jsonPath().get("quantidade"));
  }
}
