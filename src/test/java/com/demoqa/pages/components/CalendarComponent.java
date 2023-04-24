package com.demoqa.pages.components;

import com.codeborne.selenide.SelenideElement;

import  java.lang.String;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    // SelenideElements / locator / etc
    SelenideElement monthSelect = $(".react-datepicker__month-select"),
    yearSelect = $(".react-datepicker__year-select");

    // Actions
    @Deprecated
    public void setDate(String day, String month, String year) {
        monthSelect.selectOption(month);
        yearSelect.selectOption(year);

        String dayPickerLocator = String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", day);
        $(dayPickerLocator).click();
    }

    public void setDate(DateBirthDto dateBirth) {
        monthSelect.selectOption(dateBirth.getMonth());
        yearSelect.selectOption(dateBirth.getYear());

        String dayPickerLocator = String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)",
                dateBirth.getDay());
        $(dayPickerLocator).click();
    }
}
