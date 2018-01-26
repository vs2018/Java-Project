package Product;

import Enums.Condition;
import Enums.Department;

import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {

    String asin;
    Date releaseDate;
    ArrayList<Seller> seller;
    Department department;
    double rrp;
    double price;
    ArrayList<Review> reviews;
    Condition condition;

    public Product(String releaseDate, Seller seller, Department department, double rrp, double price, Condition condition) throws ParseException {
        setAsin();
        this.releaseDate = setReleaseDate(releaseDate);
        this.seller = new ArrayList<>();
        this.department = department;
        this.rrp = rrp;
        this.price = price;
        this.condition = condition;
        reviews = new ArrayList<>();
    }

    public Date setReleaseDate(String releaseDate) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date inputDate = dateFormat.parse(releaseDate);
        return inputDate;
    }

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    String randomString(){
        StringBuilder sb = new StringBuilder( 10 );
        for( int i = 0; i < 10; i++ )
            sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
        return sb.toString();
    }

    public void setAsin(){
        this.asin = randomString();
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getAsin() {
        return asin;
    }

    public ArrayList<Seller> getSeller() {
        return seller;
    }

    public Department getDepartment() {
        return department;
    }

    public double getRrp() {
        return rrp;
    }

    public double getPrice() {
        return price;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public Condition getCondition() {
        return condition;
    }




}
