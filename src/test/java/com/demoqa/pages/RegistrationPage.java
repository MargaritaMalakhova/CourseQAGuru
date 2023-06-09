package com.demoqa.pages;
import com.codeborne.selenide.SelenideElement;

import java.io.File;

import com.demoqa.pages.components.CalendarComponent;
import com.demoqa.pages.components.DateBirthDto;
import com.demoqa.pages.components.ResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    // SelenideElements / locator / etc
    CalendarComponent calendarComponent = new CalendarComponent();
    ResultsModal resultsModal = new ResultsModal();
    SelenideElement formHeaderText = $(".practice-form-wrapper"),
    firstNameInput = $("#firstName"),
    lastNameInput = $("#lastName"),
    userGender = $("#genterWrapper"),
    userMailInput = $("#userEmail"),
    userNumberInput = $("#userNumber"),
    subjectsInput = $("#subjectsInput"),
    userHobbies = $("#hobbiesWrapper"),
    userPicture = $("#uploadPicture"),
    userAddressInput =  $("#currentAddress"),
    userStateInput = $("#state"),
    userCityInput = $("#city"),
    buttonSubmit = $("#submit"),
    dateOfBirthInput = $("#dateOfBirthInput");

    // Actions
    public RegistrationPage openPage() {
        open("/automation-practice-form");

        return this;
    }

    public RegistrationPage checkFormOnPage() {
        formHeaderText.shouldHave(text("Student Registration Form"));

        return this;
    }
    public RegistrationPage removeBunners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        userGender.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userMailInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserSubject(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    public RegistrationPage setUserHobbies(String value) {
        userHobbies.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserPicture(String value) {
        userPicture.uploadFile(new File(value));

        return this;
    }

    public RegistrationPage setUserAddress(String value) {
        userAddressInput.setValue(value);

        return this;
    }

    public RegistrationPage setUserState(String value) {
        userStateInput.click();
        $(byText(value)).click();

        return this;
    }

    public RegistrationPage setUserCity(String value) {
        userCityInput.click();
        $(byText(value)).click();

        return this;
    }

    public RegistrationPage clickSubmit() {
        buttonSubmit.click();

        return this;
    }

    @Deprecated
    public RegistrationPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setBirthDate(DateBirthDto dateBirthDto) {
        dateOfBirthInput.click();
        calendarComponent.setDate(dateBirthDto);

        return this;
    }

    public RegistrationPage verifyRegistrationResultsModalAppears(String value) {
        resultsModal.verifyModalAppears(value);

        return this;
    }

    public RegistrationPage verifyResult(String key, String value) {
        resultsModal.verifyResult(key, value);

        return this;
    }
}
