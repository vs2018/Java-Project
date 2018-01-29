package Backend;

import Enums.ExpiryMonth;
import Enums.ExpiryYear;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class PaymentCard extends Payment {

    String name;
    long number;
    LocalDate expiryDate;
    ExpiryMonth expiryMonth;
    ExpiryYear expiryYear;
    Address address;
    Boolean defaultCard;

    public PaymentCard(String name, String number, ExpiryMonth expiryMonth, ExpiryYear expiryYear) throws ParseException {
        if (!(number.length() == 16))
            throw new IllegalArgumentException(
                    "Number should be 16 characters long");
        this.name = name;
        setNumber(number);
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        setExpiryDate(getExpiryMonthValue(), getExpiryYearValue());
        this.defaultCard = false;
    }

    public Address getAddress() {
        return address;
    }

    public void setDefaultCard(){
        this.defaultCard = true;
    }

    public void removeDefaultCardSetting(){
        this.defaultCard = false;
    }

    public Boolean getDefaultCard() {
        return defaultCard;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void deleteAddress(){
        this.address = null;
    }

    public ExpiryMonth getExpiryMonth() {
        return this.expiryMonth;
    }

    public ExpiryYear getExpiryYear() {
        return this.expiryYear;
    }

    public String getExpiryMonthValue(){
        return getExpiryMonth().getMonth();
    }

    public String getExpiryYearValue(){
        return getExpiryYear().getYear();
    }

    private void setExpiryDate(String expiryMonth, String expiryYear) throws ParseException {
        String monthYear = expiryMonth + "/" + "13" + "/" + expiryYear;
        LocalDate convertedDate = LocalDate.parse(monthYear, DateTimeFormatter.ofPattern("M/d/yyyy"));
        convertedDate = convertedDate.withDayOfMonth(convertedDate.getMonth().length(convertedDate.isLeapYear()));
        this.expiryDate = convertedDate;
    }

    public LocalDate getExpiryDate() {
        return this.expiryDate;
    }

    public String setNumber(String number) {
        if(number.length() == 16){
            long digit = Long.valueOf(number).longValue();
            this.number = digit;
        }
        return "Incorrect number of digits entered";
    }

    public long getNumber() {
        return number;
    }

    public Boolean pay() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.now();
        if(localDate.compareTo(getExpiryDate())<0) {
            return true;
        }
        return false;
    }
}
