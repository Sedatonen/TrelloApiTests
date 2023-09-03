import org.junit.Assert;
import org.junit.Test;
import trello.models.response.createBoard.CreateBoardResponse;
import trello.models.response.createCard.CreateCardResponse;
import trello.models.response.createList.CreateListResponse;
import trello.models.response.updateCard.UpdateCardResponse;
import trello.services.TrelloService;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static trello.helpers.HelperMethods.*;
import static trello.verification.RequestSpec.requestSpecification;
import static trello.verification.ResponseSpec.checkStatusCodeOk;

public class TrelloTest {

    TrelloService trelloService = new TrelloService();

    @Test
    public void trelloApiTest() {

        String expectedBoardName = getRandomBoardName();

        CreateBoardResponse createBoardResponse = trelloService.createBoard(requestSpecification(), expectedBoardName, checkStatusCodeOk())
                .as(CreateBoardResponse.class);

        String boardId = createBoardResponse.getId();
        String actualBoardName = createBoardResponse.getName();

        Assert.assertEquals(expectedBoardName, actualBoardName);

        System.out.println(expectedBoardName + " ismiyle board oluşturuldu.");

        String expectedListName = getRandomListName();

        CreateListResponse createListResponse = trelloService.createList(requestSpecification(), expectedListName, boardId, checkStatusCodeOk())
                .as(CreateListResponse.class);

        String listId = createListResponse.getId();
        String actualListName = createListResponse.getName();

        Assert.assertEquals(expectedListName, actualListName);

        System.out.println(expectedListName + " ismiyle liste oluşturuldu.");

        String expectedFirstCardName = getRandomCardName();

        CreateCardResponse firstCardResponse = trelloService.createCard(requestSpecification(), listId, expectedFirstCardName, checkStatusCodeOk())
                .as(CreateCardResponse.class);

        String firstCardId = firstCardResponse.getId();
        String actualFirstCardName = firstCardResponse.getName();

        Assert.assertEquals(expectedFirstCardName, actualFirstCardName);

        System.out.println(expectedFirstCardName + " ismiyle ilk kart oluşturuldu.");

        String expectedSecondCardName = getRandomCardName();

        CreateCardResponse secondCardResponse = trelloService.createCard(requestSpecification(), listId, expectedSecondCardName, checkStatusCodeOk())
                .as(CreateCardResponse.class);

        String secondCardId = secondCardResponse.getId();
        String actualSecondCardName = secondCardResponse.getName();

        Assert.assertEquals(expectedSecondCardName, actualSecondCardName);

        System.out.println(expectedSecondCardName + " ismiyle ikinci kart oluşturuldu.");

        List<String> cardList = Arrays.asList(firstCardId, secondCardId);
        Random random = new Random();
        String expectedRandomCardId = cardList.get(random.nextInt(cardList.size()));

        String expectedRandomCardName = getRandomCardName() + " update";

        UpdateCardResponse updateCardResponse = trelloService.updateCard(requestSpecification(), expectedRandomCardId, expectedRandomCardName, checkStatusCodeOk())
                .as(UpdateCardResponse.class);

        String actualRandomCardId = updateCardResponse.getId();
        String actualRandomCardName = updateCardResponse.getName();

        Assert.assertEquals(expectedRandomCardId, actualRandomCardId);
        Assert.assertEquals(expectedRandomCardName, actualRandomCardName);

        System.out.println(expectedRandomCardName + " ismiyle random kart güncellendi.");


        trelloService.deleteCard(requestSpecification(), firstCardId, checkStatusCodeOk());

        System.out.println("İlk kart silindi.");

        trelloService.deleteCard(requestSpecification(), secondCardId, checkStatusCodeOk());

        System.out.println("İkinci kart silindi.");

        trelloService.deleteBoard(requestSpecification(), boardId, checkStatusCodeOk());

        System.out.println("Board silindi.");

        
    }
}
