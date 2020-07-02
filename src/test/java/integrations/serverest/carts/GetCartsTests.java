package integrations.serverest.carts;

import integrations.requests.CartsRequests;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class GetCarts {

  private static final CartsRequests request = new CartsRequests();

  @Test
  public void getCartsAmount() {
    Response response = request.getCartsRequests();
    Assert.assertEquals(response.getBody().jsonPath().get("quantidade"), Integer.valueOf(1));
  }
}
