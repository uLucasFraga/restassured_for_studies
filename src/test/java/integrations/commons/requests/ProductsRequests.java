package integrations.commons.requests;

import integrations.client.HttpClient;
import integrations.commons.HandleProperties;
import io.restassured.response.Response;

public class ProductsRequests {

		HttpClient httpClient = new HttpClient();

		public Response getProductsRequests() {
				return httpClient
								.get(HandleProperties.getValue("APP_URL"), HandleProperties.getValue("ENDPOINT_PRODUCTS"))
								.orElse(null);
		}
}
