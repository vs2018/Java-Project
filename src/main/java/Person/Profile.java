package Person;

import Backend.*;
import Product.Product;

import java.util.ArrayList;

public class Profile {

    Basket basket;
    Order orders;
    Address addresses;
    Payment payments;
    String email;
    int phone;
    WishList wishList;

    public Profile(Basket basket, Order orders, Address addresses, Payment payments, String email, int phone, WishList wishList) {
        this.basket = basket;
        this.orders = orders;
        this.addresses = addresses;
        this.payments = payments;
        this.email = email;
        this.phone = phone;
        this.wishList = wishList;
    }

    public ArrayList<Product> getOrder(){
        return this.orders.getOrders();
    }

    public ArrayList<Product> getBasket() {
        return this.basket.getBasket();
    }

    public void AddtoBasket(Product product){
        this.basket.addtoBasket(product);
    }

    public void emptyBasket(){
        this.basket.clearBasket();
    }

    public Address getAddresses() {
        return addresses;
    }

    public Payment getPayments() {
        return payments;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }

    public WishList getWishList() {
        return wishList;
    }

    public void deleteItemFromBasket(Product movie) {
        for(int i = 0; i < getBasket().size(); i++){
            if(getBasket().get(i) == movie){
                getBasket().remove(i);
            }
        }
    }

    public void addItemToOrder(Product removedItem) {
        getOrder().add(removedItem);
    }
}
