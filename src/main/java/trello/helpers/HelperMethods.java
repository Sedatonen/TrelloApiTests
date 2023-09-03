package trello.helpers;

import com.github.javafaker.Faker;


public class HelperMethods {


    public static String getRandomBoardName() {
        Faker faker = new Faker();

        return faker.pokemon().name();

    }

    public static String getRandomListName() {
        Faker faker = new Faker();

        return faker.dog().name();

    }

    public static String getRandomCardName() {
        Faker faker = new Faker();

        return faker.cat().name();

    }


}
