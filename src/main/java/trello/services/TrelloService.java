package trello.services;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


import static io.restassured.RestAssured.given;
import static trello.constants.TrelloConstants.TRELLO_API_KEY;
import static trello.constants.TrelloConstants.TRELLO_API_TOKEN;

public class TrelloService {

    public static final String BOARDS_BASE_PATH = "boards/";

    public static final String LISTS_BASE_PATH = "lists/";

    public static final String CARDS_BASE_PATH = "cards/";

    public Response createBoard(RequestSpecification requestSpec, String name, ResponseSpecification responseSpec) {

        return given()
                .spec(requestSpec)
                .basePath(BOARDS_BASE_PATH)
                .queryParam("name", name)
                .queryParam("key", TRELLO_API_KEY)
                .queryParam("token", TRELLO_API_TOKEN)
                .when()
                .post()
                .then()
                .assertThat()
                .log().ifValidationFails()
                .spec(responseSpec)
                .extract().response();
    }

    public Response createList(RequestSpecification requestSpec, String name, String idBoard, ResponseSpecification responseSpec) {

        return given()
                .spec(requestSpec)
                .basePath(LISTS_BASE_PATH)
                .queryParam("idBoard", idBoard)
                .queryParam("name", name)
                .queryParam("key", TRELLO_API_KEY)
                .queryParam("token", TRELLO_API_TOKEN)
                .when()
                .post()
                .then()
                .assertThat()
                .log().ifValidationFails()
                .spec(responseSpec)
                .extract().response();
    }

    public Response createCard(RequestSpecification requestSpec, String listId, String name, ResponseSpecification responseSpec) {

        return given()
                .spec(requestSpec)
                .basePath(CARDS_BASE_PATH)
                .queryParam("idList", listId)
                .queryParam("name", name)
                .queryParam("key", TRELLO_API_KEY)
                .queryParam("token", TRELLO_API_TOKEN)
                .when()
                .post()
                .then()
                .assertThat()
                .log().ifValidationFails()
                .spec(responseSpec)
                .extract().response();
    }

    public Response updateCard(RequestSpecification requestSpec, String cardId, String name, ResponseSpecification responseSpec) {

        return given()
                .spec(requestSpec)
                .basePath(CARDS_BASE_PATH + "{id}/")
                .pathParam("id", cardId)
                .queryParam("name", name)
                .queryParam("key", TRELLO_API_KEY)
                .queryParam("token", TRELLO_API_TOKEN)
                .when()
                .put()
                .then()
                .assertThat()
                .log().ifValidationFails()
                .spec(responseSpec)
                .extract().response();
    }

    public Response deleteCard(RequestSpecification requestSpec, String cardId, ResponseSpecification responseSpec) {

        return given()
                .spec(requestSpec)
                .basePath(CARDS_BASE_PATH + "{id}/")
                .pathParam("id", cardId)
                .queryParam("key", TRELLO_API_KEY)
                .queryParam("token", TRELLO_API_TOKEN)
                .when()
                .delete()
                .then()
                .assertThat()
                .log().ifValidationFails()
                .spec(responseSpec)
                .extract().response();
    }

    public Response deleteBoard(RequestSpecification requestSpec, String boardId, ResponseSpecification responseSpec) {

        return given()
                .spec(requestSpec)
                .basePath(BOARDS_BASE_PATH + "{id}/")
                .pathParam("id", boardId)
                .queryParam("key", TRELLO_API_KEY)
                .queryParam("token", TRELLO_API_TOKEN)
                .when()
                .delete()
                .then()
                .assertThat()
                .log().ifValidationFails()
                .spec(responseSpec)
                .extract().response();
    }


}
