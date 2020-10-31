package integrations.serverest.users;

import static commons.HandleProperties.getValue;
import static org.junit.Assert.assertEquals;

import com.github.javafaker.Faker;
import commons.requests.users.UsersRequests;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@DisplayName("TESTES DE INTEGRAÇÃO")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PostUsersIT {

  private final UsersRequests request = new UsersRequests();

  Faker faker = new Faker();
  String name = faker.name().fullName();
  String email = faker.internet().emailAddress();
  String password = faker.random().hex(5);

  @Test
  public void postCreateUser() {
    Response response =
        request.postUsersRequests("Lucas Fraga", getValue("EMAIL_USER"), getValue("PASSWORD_USER"));
    assertEquals(HttpStatus.SC_CREATED, response.statusCode());
    assertEquals("Cadastro realizado com sucesso", response.getBody().jsonPath().get("message"));
  }

  @Test
  public void postCreateUserFaker() {
    Response response = request.postUsersRequests(name, email, password);
    assertEquals(HttpStatus.SC_CREATED, response.statusCode());
    assertEquals("Cadastro realizado com sucesso", response.getBody().jsonPath().get("message"));
  }

  @Test
  public void postEqualUser() {
    Response response =
        request.postUsersRequests("Lucas Fraga", getValue("EMAIL_USER"), getValue("PASSWORD_USER"));
    assertEquals(HttpStatus.SC_BAD_REQUEST, response.statusCode());
    assertEquals("Este email já está sendo usado", response.getBody().jsonPath().get("message"));
  }
}
