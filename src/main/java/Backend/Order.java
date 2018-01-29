package Backend;

import Product.Product;

import java.util.ArrayList;

public class Order {

    ArrayList<Product> orders;

    public Order(){
        this.orders = new ArrayList<>();
    }

    public ArrayList<Product> getOrders() {
        return this.orders;
    }

//    public void addItemToOrder(Product product){
//        this.orders.add(product);
//    }
}
