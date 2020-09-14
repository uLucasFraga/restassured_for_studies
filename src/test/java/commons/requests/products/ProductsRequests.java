package commons.requests.products;

import commons.HandleProperties;
import commons.client.HttpClient;
import io.restassured.response.Response;

public class ProductsRequests {

  HttpClient httpClient = new HttpClient();

  public Response getProductsRequests() {
    return httpClient.get(HandleProperties.getValue("APP_URL"), "/produtos").orElse(null);
  }
}
