package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultsModal {
    // SelenideElements / locator / etc
    SelenideElement modalWindow = $(".modal-dialog"),
                    modalWindowTitle = $("#example-modal-sizes-title-lg"),
                    modalWindowTable = $(".table-responsive");

    // Actions
    public void verifyModalAppears(String value) {
        modalWindow.should(appear);
        modalWindowTitle.shouldHave(text(value));
    }

    public void verifyResult(String key, String value) {
        modalWindowTable.$(byText(key)).sibling(0).shouldHave(text(value));
    }
}
