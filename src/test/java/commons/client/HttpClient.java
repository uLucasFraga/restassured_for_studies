package integrations.client;

import io.restassured.response.Response;

import java.util.Map;
import java.util.Optional;

import static io.restassured.RestAssured.given;

public class HttpClient {

  public Optional<Response> getHeaders(
      final String baseURI, String path, Map<String, String> headers) {
    return getRequest(baseURI, path, headers);
  }

  public Optional<Response> get(final String baseURI, String path) {
    return getNoHeaders(baseURI, path);
  }

  public Optional<Response> post(
      final String baseURI, String path, Map<String, String> headers, String body) {
    return postRequest(baseURI, path, headers, body);
  }

  public Optional<Response> delete(final String baseURI, String path, Map<String, String> headers) {
    return deleteRequest(baseURI, path, headers);
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

  private Optional<Response> postRequest(
      String baseURI, String path, Map<String, String> headers, String body) {
    try {
      Response response =
          given()
              .headers(headers)
              .baseUri(baseURI)
              .body(body)
              .post(path)
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

  private Optional<Response> deleteRequest(
      String baseURI, String path, Map<String, String> headers) {
    try {
      Response response =
          given()
              .headers(headers)
              .baseUri(baseURI)
              .delete(path)
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
