package Product;

import Enums.*;
import Person.Individual;
import Person.Seller;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.util.ArrayList;

public class Movie extends Product{

    MovieFormat format;
    ProductState state;

    public Movie(String name, MovieFormat format, String releaseDate, Department department, double rrp, double price, Condition condition) throws ParseException {
        super(name, releaseDate, department, rrp, price, condition);
        this.format = format;
    }

    public MovieFormat getFormat() {
        return format;
    }

    public ProductState getProductState(){
        return format.getState();
    }

}
