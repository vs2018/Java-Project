import Backend.Inventory;
import Enums.*;
import Product.Entity;
import Product.*;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class InventoryTest {

    Book book;
    Movie movie;
    Music music;
    Entity manufacturer;
    Electronic electronic;
    Inventory inventory;

    @Before
    public void before() throws ParseException {
        inventory = new Inventory();
        manufacturer = new Entity("Sony");
        book = new Book("Harry Potter", BookFormat.PAPERBACK, "1/1/2018", Department.BOOKS, 20.50,  15.00, Condition.NEW);
        music = new Music("Best of Enrique", MusicFormat.AUDIO_CD, "1/1/2018", Department.MUSIC, 20.50,  15.00, Condition.NEW);
        movie = new Movie("Lord of the Rings", MovieFormat.BLU_RAY, "1/1/2018", Department.MOVIES, 20.50,  15.00, Condition.NEW);
        electronic = new Electronic("IPhone Camera", ElectronicType.CAMERA, "1/1/2018", Department.ELECTRONIC, 20.50,  100.00, Condition.NEW, manufacturer);
        inventory.setProductType(book);
        inventory.setProductType(movie);
        inventory.setProductType(music);
        inventory.setProductType(electronic);
    }

    @Test
    public void canGetInventoryLength() {
        inventory.setInventory(book);
        inventory.setInventory(movie);
        inventory.setInventory(music);
        assertEquals(3, inventory.getInventory().size());
        inventory.removeCorrespondingItem(book);
        ArrayList<Product> list = new ArrayList<>();
        list.add(book);
        assertEquals(list, inventory.getSold());
    }

    @Test
    public void canGetStockLevel() {
        inventory.setInventory(movie);
        inventory.setInventory(music);
        inventory.setInventory(electronic);
        HashMap<String, Integer> hash = new HashMap<>();
        hash.put(music.getName(), 1);
        hash.put(movie.getName(), 1);
        hash.put(electronic.getName(), 1);
        assertEquals(hash, inventory.getStockLevel());
    }





}
