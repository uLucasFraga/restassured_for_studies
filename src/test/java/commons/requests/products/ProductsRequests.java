package commons.requests;

import commons.client.HttpClient;
import commons.HandleProperties;
import io.restassured.response.Response;

public class ProductsRequests {

		HttpClient httpClient = new HttpClient();

		public Response getProductsRequests() {
				return httpClient
								.get(HandleProperties.getValue("APP_URL"), HandleProperties.getValue("ENDPOINT_PRODUCTS"))
								.orElse(null);
		}
}
