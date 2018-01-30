import Enums.*;
import Product.Entity;
import Product.Individual;
import Product.*;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class ProductTest {

    Book book;
    Book book2;
    Electronic electronic;
    Movie movie;
    Music music;
    Entity manufacturer;
    Review review;
    Individual individual;

    @Before
    public void before() throws ParseException {
        individual = new Individual("J K Rowling", Profession.AUTHOR);
        book = new Book("Harry Potter", BookFormat.PAPERBACK, "1/1/2018", Department.BOOKS, 1000.50,  100.00, Condition.NEW);
        book2 = new Book("Harry Potter 2", BookFormat.PAPERBACK, "1/1/2018", Department.BOOKS, 1000.50,  100.00, Condition.NEW);
        music = new Music("Best of Enrique", MusicFormat.AUDIO_CD, "1/1/2018", Department.MUSIC, 20.50,  100.00, Condition.NEW);
        movie = new Movie("Lord of the Rings", MovieFormat.BLU_RAY, "1/1/2018", Department.MOVIES, 20.50,  100.00, Condition.NEW);
        manufacturer = new Entity("Sony");
        electronic = new Electronic("IPhone Camera", ElectronicType.CAMERA, "1/1/2018", Department.ELECTRONIC, 20.50,  100.00, Condition.NEW, manufacturer);
        review = new Review(Rating.FIVE);

    }

    @Test
    public void canGetName(){
        assertEquals("Harry Potter", book.getName());
    }

    @Test
    public void canAddReview(){
        book.addReview(review);
        assertEquals(1, book.getReviews().size());
    }

    @Test
    public void canAddSeller(){
        book.addSeller(individual);
        assertEquals(1, book.getSeller().size());
    }

    @Test
    public void canSetReleaseDate() throws ParseException {
        book.setReleaseDate("1/30/2018");
        LocalDate today = LocalDate.now();
        assertEquals(today, book.getReleaseDate());
    }

    @Test
    public void canGenerateAsin(){
        assertEquals(10, book.getAsin().length());
    }

    @Test
    public void canGetDepartment(){
        assertEquals(Department.BOOKS, book.getDepartment());
    }

    @Test
    public void canGetRRP(){
        assertEquals(1000.50, book.getRrp(),0.01);
    }

    @Test
    public void canGetPrice(){
        assertEquals(100.00, book.getPrice(),0.01);
    }

    @Test
    public void canGetCondition(){
        assertEquals(Condition.NEW, book.getCondition());
    }

    @Test
    public void canSetCheckOutDate(){
        LocalDate today = LocalDate.now();
        book.setCheckOutDate(today);
        assertEquals(LocalDate.now(), book.getCheckOutDate());
    }

    @Test
    public void sellerCanHoldMultipleProducts(){
        individual.addProduct(book);
        individual.addProduct(book2);
        assertEquals(2, individual.getProducts().size());
    }


}
