import Backend.*;
import Enums.*;
import Person.Profile;
import Product.*;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ProfileTest {

    Book book;
    Book book2;
    Book book3;
    Movie movie;
    Movie movie2;
    Music music;
    Music music2;
    Entity manufacturer;
    Review bookreview;
    Basket basket;
    WishList wishlist;
    Order order;
    Address address;
    Profile profile;
    Address address2;
    PaymentCard card;
    PaymentCard card2;
    GiftCard giftcard;
    GiftCard giftcard2;



    @Before
    public void before() throws ParseException {
        manufacturer = new Entity("Sony");
        book = new Book("Harry Potter", BookFormat.PAPERBACK, "1/1/2018", Department.BOOKS, 1000.50,  100.00, Condition.NEW);
        book2 = new Book("Harry Potter 2", BookFormat.PAPERBACK, "1/1/2018", Department.BOOKS, 1000.50,  100.00, Condition.NEW);
        book3 = new Book("Harry Potter 3", BookFormat.PAPERBACK, "1/1/2018", Department.BOOKS, 1000.50,  100.00, Condition.NEW);
        music = new Music("Best of Enrique", MusicFormat.AUDIO_CD, "1/1/2018", Department.MUSIC, 20.50,  100.00, Condition.NEW);
        music2 = new Music("Best of Enrique 2", MusicFormat.AUDIO_CD, "1/1/2018", Department.MUSIC, 20.50,  100.00, Condition.NEW);
        movie = new Movie("Lord of the Rings", MovieFormat.BLU_RAY, "1/1/2018", Department.MOVIES, 20.50,  100.00, Condition.NEW);
        movie2 = new Movie("Lord of the Rings 2", MovieFormat.BLU_RAY, "1/1/2018", Department.MOVIES, 20.50,  100.00, Condition.NEW);
        bookreview = new Review(Rating.FIVE);
        basket = new Basket();
        wishlist = new WishList();
        order = new Order();
        address = new Address("8 Castle Terrace");
        address2 = new Address("30 CastleView Road");
        card = new PaymentCard("Vishal", "1234567891234567", ExpiryMonth.JANUARY, ExpiryYear.YEAR2019);
        card2 = new PaymentCard("Alex", "1234567891234567", ExpiryMonth.JANUARY, ExpiryYear.YEAR2019);
        profile = new Profile(basket, order, address, card, "codeclan@gmail.com", 07770617773, wishlist);
        giftcard = new GiftCard(Amount.HUNDRED, card);
        giftcard2 = new GiftCard(Amount.HUNDRED, card);

    }

    @Test
    public void canGetBasket(){
        profile.AddtoBasket(book);
        assertEquals(1, profile.getBasket().size());
        profile.AddtoBasket(movie);
        profile.deleteItemFromBasket(book);
        ArrayList<Product> list = new ArrayList<>();
        list.add(movie);
        assertEquals(list, profile.getBasket());
        profile.emptyBasket();
        assertEquals(0, profile.getBasket().size());
    }

    @Test
    public void addressMethodsWork(){
        profile.addAddresstoList(address2);
        assertEquals(2, profile.getAddressList().size());
        address.setDefaultDeliveryAddress(true);
        profile.changeDeliveryAddress(address2);
        assertEquals(true, address2.getDefaultDeliveryAddress());
        assertEquals(false, address.getDefaultDeliveryAddress());
        profile.deleteAddressFromList(address2);
        assertEquals(address, profile.getAddressList().get(0));
        profile.setDeliveryOption(DeliveryOption.STANDARD_DELIVERY);
        assertEquals(DeliveryOption.STANDARD_DELIVERY, profile.getDeliveryOption());
    }

    @Test
    public void canGetProfileProperties(){
        assertEquals("codeclan@gmail.com", profile.getEmail());
        assertEquals(07770617773, profile.getPhone());
        assertEquals(wishlist, profile.getWishList());
    }

    @Test
    public void orderMethodsWork(){
        LocalDate convertedDate30 = LocalDate.parse("1/15/2018", DateTimeFormatter.ofPattern("M/d/yyyy"));
        LocalDate convertedDate180 = LocalDate.parse("12/1/2017", DateTimeFormatter.ofPattern("M/d/yyyy"));
        LocalDate convertedDate2018 = LocalDate.parse("1/10/2018", DateTimeFormatter.ofPattern("M/d/yyyy"));
        LocalDate convertedDate2017 = LocalDate.parse("6/1/2017", DateTimeFormatter.ofPattern("M/d/yyyy"));
        book.setCheckOutDate(convertedDate30);
        book2.setCheckOutDate(convertedDate180);
        book3.setCheckOutDate(convertedDate30);
        movie.setCheckOutDate(convertedDate2018);
        music.setCheckOutDate(convertedDate2017);
        music2.setCheckOutDate(convertedDate2018);
        movie2.setCheckOutDate(convertedDate2017);
        profile.addItemToOrder(book);
        profile.addItemToOrder(book2);
        profile.addItemToOrder(book3);
        profile.addItemToOrder(movie);
        profile.addItemToOrder(movie2);
        profile.addItemToOrder(music);
        profile.addItemToOrder(music2);
        assertEquals(7, profile.getOrder().size());
        assertEquals(4, profile.getOrders(OrderRange.ONE).size());
        assertEquals(5, profile.getOrders(OrderRange.SIX).size());
        assertEquals(4, profile.getOrders(OrderRange.YEAR_2018).size());
        assertEquals(3, profile.getOrders(OrderRange.YEAR_2017).size());
    }

    @Test
    public void paymentMethodsWorks(){
        profile.addCard(card2);
        assertEquals(2, profile.getPayments().size());
        profile.deleteCard(card2);
        ArrayList<PaymentCard> list = new ArrayList<>();
        list.add(card);
        assertEquals(list, profile.getPayments());
        profile.addCard(card2);
        profile.setDefaultPaymentsCard(card2);
        assertEquals(true, card2.getDefaultCard());
        assertEquals(false, card.getDefaultCard());
        assertEquals(card2, profile.getDefaultPaymentsCard());
    }

    @Test
    public void giftcardMethodsWork(){
        profile.setGiftCard(giftcard);
        profile.addGiftCardBalance(giftcard2);
        assertEquals(200.00, profile.getGiftCardTotal(),0.01);
    }

    @Test
    public void canGetTotal(){
        profile.AddtoBasket(book);
        profile.AddtoBasket(book);
        profile.AddtoBasket(book);
        assertEquals(300.00,profile.getTotal(),0.01);
        profile.setGiftCard(giftcard);
        assertEquals(200.00,profile.newTotalAfterApplyingGiftCard(),0.01);
    }

}
