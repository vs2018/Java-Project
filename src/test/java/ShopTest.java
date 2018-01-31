import Backend.*;
import Enums.*;
import Person.Profile;
import Product.*;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ShopTest {

    Inventory inventory;
    Shop shop;
    Profile profile;
    Basket basket;
    Basket basket2;
    Order order;
    Address address;
    PaymentCard card;
    WishList wishlist;
    Book book;
    Music music;
    Movie movie;
    Profile profile2;
    Address address2;


    @Before
    public void before() throws ParseException {
        inventory = new Inventory();
        shop = new Shop(inventory);
        book = new Book("Harry Potter", BookFormat.PAPERBACK, "1/1/2018", Department.BOOKS, 1000.50,  100.00, Condition.NEW);
        music = new Music("Best of Enrique", MusicFormat.AUDIO_CD, "1/1/2018", Department.MUSIC, 20.50,  100.00, Condition.NEW);
        movie = new Movie("Lord of the Rings", MovieFormat.BLU_RAY, "1/1/2018", Department.MOVIES, 20.50,  100.00, Condition.NEW);
        basket = new Basket();
        basket2 = new Basket();
        wishlist = new WishList();
        order = new Order();
        address = new Address("8 Castle Terrace");
        address.setDefaultDeliveryAddress(false);
        address2 = new Address("10 Castle Terrace");
        card = new PaymentCard("Vishal", "1234567891234567", ExpiryMonth.JANUARY, ExpiryYear.YEAR2019);
        profile2 = new Profile(basket2, order, address, card, "codeclan2@gmail.com", 07770617773, wishlist);
        profile = new Profile(basket, order, address, card, "codeclan@gmail.com", 07770617773, wishlist);
    }

    @Test
    public void canGetProperties(){
        assertEquals(inventory, shop.getInventory());
        shop.addProfile(profile2);
        assertEquals(1, shop.getProfile().size());
    }

    @Test
    public void canAddItemToBasket() {
        shop.addProfile(profile);
        shop.addProfile(profile2);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(music);
        shop.addItemToBasket(book, 2, profile);
        shop.addItemToBasket(book, 1, profile2);
        assertEquals(2, profile.getBasket().size());
        assertEquals(1, profile2.getBasket().size());
    }


        @Test
        public void canGetDefaultDeliveryAddress(){
            address2.setDefaultDeliveryAddress(true);
            profile.addAddresstoList(address2);
            shop.addProfile(profile2);
            shop.addProfile(profile);
            assertEquals(profile, shop.getSpecificProfile(profile));
            assertEquals(address2, shop.getDefaultDeliveryAddress(profile));
        }


    @Test
    public void canBuy(){
        shop.addProfile(profile);
        shop.addProfile(profile2);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(music);
        shop.addItemToBasket(book, 2, profile);
        shop.addItemToBasket(book, 1, profile2);
        shop.buy(profile, "1/2/2018");
        assertEquals(0, profile.getBasket().size());
        assertEquals(1, profile2.getBasket().size());
        assertEquals(2, inventory.getInventory().size());
        assertEquals(2, inventory.getSold().size());
        assertEquals(2, profile.getOrder().size());
        assertEquals(2, profile.getOrders(OrderRange.YEAR_2018).size());
    }



}

