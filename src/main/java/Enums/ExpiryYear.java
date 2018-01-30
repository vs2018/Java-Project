package Enums;

public enum ExpiryYear {

    YEAR2017("2017"),
    YEAR2018("2018"),
    YEAR2019("2019"),
    YEAR2020("2020"),
    YEAR2021("2021"),
    YEAR2022("2022");

    private final String year;

    ExpiryYear(String year){
        this.year = year;
    }

    public String getYear() {
        return this.year;
    }
}
