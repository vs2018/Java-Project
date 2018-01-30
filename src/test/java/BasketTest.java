import Backend.Basket;
import Enums.*;
import Product.*;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BasketTest {

    Book book;
    Book book2;
    Movie movie;
    Basket basket;

    @Before
    public void before() throws ParseException {
        book = new Book("Harry Potter", BookFormat.PAPERBACK, "1/1/2018", Department.BOOKS, 1000.50,  100.00, Condition.NEW);
        book2 = new Book("Harry Potter 2", BookFormat.PAPERBACK, "1/1/2018", Department.BOOKS, 1000.50,  100.00, Condition.NEW);
        basket = new Basket();
        movie = new Movie("Lord of the Rings", MovieFormat.BLU_RAY, "1/1/2018", Department.MOVIES, 20.50,  100.00, Condition.NEW);
    }

    @Test
    public void canAddProductToBasket(){
        basket.addtoBasket(book);
        assertEquals(1, basket.getBasket().size());
    }

    @Test
    public void canEmptyBasket(){
        basket.addtoBasket(book);
        basket.addtoBasket(movie);
        basket.addtoBasket(book2);
        basket.clearBasket();
        assertEquals(0, basket.getBasket().size());
    }

    @Test
    public void canGetDeliveryPrice(){
        basket.setDelivery(DeliveryOption.STANDARD_DELIVERY);
        assertEquals(2.99, basket.getDeliveryPrice(),0.01);
    }

    @Test
    public void canGetBasketTotal(){
        basket.addtoBasket(book);
        basket.addtoBasket(movie);
        basket.addtoBasket(book2);
        assertEquals(300.00, basket.getBasketTotal(),0.01);
    }

}
