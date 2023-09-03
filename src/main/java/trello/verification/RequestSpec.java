package trello.verification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;



import static trello.constants.TrelloConstants.TRELLO_API_URL;


public class RequestSpec {


    private RequestSpec() {

    }

    public static RequestSpecification requestSpecification() {

        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .setBaseUri(TRELLO_API_URL)
                .build();


    }

}
