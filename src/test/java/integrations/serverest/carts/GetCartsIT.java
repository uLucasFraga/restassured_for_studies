package integrations.serverest.carts;

import commons.requests.carts.CartsRequests;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

@DisplayName("TESTES DE INTEGRAÇÃO")
public class GetCartsIT {

  private final CartsRequests request = new CartsRequests();

  @Test
  public void getCartsAmount() {
    Response response = request.getCartsRequests();
    assertEquals(HttpStatus.SC_OK, response.statusCode());
    assertEquals(Integer.valueOf(1), response.getBody().jsonPath().get("quantidade"));
  }
}
