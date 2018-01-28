package Product;

import Enums.Condition;
import Enums.Department;
import Person.Seller;

import java.security.SecureRandom;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.text.DateFormat;
import java.util.Date;

public abstract class Product {

    String asin = null;
    Date releaseDate;
    ArrayList<Seller> seller;
    Department department;
    double rrp;
    double price;
    ArrayList<Review> reviews;
    Condition condition;
    String name;

    public Product(String name, String releaseDate, Department department, double rrp, double price, Condition condition) throws ParseException {
        this.name = name;
        setAsin();
        this.releaseDate = setReleaseDate(releaseDate);
        this.seller = new ArrayList<>();
        this.department = department;
        this.rrp = rrp;
        this.price = price;
        this.condition = condition;
        reviews = new ArrayList<>();

    }

    public String getName(){
        return this.name;
    }

    public void addReview(Review review){
        reviews.add(review);
    }

    public void addSeller(Seller seller){
        this.seller.add(seller);
    }

    public Date setReleaseDate(String releaseDate) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date inputDate = dateFormat.parse(releaseDate);
        return inputDate;
    }

    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static final SecureRandom rnd = new SecureRandom();

    public String randomString(){
//        String identifier = null;
        if(this.asin == null) {
            StringBuilder sb = new StringBuilder(10);
            for (int i = 0; i < 10; i++)
                sb.append(AB.charAt(rnd.nextInt(AB.length())));
            return sb.toString();
        } else {
            return this.asin;
        }
//        return identifier;
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
