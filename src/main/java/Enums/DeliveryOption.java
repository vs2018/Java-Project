package Enums;

public enum DeliveryOption {

    FREE_DELIVERY(0.00),
    STANDARD_DELIVERY(2.99),
    ONE_DAY_DELIVERY(5.00),
    EXPRESS_DELIVERY(6.49),
    EVENING_DELIVERY(6.99);

    private final double value;

    DeliveryOption(double value){
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
