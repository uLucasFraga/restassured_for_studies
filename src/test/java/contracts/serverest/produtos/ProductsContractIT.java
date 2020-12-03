package contracts.serverest.produtos;

import commons.requests.products.ProductsRequests;
import commons.requests.users.UsersRequests;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertEquals;

@DisplayName("TESTES DE CONTRATO")
public class ProductsContractIT {

    private final ProductsRequests request = new ProductsRequests();

    @Test
    public void productsSchemaValidator() {
        Response response = request.getProductsRequest("/produtos");
        assertEquals(HttpStatus.SC_OK, response.statusCode());
        response.then().body(matchesJsonSchemaInClasspath("schemas/produtos/produtos-schema.json"));
    }
}

