package com.demoqa.utils;

import com.demoqa.pages.components.DateBirthDto;
import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static com.google.gson.internal.bind.util.ISO8601Utils.format;

public class RandomUtils {
    Faker faker = new Faker(new Locale("en-IND"));
    //написать метод который генерирует и возвращает дто

    String[]
            gendersChoice = {"Male", "Female", "Other"},
            subjectsChoice = {"Hindi", "English", "Maths", "Physics", "Chemistry", "Biology", "Computer Science",
                    "Commerce", "Accounting", "Economics", "Arts", "Social Studies", "History", "Civics"},
            hobbiesChoice = {"Sports", "Reading", "Music"},
            statesChoice = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"},
            citiesOfNCR = {"Delhi", "Gurgaon", "Noida"},
            citiesOfUttarPradesh = {"Agra", "Lucknow", "Merrut"},
            citiesOfHaryana = {"Karnal", "Panipat"},
            citiesOfRajasthan = {"Jaipur", "Jaiselmer"};

    public String createRandomFirstName() {

        return faker.name().firstName();
    }

    public String createRandomLastName() {

        return faker.name().lastName();
    }

    public String createRandomEmail() {

        return faker.internet().emailAddress();
    }

    public String createRandomGender() {

        return faker.options().option(gendersChoice);
    }

    public String createRandomMobileNumber() {

        return faker.numerify("##########");
    }

    public DateBirthDto createRandomDateBirth() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyy MMMM dd", Locale.ENGLISH);
        String str = sdf.format(faker.date().birthday());
        String[] date = str.split(" ");
        return new DateBirthDto(date[2], date[1], date[0]);
    }
    public String createRandomSubject() {

        return faker.options().option(subjectsChoice);
    }

    public String createRandomHobby() {

        return faker.options().option(hobbiesChoice);
    }

    public String createRandomCurrentAddress() {

        return faker.address().streetAddress();
    }

    public String createRandomState() {

        return faker.options().option(statesChoice);
    }

    public String createRandomCity(String state) {
        switch (state) {
            case "NCR": {
                return faker.options().option(citiesOfNCR);
            }
            case "Uttar Pradesh": {
                return faker.options().option(citiesOfUttarPradesh);
            }
            case "Haryana": {
                return faker.options().option(citiesOfHaryana);
            }
            case "Rajasthan": {
                return faker.options().option(citiesOfRajasthan);
            }
        }
        return null;
    }
}
