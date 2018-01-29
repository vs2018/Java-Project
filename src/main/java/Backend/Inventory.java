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
    Book book = new Book("Harry Potter",BookFormat.PAPERBACK, "26-01-2018",Department.BOOKS, 20.50,  15.00,Condition.NEW);
    Music music = new Music("Best of Enrique",MusicFormat.AUDIO_CD, "26-01-2018",Department.MUSIC, 20.50,  15.00,Condition.NEW);
    Movie movie = new Movie("Lord of the Rings",MovieFormat.BLU_RAY, "26-01-2018",Department.MOVIES, 20.50,  15.00,Condition.NEW);


    public Inventory() throws ParseException {
        this.inventory = new ArrayList<>();
        this.sold = new ArrayList<>();

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

    public HashMap<Product, Integer> getStockLevel(){
        HashMap<Product, Integer> hash = new HashMap<>();
        for(Product product: this.inventory){
            if(product.getClass() == movie.getClass()) {
                Product movie5 = (Movie) product;
                if (hash.containsKey(movie5)) {
                    hash.put(movie5, hash.get(movie5) + 1);
                } else {
                    hash.put(movie5, 1);
                }
            } else if (product.getClass() == music.getClass()){
                Product music5 = (Music) product;
                if (hash.containsKey(music5)) {
                    hash.put(music5, hash.get(music5) + 1);
                } else {
                    hash.put(music5, 1);
                }
            } else if (product.getClass() == book.getClass()){
                Product book5 = (Book) product;
                if (hash.containsKey(book5)) {
                    hash.put(book5, hash.get(book5) + 1);
                } else {
                    hash.put(book5, 1);
                }
            } else {
                Product electronic = (Electronic) product;
                if (hash.containsKey(electronic)) {
                    hash.put(electronic, hash.get(electronic) + 1);
                } else {
                    hash.put(electronic, 1);
                }
            }
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
