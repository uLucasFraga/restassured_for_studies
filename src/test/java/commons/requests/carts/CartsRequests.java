package commons.requests;

import commons.client.HttpClient;
import commons.HandleProperties;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class CartsRequests {

  HttpClient httpClient = new HttpClient();

  public Response getCartsRequests() {
    return httpClient
        .get(HandleProperties.getValue("APP_URL"), HandleProperties.getValue("ENDPOINT_CARTS"))
        .orElse(null);
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
        .delete(
            HandleProperties.getValue("APP_URL"),
            HandleProperties.getValue("ENDPOINT_PURCHASE_CARTS"),
            headers)
        .orElse(null);
  }
}
