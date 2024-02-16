package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class VoteTest extends BaseTest {

    @Test
    public void criarVotoComSucesso() {
        String requestBody = "{ \"image_id\": \"asf2\", \"value\": 1 }";

        given().contentType("application/json")
                .spec(requestSpec)
                .body(requestBody)
                .when().post("/votes")
                .then().statusCode(201)
                .body("message", equalTo("SUCCESS"));
    }

    @Test
    public void verificarPersistenciaDeVoto() {
        // Primeiro, criamos um voto
        String requestBody = "{ \"image_id\": \"asf2\", \"value\": 1 }";
        int voteId = given().contentType("application/json")
                .spec(requestSpec)
                .body(requestBody)
                .when().post("/votes")
                .then().extract().path("id");

        // Então, verificamos se o voto está listado
        given().contentType("application/json")
                .spec(requestSpec)
                .when().get("https://api.thecatapi.com/v1/votes")
                .then().statusCode(200)
                .body("findAll { it.id == " + voteId + " }.size()", is(1));
    }

    @Test
    public void listarVotosComSucesso() {
        given().contentType("application/json")
                .spec(requestSpec)
                .when().get("/votes")
                .then().statusCode(200)
                .body("id", notNullValue());
    }

    @Test
    public void deletarVotoComSucesso() {
        // Primeiro, criamos um voto
        String requestBody = "{ \"image_id\": \"asf2\", \"value\": 1 }";
        int voteId = given().contentType("application/json")
                .spec(requestSpec)
                .body(requestBody)
                .when().post("/votes")
                .then().extract().path("id");

        // Depois deletamos o voto
        given().contentType("application/json")
                .spec(requestSpec)
                .when().delete("/votes/" + voteId)
                .then().statusCode(200)
                .body("message", equalTo("SUCCESS"));
    }

    @Test
    public void falhaAoCriarVotoComImageIdInvalido() {
        String requestBody = "{ \"image_id\": \"\", \"value\": 1 }";

        given().contentType("application/json")
                .spec(requestSpec)
                .body(requestBody)
                .when().post("/votes")
                .then().statusCode(400)
                .body(containsString("is not allowed to be empty"));
    }

    @Test
    public void criarVotoComValorInvalido() {
        String requestBody = "{ \"image_id\": \"asf2\", \"value\": testbad }";

        given().contentType("application/json")
                .spec(requestSpec)
                .body(requestBody)
                .when().post("/votes")
                .then().statusCode(400)
                .body(containsString("Bad Request"));
    }

    @Test
    public void falhaAoDeletarVotoComIdInvalido() {
        int voteId = -1;

        given().contentType("application/json")
                .spec(requestSpec)
                .when().delete("/votes/" + voteId)
                .then().statusCode(404)
                .body( containsString("NO_VOTE_FOUND_MATCHING_ID"));
    }

}
