import Backend.*;
import Enums.*;
import Person.Entity;
import Person.Profile;
import Product.*;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
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


    @Before
    public void before() throws ParseException {
        inventory = new Inventory();
        manufacturer = new Entity("Sony");
        book = new Book("Harry Potter", BookFormat.PAPERBACK, "26-01-2018", Department.BOOKS, 20.50,  15.00, Condition.NEW);
        book2 = new Book("Harry Potter 2", BookFormat.PAPERBACK, "26-01-2018", Department.BOOKS, 20.50,  15.00, Condition.NEW);
        book3 = new Book("Harry Potter 3", BookFormat.PAPERBACK, "26-01-2018", Department.BOOKS, 20.50,  15.00, Condition.NEW);
        music2 = new Music("Best of Enrique 2", MusicFormat.AUDIO_CD, "26-01-2018", Department.MUSIC, 20.50,  15.00, Condition.NEW);
        music = new Music("Best of Enrique", MusicFormat.AUDIO_CD, "26-01-2018", Department.MUSIC, 20.50,  15.00, Condition.NEW);
        movie = new Movie("Lord of the Rings", MovieFormat.BLU_RAY, "26-01-2018", Department.MOVIES, 20.50,  15.00, Condition.NEW);
        movie2 = new Movie("Lord of the Rings 2", MovieFormat.BLU_RAY, "26-01-2018", Department.MOVIES, 20.50,  15.00, Condition.NEW);
        movie3 = new Movie("Lord of the Rings 3", MovieFormat.BLU_RAY, "26-01-2018", Department.MOVIES, 20.50,  15.00, Condition.NEW);
        electronic = new Electronic("IPhone Camera", ElectronicType.CAMERA, "26-01-2018", Department.ELECTRONIC, 20.50,  15.00, Condition.NEW, manufacturer);
        bookreview = new Review(Rating.FIVE);
        basket = new Basket();
        wishlist = new WishList();
        payment = new Payment();
        order = new Order();
        address = new Address();
        order2 = new Order();
        order3 = new Order();
        order4 = new Order();
        basket2 = new Basket();
        basket3 = new Basket();
        basket4 = new Basket();
        profile = new Profile(basket, order, address, payment, "codeclan@gmail.com", 07770617773, wishlist);
        profile2 = new Profile(basket3, order3, address, payment, "edinburgh@gmail.com", 07770617773, wishlist);
        profile3 = new Profile(basket4, order4, address, payment, "glasgow@gmail.com", 07770617773, wishlist);
        profile4 = new Profile(basket2, order2, address, payment, "glasgow@gmail.com", 07770617773, wishlist);
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







}
