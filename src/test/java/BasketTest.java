import Backend.*;
import Enums.*;
import Person.Entity;
import Person.Profile;
import Product.*;
import org.junit.Before;
import org.junit.Test;
import sun.font.TrueTypeFont;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class BasketTest {

    Book book;
    Book book2;
    Book book3;
    Electronic electronic;
    Movie movie;
    Movie movie2;
    Movie movie3;
    Music music;
    Music music2;
    Entity manufacturer;
    Inventory inventory;
    Product product;
    Review bookreview;
    Basket basket;
    WishList wishlist;
    Shop shop;
    Payment payment;
    Order order;
    Inventory Inventory;
    Address address;
    Profile profile;
    Profile profile2;
    Profile profile3;
    Profile profile4;
    Order order2;
    Basket basket2;
    Basket basket3;
    Basket basket4;
    Order order3;
    Order order4;
    Address address2;
    PaymentCard card;
    PaymentCard card2;
    PaymentCard card3;



    @Before
    public void before() throws ParseException {
        inventory = new Inventory();
        manufacturer = new Entity("Sony");
        book = new Book("Harry Potter", BookFormat.PAPERBACK, "26-01-2018", Department.BOOKS, 1000.50,  100.00, Condition.NEW);
        book2 = new Book("Harry Potter 2", BookFormat.PAPERBACK, "26-01-2018", Department.BOOKS, 20.50,  100.00, Condition.NEW);
        book3 = new Book("Harry Potter 3", BookFormat.PAPERBACK, "26-01-2018", Department.BOOKS, 20.50,  100.00, Condition.NEW);
        music2 = new Music("Best of Enrique 2", MusicFormat.AUDIO_CD, "26-01-2018", Department.MUSIC, 100.00,  100.00, Condition.NEW);
        music = new Music("Best of Enrique", MusicFormat.AUDIO_CD, "26-01-2018", Department.MUSIC, 20.50,  100.00, Condition.NEW);
        movie = new Movie("Lord of the Rings", MovieFormat.BLU_RAY, "26-01-2018", Department.MOVIES, 20.50,  100.00, Condition.NEW);
        movie2 = new Movie("Lord of the Rings 2", MovieFormat.BLU_RAY, "26-01-2018", Department.MOVIES, 20.50,  100.00, Condition.NEW);
        movie3 = new Movie("Lord of the Rings 3", MovieFormat.BLU_RAY, "26-01-2018", Department.MOVIES, 20.50,  100.00, Condition.NEW);
        electronic = new Electronic("IPhone Camera", ElectronicType.CAMERA, "26-01-2018", Department.ELECTRONIC, 20.50,  100.00, Condition.NEW, manufacturer);
        bookreview = new Review(Rating.FIVE);
        basket = new Basket();
        wishlist = new WishList();
        payment = new Payment();
        order = new Order();
        address = new Address("8 Castle Terrace");
        address.setSaturday(true);
        address.setSunday(false);
        address2 = new Address("30 CastleView Road");
        address2.setDefaultDeliveryAddress(true);
        order2 = new Order();
        order3 = new Order();
        order4 = new Order();
        basket2 = new Basket();
        basket3 = new Basket();
        basket4 = new Basket();
        card = new PaymentCard("Vishal", "1234567891234567", ExpiryMonth.JANUARY, ExpiryYear.YEAR3);
        card2 = new PaymentCard("Alex", "1234567891234567", ExpiryMonth.JANUARY, ExpiryYear.YEAR3);
        card3 = new PaymentCard("John", "1234567891234567", ExpiryMonth.JANUARY, ExpiryYear.YEAR3);
        profile = new Profile(basket, order, address, card, "codeclan@gmail.com", 07770617773, wishlist);
        profile.addAddresstoList(address2);
        profile.addCard(card2);
        profile.addCard(card3);
        profile2 = new Profile(basket3, order3, address, card2, "edinburgh@gmail.com", 07770617773, wishlist);
        profile3 = new Profile(basket4, order4, address, card3, "glasgow@gmail.com", 07770617773, wishlist);
        profile4 = new Profile(basket2, order2, address, card, "glasgow@gmail.com", 07770617773, wishlist);
        shop = new Shop(inventory);
    }

    @Test
    public void canGetBasketQuantity() {
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        shop.addProfile(profile);
        shop.addProfile(profile2);
        shop.addProfile(profile3);
        inventory.setInventory(movie);
        inventory.setInventory(movie);
        inventory.setInventory(movie);
        inventory.setInventory(movie);
        inventory.setInventory(movie);
        inventory.setInventory(music);
        assertEquals("No stock available, check again at a later date", shop.addItemToBasket(electronic, 9, profile2));
    }

    @Test
    public void deleteItemFromBasket(){
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        shop.addProfile(profile);
        shop.addProfile(profile2);
        shop.addProfile(profile3);
        inventory.setInventory(movie);
        inventory.setInventory(movie);
        inventory.setInventory(movie);
        inventory.setInventory(movie);
        inventory.setInventory(movie);
        inventory.setInventory(music);
        shop.addItemToBasket(movie, 1, profile2);
        shop.addItemToBasket(book, 1, profile2);
        profile2.deleteItemFromBasket(movie);
        assertEquals(1, profile2.getBasket().size());
    }

    @Test
    public void canCheckout(){
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        assertEquals(6, inventory.getInventory().size());
//        shop.addProfile(profile);
        shop.addProfile(profile4);
        assertEquals(1, shop.getProfile().size());
        shop.addItemToBasket(book, 4, profile4);
        assertEquals(4, profile4.getBasket().size());
//////        shop.addItemToBasket(book, 3, profile2);
        shop.checkout(profile4);
//        assertEquals("Successfully checked out", shop.checkout(profile4));
        assertEquals(0, profile4.getBasket().size());
        assertEquals(2, inventory.getInventory().size());
        assertEquals(4, profile4.getOrder().size());
    }

    @Test
    public void canCheckoutMultipleProfiles(){
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(music);
        inventory.setInventory(music);
        inventory.setInventory(movie);
        inventory.setInventory(movie);
        inventory.setInventory(movie);
        assertEquals(11, inventory.getInventory().size());
        shop.addProfile(profile);
        shop.addProfile(profile4);
        assertEquals(2, shop.getProfile().size());
        shop.addItemToBasket(book, 4, profile4);
        shop.addItemToBasket(music, 1, profile4);
        assertEquals(5, profile4.getBasket().size());
        shop.addItemToBasket(book, 2, profile);
        shop.addItemToBasket(music, 1, profile);
        shop.addItemToBasket(movie, 2, profile);
        assertEquals(5, profile.getBasket().size());
////////        shop.addItemToBasket(book, 3, profile2);
        shop.checkout(profile4);
        shop.checkout(profile);
//        assertEquals("Successfully checked out", shop.checkout(profile4));
        assertEquals(0, profile4.getBasket().size());
        assertEquals(0, profile.getBasket().size());
        assertEquals(1, inventory.getInventory().size());
        assertEquals(5, profile4.getOrder().size());
        assertEquals(5, profile.getOrder().size());
    }

    @Test
    public void canCheckoutMultipleTypeofItems(){
        inventory.setInventory(book);
        inventory.setInventory(book2);
        inventory.setInventory(book3);
        inventory.setInventory(music);
        inventory.setInventory(music2);
        inventory.setInventory(movie);
        inventory.setInventory(movie2);
        inventory.setInventory(movie3);
        assertEquals(8, inventory.getInventory().size());
        shop.addProfile(profile);
        shop.addProfile(profile2);
        shop.addProfile(profile3);
        shop.addProfile(profile4);
        assertEquals(4, shop.getProfile().size());
        shop.addItemToBasket(book, 1, profile4);
        shop.addItemToBasket(book2, 1, profile4);
        shop.addItemToBasket(music, 1, profile4);
        shop.addItemToBasket(movie, 1, profile4);
        shop.addItemToBasket(movie2, 1, profile4);
        assertEquals(5, profile4.getBasket().size());
        shop.addItemToBasket(book3, 1, profile);
        shop.addItemToBasket(music2, 1, profile);
        shop.addItemToBasket(movie3, 1, profile);
        assertEquals(3, profile.getBasket().size());
////////        shop.addItemToBasket(book, 3, profile2);
        shop.checkout(profile4);
        shop.checkout(profile);
//        shop.checkout(profile3);
//        shop.checkout(profile2);
//        assertEquals("Successfully checked out", shop.checkout(profile4));
        assertEquals(0, profile4.getBasket().size());
        assertEquals(0, profile.getBasket().size());
//        assertEquals(0, profile.getBasket().size());
//        assertEquals(0, profile.getBasket().size());
        assertEquals(0, inventory.getInventory().size());
        assertEquals(5, profile4.getOrder().size());
        assertEquals(3, profile.getOrder().size());
        assertEquals(8, inventory.getSold().size());
    }

    @Test
    public void canGetAddresses(){
        Address address2 = new Address("30 Marchemont square");
        profile4.addAddresstoList(address2);
        assertEquals(2, profile4.getAddressList().size());
        profile4.deleteAddressFromList(address2);
        assertEquals(1, profile4.getAddressList().size());
        assertEquals(address, profile4.getAddressList().get(0));
        assertEquals(true, profile4.getAddressList().get(0).getSaturday());
    }

    @Test
    public void canGetExpiryDateOfCard() throws ParseException {
        PaymentCard card = new PaymentCard("Vishal", "1234567891234567", ExpiryMonth.JANUARY, ExpiryYear.YEAR3);
//        LocalDate localDate = LocalDate.of( 2020 , 8 , 31 );
//        assertEquals(localDate, card.getExpiryDate());
        assertEquals(true, card.pay());
    }

    @Test
    public void canAutoTopUpBalance() throws ParseException {
        PaymentCard card = new PaymentCard("Vishal", "1234567891234567", ExpiryMonth.JANUARY, ExpiryYear.YEAR3);
        GiftCard giftCard = new GiftCard(Amount.HUNDRED, card);
//        assertEquals(100, giftCard.getBalance(), 0.01);
        giftCard.setAutoTopUpThreshold();
        giftCard.autoTopUpBalanceLow(200.0, 50.0);
        assertEquals(150.0, giftCard.getBalance(), 0.01);
    }

    @Test
    public void canAutoTopUpSchedule() throws ParseException {
        PaymentCard card = new PaymentCard("Vishal", "1234567891234567", ExpiryMonth.JANUARY, ExpiryYear.YEAR3);
        GiftCard giftCard = new GiftCard(Amount.HUNDRED, card);
//        giftCard.autoTopUpSetFrequency("29/11/2017", TopUpFrequency.DAILY, 100.00);
//        assertEquals(6200.0, giftCard.getBalance(), 0.01);
//        giftCard.autoTopUpSetFrequency("9/1/2018", TopUpFrequency.WEEKLY, 100.00);
//        assertEquals(400.0, giftCard.getBalance(), 0.01);
//        giftCard.autoTopUpSetFrequency("9/1/2018", TopUpFrequency.EVERY_2_WEEKS, 100.00);
//        assertEquals(300.0, giftCard.getBalance(), 0.01);
//        giftCard.autoTopUpSetFrequency("4/12/2017", TopUpFrequency.EVERY_2_WEEKS, 100.00);
//        assertEquals(600.0, giftCard.getBalance(), 0.01);
        giftCard.autoTopUpSetFrequency("4/11/2017", TopUpFrequency.MONTHLY, 100.00);
        assertEquals(400.0, giftCard.getBalance(), 0.01);
    }

    @Test
    public void canGetAddressList(){
        assertEquals(2, profile.getAddressList().size());
    }

    @Test
    public void canGetDefaultAddress(){
        assertEquals(true, address2.getDeliveryAddress());
    }

    @Test
    public void canGetProfile(){
        shop.addProfile(profile);
        shop.addProfile(profile2);
        shop.addProfile(profile4);
        assertEquals(profile, shop.getSpecificProfile(profile));
    }


    @Test
    public void canCompleteCheckout() throws ParseException {
        inventory.setInventory(book);
        inventory.setInventory(book2);
        inventory.setInventory(book3);
        inventory.setInventory(music);
        inventory.setInventory(music2);
        inventory.setInventory(movie);
        inventory.setInventory(movie2);
        inventory.setInventory(movie3);
        inventory.setInventory(electronic);
        shop.addProfile(profile);
        shop.addProfile(profile2);
        shop.addProfile(profile4);
        shop.addItemToBasket(book, 1, profile4);
        shop.addItemToBasket(book2, 1, profile4);
        shop.addItemToBasket(music, 1, profile4);
        shop.addItemToBasket(movie, 1, profile4);
        shop.addItemToBasket(movie2, 1, profile4);
        shop.addItemToBasket(book, 1, profile);
        shop.addItemToBasket(music2, 1, profile);
        shop.addItemToBasket(movie3, 1, profile);
        shop.addItemToBasket(electronic, 1, profile2);
        assertEquals(address2, shop.getDefaultDeliveryAddress(profile));
        profile.changeDeliveryAddress(address);
        assertEquals(address, shop.getDefaultDeliveryAddress(profile));
        profile.addAddress(new Address("10 MountView Road"));
        assertEquals(3, profile.getAddressList().size());
        assertEquals(3, profile.getPayments().size());
        profile.setDefaultPaymentsCard(card2);
        assertEquals(card2, profile.getDefaultPaymentsCard());

    }

    @Test
    public void canCalculateTotal(){
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(music);
        inventory.setInventory(music);
        inventory.setInventory(music);
        shop.addProfile(profile);
        shop.addProfile(profile2);
        shop.addItemToBasket(book, 2, profile);
        shop.addItemToBasket(music, 2, profile);
        profile.setDeliveryOption(DeliveryOption.ONE_DAY_DELIVERY);
        assertEquals(5.00, basket.getDeliveryPrice(),0.01);
        assertEquals(405.00, basket.getBasketTotal(),0.01);
        assertEquals(405.00, profile.getTotal(),0.01);
        GiftCard giftCard = new GiftCard(Amount.HUNDRED, card);
        GiftCard giftCard2 = new GiftCard(Amount.HUNDRED, card2);
        GiftCard giftCard3 = new GiftCard(Amount.HUNDRED, card3);
        GiftCard giftCard4 = new GiftCard(Amount.HUNDRED, card3);
        GiftCard giftCard5 = new GiftCard(Amount.HUNDRED, card3);
        profile.setGiftCard(giftCard);
        profile.addGiftCardBalance(giftCard2);
        profile.addGiftCardBalance(giftCard3);
        profile.addGiftCardBalance(giftCard4);
        profile.addGiftCardBalance(giftCard5);
        assertEquals(0.0, profile.newTotalAfterApplyingGiftCard(), 0.01);
        assertEquals(95.00,profile.getGiftCardBalance(), 0.01);
        shop.checkout(profile);
        assertEquals(4, inventory.getSold().size());
        assertEquals(2, inventory.getInventory().size());
        assertEquals(4, profile.getOrder().size());
    }

    @Test
    public void canBuy(){
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(music);
        inventory.setInventory(music);
        inventory.setInventory(music);
        shop.addProfile(profile);
        shop.addItemToBasket(book, 2, profile);
        shop.addItemToBasket(music, 2, profile);
        profile.setDeliveryOption(DeliveryOption.ONE_DAY_DELIVERY);
        GiftCard giftCard = new GiftCard(Amount.HUNDRED, card);
        GiftCard giftCard2 = new GiftCard(Amount.HUNDRED, card2);
        GiftCard giftCard3 = new GiftCard(Amount.HUNDRED, card3);
        GiftCard giftCard4 = new GiftCard(Amount.HUNDRED, card3);
        GiftCard giftCard5 = new GiftCard(Amount.HUNDRED, card3);
        profile.setGiftCard(giftCard);
        profile.addGiftCardBalance(giftCard2);
        profile.addGiftCardBalance(giftCard3);
        profile.addGiftCardBalance(giftCard4);
        profile.addGiftCardBalance(giftCard5);
        shop.buy(profile, "1/29/2018");
        LocalDate localDate = LocalDate.now();
        assertEquals(localDate, profile.getOrder().get(1).getCheckOutDate());
    }

    @Test
    public void canGetOrderHistoryByRange(){
        inventory.setInventory(book);
        inventory.setInventory(book2);
        inventory.setInventory(book);
        inventory.setInventory(music);
        inventory.setInventory(music2);
        inventory.setInventory(music);
        shop.addProfile(profile);
//        shop.addItemToBasket(book, 1, profile);
//        shop.addItemToBasket(music, 1, profile);
        profile.setDeliveryOption(DeliveryOption.ONE_DAY_DELIVERY);
        GiftCard giftCard = new GiftCard(Amount.HUNDRED, card);
        GiftCard giftCard2 = new GiftCard(Amount.HUNDRED, card2);
        GiftCard giftCard3 = new GiftCard(Amount.HUNDRED, card3);
        GiftCard giftCard4 = new GiftCard(Amount.HUNDRED, card3);
        GiftCard giftCard5 = new GiftCard(Amount.HUNDRED, card3);
        profile.setGiftCard(giftCard);
        profile.addGiftCardBalance(giftCard2);
        profile.addGiftCardBalance(giftCard3);
        profile.addGiftCardBalance(giftCard4);
        profile.addGiftCardBalance(giftCard5);
//        shop.buy(profile, "1/25/2018");
//        assertEquals(0, profile.getBasket().size());
//        assertEquals(2, profile.getOrders(OrderRange.ONE).size());
//        assertEquals(2, profile.getOrders(OrderRange.YEAR_2018).size());
        shop.addItemToBasket(book, 1, profile);
        shop.addItemToBasket(music, 1, profile);
//        profile.setDeliveryOption(DeliveryOption.ONE_DAY_DELIVERY);
//        GiftCard giftCard6 = new GiftCard(Amount.THREE_HUNDRED, card);
//        profile.setGiftCard(giftCard6);
        shop.buy(profile, "12/1/2017");
        assertEquals(2, profile.getOrders(OrderRange.YEAR_2017).size());


//        assertEquals(2, profile.getOrders(OrderRange.SIX).size());
//        assertEquals(0, profile.getBasket().size());
        shop.addItemToBasket(book2, 1, profile);
        shop.addItemToBasket(music2, 1, profile);
        shop.buy(profile, "12/1/2018");
        assertEquals(4, profile.getOrder().size());
        assertEquals(2, profile.getOrders(OrderRange.YEAR_2018).size());

//        assertEquals(4, profile.getOrders(OrderRange.SIX).size());
//        assertEquals(2, profile.getOrders(OrderRange.YEAR_2017).size());
//        shop.addItemToBasket(book, 1, profile);
//        shop.addItemToBasket(music, 1, profile);
//        profile.setDeliveryOption(DeliveryOption.ONE_DAY_DELIVERY);
//        GiftCard giftCard7 = new GiftCard(Amount.THREE_HUNDRED, card);
//        profile.setGiftCard(giftCard7);
//        shop.buy(profile, "4/1/2017");







    }













}
