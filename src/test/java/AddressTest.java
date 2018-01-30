import Backend.*;
import Enums.*;
import Person.Profile;
import Product.*;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;

public class AddressTest {

    Address address;

    @Before
    public void before() throws ParseException {
        address = new Address("8 Castle Terrace");
    }

    @Test
    public void canGetAddress(){
        assertEquals("8 Castle Terrace", address.getAddress());
    }

    @Test
    public void canGetDeliveryAddress(){
        address.setDefaultDeliveryAddress(true);
        assertEquals(true, address.getDeliveryAddress());
    }

    @Test
    public void canGetDefaultAddress(){
        assertEquals(true, address.getDefaultDeliveryAddress());
    }

    @Test
    public void canGetSaturdayDelivery(){
        address.setSaturday(true);
        assertEquals(true, address.getSaturday());
    }

    @Test
    public void canGetSundayDelivery(){
        address.setSunday(false);
        assertEquals(false, address.getSunday());
    }

    @Test
    public void canEditAddress(){
        address.editAddress("10 March Avenue");
        assertEquals("10 March Avenue", address.getAddress());
    }

}
