package integrations.serverest.products;

import static commons.HandleProperties.getValue;
import static org.junit.Assert.assertEquals;

import com.github.javafaker.Faker;
import commons.requests.TokenRequest;
import commons.requests.products.ProductsRequests;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

@DisplayName("TESTES DE INTEGRAÇÃO")
public class PostProductsIT {

  private final ProductsRequests request = new ProductsRequests();
  private final TokenRequest tokenRequest = new TokenRequest();

  Faker faker = new Faker();
  String name = faker.commerce().productName();
  int price = faker.number().numberBetween(1, 100);
  String description = faker.commerce().material();
  int quantity = faker.number().randomDigitNotZero();

  @Before
  public void getToken() {
    tokenRequest.requestToken("/login", getValue("EMAIL_ADMIN"), getValue("PASSWORD_ADMIN"));
  }

  @Test
  public void postProductsFaker() {
    Response response =
        request.postProductsJsonRequest(
            "/produtos", tokenRequest.token, name, price, description, quantity);
    assertEquals(HttpStatus.SC_CREATED, response.statusCode());
    assertEquals("Cadastro realizado com sucesso", response.getBody().jsonPath().get("message"));
  }

  @Test
  public void postProductsEquals() {
    Response response =
        request.postProductsJsonRequest(
            "/produtos", tokenRequest.token, "Logitech MX Vertical", price, "Mouse", quantity);
    assertEquals(HttpStatus.SC_BAD_REQUEST, response.statusCode());
    assertEquals("Já existe produto com esse nome", response.getBody().jsonPath().get("message"));
  }

  @Test
  public void postProductsNegativeNumberInPrice() {
    Response response =
        request.postProductsJsonRequest("/produtos", tokenRequest.token, "", 0, "", 0);
    assertEquals(HttpStatus.SC_BAD_REQUEST, response.statusCode());
    assertEquals("nome não pode ficar em branco", response.getBody().jsonPath().get("nome"));
    assertEquals("preco deve ser um número positivo", response.getBody().jsonPath().get("preco"));
    assertEquals(
        "descricao não pode ficar em branco", response.getBody().jsonPath().get("descricao"));
  }
}
