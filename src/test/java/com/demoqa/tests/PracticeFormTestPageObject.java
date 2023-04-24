package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.junit.jupiter.api.Test;


public class PracticeFormTestPageObject extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void successfulFormTest() {
        registrationPage.openPage();
        registrationPage.checkFormOnPage();
        registrationPage.removeBunners();
        registrationPage.setFirstName("Angelina");
        registrationPage.setLastName("Smith");
        registrationPage.setGender("Female");
        registrationPage.setUserEmail("asas@mail.ru");
        registrationPage.setUserNumber("1234567890");
        registrationPage.setBirthDate("01", "March", "2000");
        registrationPage.setUserSubject("comp");
        registrationPage.setUserHobbies("Reading");
        registrationPage.setUserPicture("src/test/resources/538439.jpg");
        registrationPage.setUserAddress("Some street 1");
        registrationPage.setUserState("NCR");
        registrationPage.setUserCity("Delhi");
        registrationPage.clickSubmit();

        registrationPage.verifyRegistrationResultsModalAppears("Thanks for submitting the form")
                .verifyResult("Student Name", "Angelina Smith")
                .verifyResult("Student Email", "asas@mail.ru")
                .verifyResult("Gender", "Female")
                .verifyResult("Mobile", "1234567890")
                .verifyResult("Date of Birth", "01 March,2000")
                .verifyResult("Subjects", "Computer Science")
                .verifyResult("Subjects", "Computer Science")
                .verifyResult("Hobbies", "Reading")
                .verifyResult("Picture", "538439.jpg")
                .verifyResult("Address", "Some street 1")
                .verifyResult("State and City", "NCR Delhi");

    }
}
