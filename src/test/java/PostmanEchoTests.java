import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostmanEchoTests {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGetMethod() {
        given()
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .statusCode(200)
                .log().body()
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    public void testPostMethodFormData() {
        given()
            .contentType(ContentType.URLENC.withCharset("UTF-8"))
            .formParam("foo1", "bar1")
            .formParam("foo2", "bar2")
            .when()
                .post("/post")
            .then()
                .log().body()
                .statusCode(200)
                .body("args", equalTo(new HashMap<>()))
                .body("data", equalTo(""))
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("files", equalTo(new HashMap<>()))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", startsWith("t="))
                .body("headers.content-length", equalTo("19"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers.content-type", equalTo("application/x-www-form-urlencoded; charset=UTF-8"))
                .body("headers.accept", equalTo("*/*"))
                .body("json.foo1", equalTo("bar1"))
                .body("json.foo2", equalTo("bar2"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void testPostMethodRawText() {
        given()
                .contentType(ContentType.TEXT.withCharset("UTF-8"))
                .body("{\n    \"test\": \"value\"\n}")
                .when()
                .post("/post")
                .then()
                .log().body()
                .body("args", equalTo(new HashMap<>()))
                .body("data", equalTo("{\n    \"test\": \"value\"\n}"))
                .body("files", equalTo(new HashMap<>()))
                .body("form", equalTo(new HashMap<>()))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", startsWith("t="))
                .body("headers.content-length", equalTo("23"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers.content-type", equalTo("text/plain; charset=UTF-8"))
                .body("headers.accept", equalTo("*/*"))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void testPutMethod() {
        String request = "This is expected to be sent back as part of response body.";
        given()
                .contentType(ContentType.TEXT.withCharset("UTF-8"))
                .body(request)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("args", equalTo(new HashMap<>()))
                .body("data", equalTo(request))
                .body("files", equalTo(new HashMap<>()))
                .body("form", equalTo(new HashMap<>()))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", startsWith("t="))
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers.content-type", equalTo("text/plain; charset=UTF-8"))
                .body("headers.accept", equalTo("*/*"))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/put"));
    }


    @Test
    public void testPatchMethod() {
        String request = "This is expected to be sent back as part of response body.";
        given()
                .contentType(ContentType.TEXT.withCharset("UTF-8"))
                .body(request)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("args", equalTo(new HashMap<>()))
                .body("data", equalTo(request))
                .body("files", equalTo(new HashMap<>()))
                .body("form", equalTo(new HashMap<>()))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", startsWith("t="))
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers.content-type", equalTo("text/plain; charset=UTF-8"))
                .body("headers.accept", equalTo("*/*"))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/patch"));
    }

    @Test
    public void testDeleteMethod() {
        String request = "This is expected to be sent back as part of response body.";
        given()
                .contentType(ContentType.TEXT.withCharset("UTF-8"))
                .body(request)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("args", equalTo(new HashMap<>()))
                .body("data", equalTo(request))
                .body("files", equalTo(new HashMap<>()))
                .body("form", equalTo(new HashMap<>()))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.x-request-start", startsWith("t="))
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.x-amzn-trace-id", startsWith("Root="))
                .body("headers.content-type", equalTo("text/plain; charset=UTF-8"))
                .body("headers.accept", equalTo("*/*"))
                .body("json", equalTo(null))
                .body("url", equalTo("https://postman-echo.com/delete"));
    }
}
