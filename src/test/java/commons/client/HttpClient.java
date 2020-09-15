package commons.client;

import io.restassured.response.Response;

import java.util.List;
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

  public Optional<Response> getQuery(
      final String baseURI, String path, Map<String, String> headers, Map<String, String> params) {
    return getQueryParamRequest(baseURI, path, headers, params);
  }

  public Optional<Response> post(
      final String baseURI, String path, Map<String, String> headers, Map<String, String> body) {
    return postRequest(baseURI, path, headers, body);
  }

  public Optional<Response> postList(
      final String baseURI,
      String path,
      Map<String, String> headers,
      List<Map<String, String>> body) {
    return postListRequest(baseURI, path, headers, body);
  }

  public Optional<Response> postJsonFile(
      final String baseURI, String path, Map<String, String> headers, String body) {
    return postJsonFileRequest(baseURI, path, headers, body);
  }

  public Optional<Response> delete(final String baseURI, String path, Map<String, String> headers) {
    return deleteRequest(baseURI, path, headers);
  }

  private Optional<Response> getNoHeaders(String baseURI, String path) {
    try {
      Response response =
          given().relaxedHTTPSValidation().baseUri(baseURI).get(path).then().extract().response();
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
              .relaxedHTTPSValidation()
              .headers(headers)
              .baseUri(baseURI)
              .get(path)
              .then()
              .extract()
              .response();
      return Optional.of(response);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Optional.empty();
  }

  private Optional<Response> getQueryParamRequest(
      String baseURI, String path, Map<String, String> headers, Map<String, String> params) {
    try {
      Response response =
          given()
              .relaxedHTTPSValidation()
              .headers(headers)
              .queryParams(params)
              .baseUri(baseURI)
              .get(path)
              .then()
              .extract()
              .response();
      return Optional.of(response);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Optional.empty();
  }

  private Optional<Response> postListRequest(
      String baseURI, String path, Map<String, String> headers, List<Map<String, String>> body) {
    try {
      Response response =
          given()
              .relaxedHTTPSValidation()
              .headers(headers)
              .baseUri(baseURI)
              .body(body)
              .post(path)
              .then()
              .extract()
              .response();
      return Optional.of(response);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Optional.empty();
  }

  private Optional<Response> postRequest(
      String baseURI, String path, Map<String, String> headers, Map<String, String> body) {
    try {
      Response response =
          given()
              .relaxedHTTPSValidation()
              .headers(headers)
              .baseUri(baseURI)
              .body(body)
              .post(path)
              .then()
              .extract()
              .response();
      return Optional.of(response);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Optional.empty();
  }

  private Optional<Response> postJsonFileRequest(
      String baseURI, String path, Map<String, String> headers, String body) {
    try {
      Response response =
          given()
              .relaxedHTTPSValidation()
              .headers(headers)
              .baseUri(baseURI)
              .body(body)
              .post(path)
              .then()
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
              .relaxedHTTPSValidation()
              .headers(headers)
              .baseUri(baseURI)
              .delete(path)
              .then()
              .extract()
              .response();
      return Optional.of(response);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return Optional.empty();
  }
}
