import Backend.Address;
import Backend.Order;
import Backend.PaymentCard;
import Enums.*;
import Product.*;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class OrderTest {

    Order order;
    Book book;

    @Before
    public void before() throws ParseException {
        book = new Book("Harry Potter", BookFormat.PAPERBACK, "1/1/2018", Department.BOOKS, 1000.50,  100.00, Condition.NEW);
        order = new Order();
    }

    @Test
    public void canGetOrders() {
        order.addProductToOrder(book);
        assertEquals(1, order.getOrders().size());
    }


}
