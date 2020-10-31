package integrations.serverest.users;

import static commons.HandleProperties.getValue;
import static commons.requests.users.UsersRequests._id;
import static org.junit.Assert.assertEquals;

import com.github.javafaker.Faker;
import commons.requests.users.UsersRequests;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

@DisplayName("TESTES DE INTEGRAÇÃO")
public class PutUsersIT {

  private final UsersRequests request = new UsersRequests();
  Faker faker = new Faker();
  String email = faker.internet().emailAddress();
  String name = faker.name().fullName();
  String password = faker.random().hex(5);

  @Before
  public void getUserId() {
    request.getUserId(name, email, password);
  }

  @Test
  public void putUsers() {
    Response response =
        request.putUsersRequests(
            getValue("ID_ADMIN_USER"), "Da Silva Fulano", "no_email@qa.com", "no_pass");
    assertEquals(HttpStatus.SC_OK, response.statusCode());
    assertEquals("Registro alterado com sucesso", response.getBody().jsonPath().get("message"));
  }

  @Test
  public void putNewUsers() {
    Response response = request.putUsersRequests(_id, "New Name", email, "no_pass");
    assertEquals(HttpStatus.SC_OK, response.statusCode());
    assertEquals("Registro alterado com sucesso", response.getBody().jsonPath().get("message"));
  }
}
