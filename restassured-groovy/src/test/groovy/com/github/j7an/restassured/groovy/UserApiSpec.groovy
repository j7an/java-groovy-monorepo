package com.github.j7an.restassured.groovy

import spock.lang.Specification
import io.restassured.RestAssured
import io.restassured.http.ContentType

import static io.restassured.RestAssured.*
import static org.hamcrest.Matchers.*
import static com.github.j7an.core.constants.ApiConstants.*

class UserApiSpec extends Specification {

    def setupSpec() {
        // Set the base URI for all features in this specification
        RestAssured.baseURI = BASE_URI
    }

    def "should get users for page 2"() {
        when: "a GET request is made to the users endpoint with parameters"
            def response = given()
                    .queryParam(QUERY_PARAM_PAGE, 2) // Chain queryParam here
                    .accept(ContentType.JSON)      // Chain accept here
                    .when() // Chain when()
                    .get(ENDPOINT_USERS)

        then: "the response should be successful and contain expected data"
        response.then() // Use response.then() for RestAssured assertions
                .statusCode(200)
                .contentType(ContentType.JSON) // Use RestAssured's contentType matcher
                .body("page", equalTo(2))      // Use Hamcrest matchers via .body()
                .body("data.size()", greaterThan(0)) // Example using GPath expression
    }
}