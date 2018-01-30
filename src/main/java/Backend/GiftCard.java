package Backend;

import Enums.Amount;
import Enums.TopUpFrequency;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class GiftCard extends Payment {

    Amount amount;
    double balance;
    PaymentCard card;
    Boolean autoTopUpSchedule;
    Boolean autoTopUpThreshold;


    public GiftCard(Amount amount, PaymentCard card){
        this.amount = amount;
        this.card = card;
        topUp(amount, card);
        this.autoTopUpSchedule = false;
        this.autoTopUpThreshold = false;
    }

    public PaymentCard getCard() {
        return card;
    }

    public Boolean getAutoTopUpSchedule() {
        return autoTopUpSchedule;
    }

    public Boolean getAutoTopUpThreshold() {
        return autoTopUpThreshold;
    }

    public void topUpBalanceWithGiftCard(GiftCard card){
        this.balance += card.getBalance();
    }

    public Amount getAmount() {
        return this.amount;
    }

    public double getBalance(){
        return this.balance;
    }

    public void setAutoTopUpSchedule(){
        this.autoTopUpSchedule = true;
    }

    public void setAutoTopUpThreshold(){
        this.autoTopUpThreshold = true;
    }

    public double getAmountValue(){
        return getAmount().getValue();
    }

    public void topUp(Amount amount, PaymentCard card) {
            double value = getAmountValue();
            if(card.pay()){
                this.balance += value;
            }
    }

    public void autoTopUpBalanceLow(double threshold, double topUpAmount){
//        if(card.pay()){
//            this.balance += topUpAmount;
//        }

        if(autoTopUpThreshold == true) {
            if(card.pay()){
                if (getBalance() < threshold) {
                    this.balance += topUpAmount;
                }
            }
        }
    }

    public void autoTopUpSetFrequency(String startDate, TopUpFrequency frequency, double topUpAmount) {
        LocalDate startDateFormatted = LocalDate.parse(startDate, DateTimeFormatter.ofPattern("d/M/yyyy"));
        LocalDate today = LocalDate.now();
        LocalDate endDate = today.plusYears(1);
        if (card.pay()) {
            this.balance += 100;
        }
        if (frequency == TopUpFrequency.DAILY) {
            long daysBetween = ChronoUnit.DAYS.between(startDateFormatted, today);
            for(int i = 0; i < daysBetween; i++) {
                    if (card.pay()) {
                        this.balance += topUpAmount;
                    }
            }
        }
        if (frequency == TopUpFrequency.WEEKLY) {
            long weeksBetween = ChronoUnit.WEEKS.between(startDateFormatted, today);
            for (int i = 0; i < weeksBetween; i++) {
                    if (card.pay()) {
                        this.balance += topUpAmount;
                    }
                }

        }
        if (frequency == TopUpFrequency.EVERY_2_WEEKS) {
            double twoWeeksBetween = ChronoUnit.WEEKS.between(startDateFormatted, today);
            double dummyTwoWeeksBetween = twoWeeksBetween / 2;
            for (int i = 0; i < dummyTwoWeeksBetween; i++) {
                    if (card.pay()) {
                        this.balance += topUpAmount;
                    }
            }
        }
        if (frequency == TopUpFrequency.MONTHLY) {
            long monthsBetween = ChronoUnit.MONTHS.between(startDateFormatted, today);
            for (int i = 0; i < monthsBetween; i++) {
                if (card.pay()) {
                    this.balance += topUpAmount;
                }
            }
        }

    }


    public void decreaseGiftCardBalance(double basketTotal) {
        this.balance -= basketTotal;
    }

    public void resetGiftCardBalance() {
        this.balance = 0.00;
    }
}
