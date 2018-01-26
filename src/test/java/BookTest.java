import Enums.BookFormat;
import Enums.Condition;
import Enums.Department;
import Enums.ProductState;
import Product.Book;
import Product.Product;
import Product.Review;
import Product.Seller;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

public class BookTest {

    Book book;
    Review review;
    Seller seller;

    @Before
    public void before() throws ParseException {
        seller = new Seller();
        book = new Book(BookFormat.PAPERBACK, "26-01-2018", seller, Department.BOOKS, 20.50,  15.00, Condition.NEW);
    }

    @Test
    public void canGetDate() throws ParseException {
        DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String dateString = "26-01-2018";
        Date dateObject = sdf.parse(dateString);
        assertEquals(dateObject, book.getReleaseDate());
    }

    @Test
    public void gettersWork(){
        assertEquals(BookFormat.PAPERBACK, book.getFormat());
        assertEquals(Department.BOOKS, book.getDepartment());
        assertEquals(ProductState.PHYSICAL, book.getProductState());
    }


}
