package contracts.serverest.products;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertEquals;

import commons.requests.products.ProductsRequests;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;

@DisplayName("TESTES DE CONTRATO")
public class ProductsContractIT {

  private final ProductsRequests request = new ProductsRequests();

  @Test
  public void productSchemaValidator() {
    Response response = request.getProductsRequest("/produtos");
    assertEquals(HttpStatus.SC_OK, response.statusCode());
    response.then().body(matchesJsonSchemaInClasspath("schemas/products/products-schema.json"));
  }
}
