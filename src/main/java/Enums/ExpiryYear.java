package Enums;

public enum ExpiryYear {

    YEAR0("2017"),
    YEAR1("2018"),
    YEAR2("2019"),
    YEAR3("2020"),
    YEAR4("2021"),
    YEAR5("2022");

    private final String year;

    ExpiryYear(String year){
        this.year = year;
    }

    public String getYear() {
        return this.year;
    }
}
