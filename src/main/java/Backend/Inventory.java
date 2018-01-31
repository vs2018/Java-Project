package Backend;

import Enums.*;
import Product.Book;
import Product.Movie;
import Product.Music;
import Product.Electronic;
import Product.Product;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {

    ArrayList<Product> inventory;
    ArrayList<Product> sold;
    Book book;
    Music music;
    Movie movie;
    Electronic electronic;

    public Inventory() throws ParseException {
        this.inventory = new ArrayList<>();
        this.sold = new ArrayList<>();

    }

    public void setProductType(Book product){
        this.book = book;
    }

    public void setProductType(Music product){
        this.music = product;
    }

    public void setProductType(Movie product){
        this.movie = product;
    }

    public void setProductType(Electronic product){
        this.electronic = product;
    }

    public void setInventory(Product product) {
        this.inventory.add(product);
    }

    public ArrayList<Product> getInventory() {
        return this.inventory;
    }

    public void setSold(Product product) {
        this.sold.add(product);
    }

    public ArrayList<Product> getSold() {
        return sold;
    }

    public HashMap<String, Integer> getStockLevel(){
        HashMap<String, Integer> hash = new HashMap<>();
        for(Product product: this.inventory){
            if (hash.containsKey(product.getName())) {
                hash.put(product.getName(), hash.get(product.getName()) + 1);
            } else {
                hash.put(product.getName(), 1);
            }
//            if(product.getClass() == movie.getClass()) {
//                if (hash.containsKey(product)) {
//                    hash.put(product, hash.get(product) + 1);
//                } else {
//                    hash.put(product, 1);
//                }
//            } else if (product.getClass() == music.getClass()){
//                if (hash.containsKey(product)) {
//                    hash.put(product, hash.get(product) + 1);
//                } else {
//                    hash.put(product, 1);
//                }
//            } else if (product.getClass() == book.getClass()){
//                if (hash.containsKey(product)) {
//                    hash.put(product, hash.get(product) + 1);
//                } else {
//                    hash.put(product, 1);
//                }
//            } else {
//                Product electronic = (Electronic) product;
//                if (hash.containsKey(electronic)) {
//                    hash.put(electronic, hash.get(electronic) + 1);
//                } else {
//                    hash.put(electronic, 1);
//                }
//            }
        }
        return hash;
    }

//    public Product removeItemFromInventory(Product product) {
//        Product removedItem = null;
//        for(int i = 0; i < this.inventory.size(); i++){
//            if(this.inventory.get(i) == product){
//                removedItem = this.inventory.remove(i);
//                this.sold.add(removedItem);
//            }
//        }
//        return removedItem;
//    }

    public void removeCorrespondingItem(Product product) {
        if(getInventory().remove(product)){
            setSold(product);
        }
//        for(int i = 0; i < getInventory().size(); i++){
//            if(product.getAsin() == getInventory().get(i).getAsin()){
//                Product removedItem = getInventory().remove(i);
//                setSold(removedItem);
//            }
    }
}
