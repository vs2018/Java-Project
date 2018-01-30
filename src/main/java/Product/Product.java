package Product;

import Enums.Condition;
import Enums.Department;

import java.security.SecureRandom;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class Product {

    String asin = null;
    LocalDate releaseDate;
    ArrayList<Seller> seller;
    Department department;
    double rrp;
    double price;
    ArrayList<Review> reviews;
    Condition condition;
    String name;
    LocalDate dateOrdered;

    public Product(String name, String releaseDate, Department department, double rrp, double price, Condition condition) throws ParseException {
        this.name = name;
        setAsin();
        setReleaseDate(releaseDate);
        this.seller = new ArrayList<>();
        this.department = department;
        this.rrp = rrp;
        this.price = price;
        this.condition = condition;
        reviews = new ArrayList<>();
        this.dateOrdered = null;

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

    public void setReleaseDate(String releaseDate) throws ParseException {
        LocalDate convertedDate = LocalDate.parse(releaseDate, DateTimeFormatter.ofPattern("M/d/yyyy"));
        this.releaseDate = convertedDate;
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

    public LocalDate getReleaseDate() {
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


    public void setCheckOutDate(LocalDate date) {
        this.dateOrdered = date;
    }

    public LocalDate getCheckOutDate() {
        return this.dateOrdered;
    }
}
