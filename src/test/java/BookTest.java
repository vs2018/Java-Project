import Enums.*;
import Person.Individual;
import Person.Seller;
import Product.*;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class BookTest {

    Book book;
    Review review;
    Seller seller;
    Book book2;

//    @Before
//    public void before() throws ParseException {
//        seller = new Individual("Vishal", Profession.AUTHOR);
//        book = new Book(BookFormat.PAPERBACK, "26-01-2018", seller, Department.BOOKS, 20.50,  15.00, Condition.NEW);
//    }
//
//    @Test
//    public void canGetDate() throws ParseException {
//        DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//        String dateString = "26-01-2018";
//        Date dateObject = sdf.parse(dateString);
//        assertEquals(dateObject, book.getReleaseDate());
//    }
//
//    @Test
//    public void gettersWork(){
//        assertEquals(BookFormat.PAPERBACK, book.getFormat());
//        assertEquals(Department.BOOKS, book.getDepartment());
//        assertEquals(ProductState.PHYSICAL, book.getProductState());
//    }
//
//    @Test
//    public void canGetAsin() throws ParseException {
//        seller = new Individual("Vishal", Profession.AUTHOR);
//        book2 = new Book(BookFormat.PAPERBACK, "26-01-2018", seller, Department.BOOKS, 20.50,  15.00, Condition.NEW);
//        assertEquals("V1Bvstpgtb", book2.getAsin());
//
//    }


}
