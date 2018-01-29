package Enums;

public enum OrderRange {

    ONE(1),
    SIX(6),
    YEAR_2018(2018),
    YEAR_2017(2017);

    private final int value;

    OrderRange(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
