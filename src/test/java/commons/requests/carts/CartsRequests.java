package commons.requests.carts;

import commons.HandleProperties;
import commons.client.HttpClient;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class CartsRequests {

  private final HttpClient httpClient = new HttpClient();

  public Response getCartsRequests() {
    return httpClient.get(HandleProperties.getValue("APP_URL"), "/carrinhos").orElse(null);
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
        .delete(HandleProperties.getValue("APP_URL"), "/carrinhos/concluir-compra", headers)
        .orElse(null);
  }
}
