package Enums;

public enum Amount {

    FIFTY(50.00),
    HUNDRED(100.00),
    TWO_HUNDRED(200.00),
    THREE_HUNDRED(300.00);

    private final double value;

    Amount(double value){
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
