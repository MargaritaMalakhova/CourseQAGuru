package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import com.demoqa.pages.components.DateBirthDto;
import com.demoqa.utils.RandomUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("faker")
public class PracticeFormWithFakerDataTest extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    RandomUtils randomUtils = new RandomUtils();
    @Test
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

        registrationPage.openPage();
        registrationPage.checkFormOnPage();
        registrationPage.removeBunners();
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
        registrationPage.clickSubmit();

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

    }
}
