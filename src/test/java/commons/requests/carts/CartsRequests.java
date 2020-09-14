package commons.requests.carts;

import commons.client.HttpClient;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static commons.HandleProperties.getValue;

public class CartsRequests {

  private final HttpClient httpClient = new HttpClient();

  public Response getCartsRequests() {
    return httpClient.get(getValue("APP_URL"), "/carrinhos").orElse(null);
  }

  public Response deleteCartsRequests(String token) {
    Map<String, String> headers =
        new HashMap<String, String>() {
          {
            put("Authorization", token);
            put("Content-type", "application/json");
          }
        };
    return httpClient
        .delete(getValue("APP_URL"), "/carrinhos/concluir-compra", headers)
        .orElse(null);
  }
}
