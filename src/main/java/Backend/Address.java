package Backend;

public class Address {

    String address;
    Boolean saturday;
    Boolean sunday;
    Boolean defaultDeliveryAddress;

    public Address(String Address){
        this.address = address;
        this.saturday = false;
        this.sunday = false;
        this.defaultDeliveryAddress = false;
    }

    public String getAddress() {
        return address;
    }

    public void setDefaultDeliveryAddress(Boolean defaultAddress){
        this.defaultDeliveryAddress = defaultAddress;
    }

    public Boolean getDeliveryAddress() {
        return this.defaultDeliveryAddress;
    }

    public Boolean getSaturday() {
        return saturday;
    }

    public Boolean getSunday() {
        return sunday;
    }

    public void editAddress(String address) {
        this.address = address;
    }

    public void setSaturday(Boolean saturday) {
        this.saturday = saturday;
    }

    public void setSunday(Boolean sunday) {
        this.sunday = sunday;
    }
}
