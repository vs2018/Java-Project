package Product;

import Enums.*;

import java.text.ParseException;

public class Music extends Product {

    MusicFormat format;
    ProductState state;

    public Music(String name, MusicFormat format, String releaseDate, Department department, double rrp, double price, Condition condition) throws ParseException {
        super(name, releaseDate, department, rrp, price, condition);
        this.format = format;
    }

    public MusicFormat getFormat() {
        return format;
    }

    public ProductState getProductState(){
        return format.getState();
    }





}
