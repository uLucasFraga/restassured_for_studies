package commons.requests;

import commons.requests.login.LoginRequests;
import io.restassured.response.Response;

public class TokenRequest {

  private final LoginRequests requests = new LoginRequests();
  public String token;

  public void requestToken(String endpoint, String email, String password) {
    Response response = requests.postLoginRequest(endpoint, email, password);
    token = response.getBody().jsonPath().get("authorization").toString();
  }

  public String getToken() {
    return this.token;
  }
}
