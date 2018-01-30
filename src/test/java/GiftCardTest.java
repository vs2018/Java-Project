import Backend.GiftCard;
import Backend.PaymentCard;
import Enums.Amount;
import Enums.ExpiryMonth;
import Enums.ExpiryYear;
import Enums.TopUpFrequency;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import static org.junit.Assert.assertEquals;

public class GiftCardTest {


    GiftCard giftcard;
    GiftCard giftcard2;
    PaymentCard card;

    @Before
    public void before() throws ParseException {
        card = new PaymentCard("Vishal", "1234567891234567", ExpiryMonth.JANUARY, ExpiryYear.YEAR2019);
        giftcard = new GiftCard(Amount.HUNDRED, card);
        giftcard2 = new GiftCard(Amount.HUNDRED, card);
    }

    @Test
    public void canGetAmount() {
        assertEquals(Amount.HUNDRED, giftcard.getAmount());
        assertEquals(100.00, giftcard.getAmountValue(), 0.01);
    }

    @Test
    public void canGetBalance() {
        assertEquals(100.00, giftcard.getBalance(), 0.01);
    }

    @Test
    public void canGetCard() {
        assertEquals(card, giftcard.getCard());
    }

    @Test
    public void canGetAutoTopUpSchedule() {
        giftcard.setAutoTopUpSchedule();
        assertEquals(true, giftcard.getAutoTopUpSchedule());
    }

    @Test
    public void canGetAutoTopUpThreshold() {
        giftcard.setAutoTopUpThreshold();
        assertEquals(true, giftcard.getAutoTopUpThreshold());
    }

    @Test
    public void canTopUpBalanceWithGiftCard() {
        giftcard.topUpBalanceWithGiftCard(giftcard2);
        assertEquals(200.00, giftcard.getBalance(), 0.01);
    }

    @Test
    public void canTopUp() {
        giftcard.topUp(Amount.HUNDRED, card);
        assertEquals(200.00, giftcard.getBalance(), 0.01);
    }

    @Test
    public void canAutoTopUpBalanceLow() {
        giftcard.setAutoTopUpThreshold();
        giftcard.autoTopUpBalanceLow(150.00, 200.00);
        assertEquals(300.00, giftcard.getBalance(), 0.01);
    }

    @Test
    public void canAutoTopUpSetFrequencyDAILY() {
        giftcard.autoTopUpSetFrequency("29/1/2018", TopUpFrequency.DAILY, 100.00);
        assertEquals(300.00, giftcard.getBalance(), 0.01);
    }

    @Test
    public void canAutoTopUpSetFrequencyWEEKLY() {
        giftcard.autoTopUpSetFrequency("1/1/2018", TopUpFrequency.WEEKLY, 100.00);
        assertEquals(600.00, giftcard.getBalance(), 0.01);
    }

    @Test
    public void canAutoTopUpSetFrequencyFORTNIGHTLY() {
        giftcard.autoTopUpSetFrequency("1/1/2018", TopUpFrequency.EVERY_2_WEEKS, 100.00);
        assertEquals(400.00, giftcard.getBalance(), 0.01);
    }

    @Test
    public void canAutoTopUpSetFrequencyMONTHLY() {
        giftcard.autoTopUpSetFrequency("29/12/2017", TopUpFrequency.MONTHLY, 100.00);
        assertEquals(300.00, giftcard.getBalance(), 0.01);
    }

    @Test
    public void canDecreaseGiftCardBalance() {
        giftcard.decreaseGiftCardBalance(50.00);
        assertEquals(50.00, giftcard.getBalance(), 0.01);
    }

    @Test
    public void canResetGiftCardBalanceToZero() {
        giftcard.resetGiftCardBalance();
        assertEquals(0.00, giftcard.getBalance(), 0.01);
    }
}









