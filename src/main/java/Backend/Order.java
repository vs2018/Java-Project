package Backend;

import Enums.OrderRange;
import Product.Product;

import java.util.ArrayList;

public class Order {

    ArrayList<Product> orders;
    OrderRange range;

    public Order(){

        this.orders = new ArrayList<>();
    }

    public ArrayList<Product> getOrders() {
        return this.orders;
    }

    public OrderRange getRange() {
        return range;
    }

    public int getRangeValue(){
        return getRange().getValue();
    }
}
