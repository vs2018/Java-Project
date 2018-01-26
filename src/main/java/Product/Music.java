package Product;

import Enums.*;

import java.text.ParseException;

public class Music extends Product {

    MusicFormat format;
    ProductState state;

    public Music(MusicFormat format, String releaseDate, Seller seller, Department department, double rrp, double price, Condition condition) throws ParseException {
        super(releaseDate, seller, department, rrp, price, condition);
        this.format = format;
    }

    public MusicFormat getFormat() {
        return format;
    }

    public ProductState getProductState(){
        return format.getState();
    }





}
