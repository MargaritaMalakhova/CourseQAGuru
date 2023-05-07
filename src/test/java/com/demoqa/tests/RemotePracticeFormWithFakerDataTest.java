package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.pages.components.DateBirthDto;
import com.demoqa.utils.RandomUtils;
import io.qameta.allure.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class RemotePracticeFormWithFakerDataTest extends RemoteTestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();
    @Test
    @Tag("remote")
    @DisplayName("Successful registration")
    void successfulFormTest() {
        String
                firstName = randomUtils.createRandomFirstName(),
                lastName = randomUtils.createRandomLastName(),
                userEmail = randomUtils.createRandomEmail(),
                gender = randomUtils.createRandomGender(),
                mobileNumber = randomUtils.createRandomMobileNumber(),
                subject = randomUtils.createRandomSubject(),
                hobby = randomUtils.createRandomHobby(),
                currentAddress = randomUtils.createRandomCurrentAddress(),
                state = randomUtils.createRandomState(),
                city = randomUtils.createRandomCity(state);

        DateBirthDto dateBirthDto = randomUtils.createRandomDateBirth();
        step("Open Registration Form Page", () -> {
            registrationPage.openPage();
        });
        step("Check the Form displays on Page", () -> {
            registrationPage.checkFormOnPage();
        });
        step("Remove Bunners on Page", () -> {
            registrationPage.removeBunners();
        });
        step("Fill the Form", () -> {
            registrationPage.setFirstName(firstName);
            registrationPage.setLastName(lastName);
            registrationPage.setGender(gender);
            registrationPage.setUserEmail(userEmail);
            registrationPage.setUserNumber(mobileNumber);
            registrationPage.setBirthDate(dateBirthDto);
            registrationPage.setUserSubject(subject);
            registrationPage.setUserHobbies(hobby);
            registrationPage.setUserPicture("src/test/resources/538439.jpg");
            registrationPage.setUserAddress(currentAddress);
            registrationPage.setUserState(state);
            registrationPage.setUserCity(city);
        });
        step("Click on Submit Button", () -> {
            registrationPage.clickSubmit();
        });
        step("Verify results of filling the Form", () -> {
            registrationPage.verifyRegistrationResultsModalAppears("Thanks for submitting the form")
                    .verifyResult("Student Name", firstName + " " + lastName)
                    .verifyResult("Student Email", userEmail)
                    .verifyResult("Gender", gender)
                    .verifyResult("Mobile", mobileNumber)
                    .verifyResult("Date of Birth", dateBirthDto.getInCommaFormat())
                    .verifyResult("Subjects", subject)
                    .verifyResult("Hobbies", hobby)
                    .verifyResult("Picture", "538439.jpg")
                    .verifyResult("Address", currentAddress)
                    .verifyResult("State and City", state + " " + city);
        });
    }
}
