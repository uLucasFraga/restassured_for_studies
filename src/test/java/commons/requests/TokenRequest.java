package commons.requests;

import commons.requests.login.LoginRequests;
import io.restassured.response.Response;

public class TokenRequest {

  public static String token;
  private final LoginRequests request = new LoginRequests();

  public void getToken(String email, String password) {
    Response response = request.postLoginRequest(email, password);
    token = response.getBody().jsonPath().get("authorization").toString();
  }
}
