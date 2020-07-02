package client;

import io.restassured.response.Response;
import jdk.nashorn.internal.codegen.ApplySpecialization;

import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import static io.restassured.RestAssured.given;

public class HttpClient {

  public Optional<Response> getHeaders(
      final String baseURI, String path, Map<String, String> headers) {
    return getRequest(baseURI, path, headers);
  }

  public Optional<Response> get(final String baseURI, String path) {
    return getNoHeaders(baseURI, path);
  }

  private Optional<Response> getNoHeaders(String baseURI, String path) {
    try {
      Response response =
          given().baseUri(baseURI).get(path).then().log().all().extract().response();
      return Optional.of(response);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Optional.empty();
  }

  private Optional<Response> getRequest(String baseURI, String path, Map<String, String> headers) {
    try {
      Response response =
          given()
              .headers(headers)
              .baseUri(baseURI)
              .get(path)
              .then()
              .log()
              .all()
              .extract()
              .response();
      return Optional.of(response);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Optional.empty();
  }
}
