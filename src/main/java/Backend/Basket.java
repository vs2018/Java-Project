package Backend;

import Product.Product;
import Backend.Inventory;

import java.util.ArrayList;

public class Basket{

    ArrayList<Product> basket;
//    Inventory<Product> inventory;

    public Basket(){
        this.basket = new ArrayList<>();
    }

    public ArrayList<Product> getBasket() {
        return basket;
    }

    public void addtoBasket(Product product){
        this.basket.add(product);
    }

    public void clearBasket(){
        this.basket.clear();
    }






}
