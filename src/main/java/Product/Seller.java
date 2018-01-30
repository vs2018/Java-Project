package Product;

import Product.Product;

import java.util.ArrayList;

public abstract class Seller {

    String name;
    ArrayList<Product> products;

    Seller(String name){
        this.name = name;
        products = new ArrayList<>();
    }

    public void addProduct(Product product){
        this.products.add(product);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
