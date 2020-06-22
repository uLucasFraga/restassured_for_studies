package sample.serverest.products;

import commons.HandleProperties;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.RestAssured.get;
import static org.hamcrest.core.IsEqual.equalTo;

public class GetProducts {

  @Test
  public void getProducts() {
    get(HandleProperties.getValue("APP_URL") + HandleProperties.getValue("ENDPOINT_PRODUCTS"))
        .then().statusCode(HttpStatus.SC_OK)
        .body("quantidade", equalTo(2));
  }
}
