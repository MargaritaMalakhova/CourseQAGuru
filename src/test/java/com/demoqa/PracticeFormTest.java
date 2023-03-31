package com.demoqa;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest extends TestBase {
    @Test
    void successfulFormTest() {
        open("automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Angelina");
        $("#lastName").setValue("Smith");
        $("div.col-md-9.col-sm-12 > div:nth-child(2)").click();
        $("#userEmail").setValue("asas@mail.ru");
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").click();
        $(byText("March")).click();
        $(".react-datepicker__year-select").click();
        $(byText("2000")).click();
        $(".react-datepicker__day--001").click();
        $("#subjectsInput").setValue("comp").pressEnter();
        $("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(2)").click();
        $("#uploadPicture").uploadFile(new File("src\\test\\resources\\538439.jpg"));
        $("#currentAddress").setValue("Some street 1");
        executeJavaScript("window.scrollBy(0,2500)");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")). click();
        $("#submit").click();
        $(".table").shouldHave(text("Angelina"), text("Smith"), text("Female"),text("asas@mail.ru"),
                text("1234567890"), text("March"), text("01"), text("2000"), text("Computer Science"),
                text("Reading"), text("538439.jpg"), text("Some street 1"), text("NCR"), text("Delhi"));
    }
}
