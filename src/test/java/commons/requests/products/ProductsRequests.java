package commons.requests.products;

import static commons.HandleProperties.getValue;

import commons.client.HttpClient;
import commons.client.TemplatesJson;
import integrations.serverest.products.PostProductsIT;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.Map;

public class ProductsRequests {

  private final HttpClient httpClient = new HttpClient();

  public Response getProductsRequest(String endpoint) {

    Map<String, String> headers =
        new HashMap<String, String>() {
          {
            put("Content-Type", "application/json");
          }
        };

    return httpClient.getHeaders(getValue("APP_URL"), endpoint, headers).orElse(null);
  }

  public Response postProductsJsonRequest(
      String endpoint,
      String token,
      String name,
      Integer price,
      String description,
      Integer quantity) {

    ProductsData params =
        ProductsData.builder()
            .nome(name)
            .preco(price)
            .descricao(description)
            .quantidade(quantity)
            .build();

    Map<String, String> headers =
        new HashMap<String, String>() {
          {
            put("Authorization", token);
            put("Content-Type", "application/json");
          }
        };

    return httpClient
        .postJsonFile(
            getValue("APP_URL"),
            endpoint,
            headers,
            TemplatesJson.getModel("/products.json", params, PostProductsIT.class))
        .orElse(null);
  }
}
