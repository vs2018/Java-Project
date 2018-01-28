import Backend.Inventory;
import Enums.*;
import Person.Entity;
import Person.Individual;
import Person.Seller;
import Product.*;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class InventoryTest {

    Book book;
    Electronic electronic;
    Movie movie;
    Music music;
    Entity manufacturer;
    Inventory inventory;
    Product product;
    Review bookreview;

    @Before
    public void before() throws ParseException {
        inventory = new Inventory();
        manufacturer = new Entity("Sony");
        book = new Book("Harry Potter", BookFormat.PAPERBACK, "26-01-2018", Department.BOOKS, 20.50,  15.00, Condition.NEW);
        music = new Music("Best of Enrique", MusicFormat.AUDIO_CD, "26-01-2018", Department.MUSIC, 20.50,  15.00, Condition.NEW);
        movie = new Movie("Lord of the Rings", MovieFormat.BLU_RAY, "26-01-2018", Department.MOVIES, 20.50,  15.00, Condition.NEW);
        electronic = new Electronic("IPhone Camera", ElectronicType.CAMERA, "26-01-2018", Department.ELECTRONIC, 20.50,  15.00, Condition.NEW, manufacturer);
        bookreview = new Review(Rating.FIVE);
    }

    @Test
    public void canGetSellerArrayLength() {
        assertEquals(1, electronic.getSeller().size());
    }

    @Test
    public void canGetInventoryLength() {
        book.addReview(bookreview);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(movie);
        inventory.setInventory(movie);
        inventory.setInventory(movie);
        inventory.setInventory(movie);
        inventory.setInventory(movie);
        inventory.setInventory(music);
        assertEquals(14, inventory.getInventory().size());
        assertEquals(1, book.getReviews().size());
    }

    @Test
    public void canGetStockLevel() {
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(book);
        inventory.setInventory(movie);
        inventory.setInventory(movie);
        inventory.setInventory(movie);
        inventory.setInventory(movie);
        inventory.setInventory(movie);
        inventory.setInventory(music);
        inventory.setInventory(music);
        inventory.setInventory(music);
        inventory.setInventory(electronic);
        inventory.setInventory(electronic);
        inventory.setInventory(electronic);
        inventory.setInventory(electronic);
        HashMap<Product, Integer> hash = new HashMap<>();
        hash.put(book, 10);
        hash.put(music, 3);
        hash.put(movie, 5);
        hash.put(electronic, 4);
        assertEquals(hash, inventory.getStockLevel());
    }






}
