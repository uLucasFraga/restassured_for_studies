package integrations.serverest.users;

import com.github.javafaker.Faker;
import commons.requests.users.UsersRequests;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;

import static commons.requests.users.UsersRequests._id;
import static org.junit.Assert.assertEquals;

@DisplayName("TESTES DE INTEGRAÇÃO")
public class DeleteUsersIT {

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
  public void deleteUsers() {
    Response response = request.deleteUsersRequests(_id);
    assertEquals(HttpStatus.SC_OK, response.statusCode());
    assertEquals("Registro excluído com sucesso", response.getBody().jsonPath().get("message"));
  }
}
