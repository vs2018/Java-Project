import Backend.Address;
import Backend.GiftCard;
import Backend.Payment;
import Backend.PaymentCard;
import Enums.Amount;
import Enums.ExpiryMonth;
import Enums.ExpiryYear;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

public class PaymentCardTest {

    PaymentCard card;
    Address address;

    @Before
    public void before() throws ParseException {
        address = new Address("8 Castle Terrace");
        card = new PaymentCard("Vishal", "1234567891234567", ExpiryMonth.JANUARY, ExpiryYear.YEAR2017);
    }

    @Test
    public void canGetAddress() {
        card.setAddress(address);
        assertEquals(address, card.getAddress());
        card.deleteAddress();
        assertEquals(null, card.getAddress());
    }

    @Test
    public void canGetDefaultCard() {
        card.setDefaultCard();
        assertEquals(true, card.getDefaultCard());
        card.removeDefaultCardSetting();
        assertEquals(false, card.getDefaultCard());
    }

    @Test
    public void canGetExpiryDatesAndValues() {
        assertEquals(ExpiryMonth.JANUARY, card.getExpiryMonth());
        assertEquals(ExpiryYear.YEAR2017, card.getExpiryYear());
        assertEquals("1", card.getExpiryMonthValue());
        assertEquals("2017", card.getExpiryYearValue());
    }

    @Test
    public void canGetExpiryDate(){
        LocalDate startDateFormatted = LocalDate.parse("31/1/2017", DateTimeFormatter.ofPattern("d/M/yyyy"));
        assertEquals(startDateFormatted, card.getExpiryDate());
    }

    @Test
    public void canGetLongCardNumber(){
        assertEquals(16, String.valueOf(card.getNumber()).length());
    }

    @Test
    public void canPay() throws ParseException {
        PaymentCard card2 = new PaymentCard("Vishal", "1234567891234567", ExpiryMonth.JANUARY, ExpiryYear.YEAR2018);
        assertEquals(true, card2.pay());
    }

    @Test
    public void canAddGiftCardAndPaymentCardToWallet() throws ParseException {
        PaymentCard card2 = new PaymentCard("Vishal", "1234567891234567", ExpiryMonth.JANUARY, ExpiryYear.YEAR2018);
        Payment wallet = new Payment();
        GiftCard giftcard = new GiftCard(Amount.HUNDRED, card);
        wallet.addCard(card2);
        wallet.addCard(giftcard);
        assertEquals(2, wallet.getCards().size());
    }


}
