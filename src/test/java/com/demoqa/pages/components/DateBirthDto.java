package com.demoqa.pages.components;

public class DateBirthDto {
    private final String day;
    private final String month;
    private final String year;

    public DateBirthDto (String day, String month, String year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getInCommaFormat() {
        return day + " " + month + "," + year;
    }
}
