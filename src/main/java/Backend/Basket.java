package Backend;

import Enums.DeliveryOption;
import Product.Product;
import Backend.Inventory;

import java.util.ArrayList;

public class Basket{

    ArrayList<Product> basket;
    DeliveryOption delivery;

    public Basket(){

        this.basket = new ArrayList<>();
        this.delivery = null;
    }

    public double getBasketTotal(){
        double total = getDeliveryPrice();
        for(Product product: this.basket){
            total += product.getPrice();
        }
        return total;
    }



    public DeliveryOption getDelivery() {
        return delivery;
    }

    public double getDeliveryPrice(){
        return getDelivery().getValue();
    }

    public void setDelivery(DeliveryOption delivery) {
        this.delivery = delivery;
    }

    public ArrayList<Product> getBasket() {
        return this.basket;
    }

    public void addtoBasket(Product product){
        this.basket.add(product);
    }

    public void clearBasket(){
        this.basket.clear();
    }






}
