package Backend;

import Person.Profile;
import Product.Book;
import Product.Product;

import java.util.ArrayList;

public class Shop {

    Inventory inventory;
    ArrayList<Profile> profile;

    public Shop(Inventory inventory) {
        this.inventory = inventory;
        this.profile = new ArrayList<>();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public ArrayList<Profile> getProfile() {
        return this.profile;
    }

    public void addProfile(Profile profile) {
        this.profile.add(profile);
    }

    public String addItemToBasket(Product product, int quantity, Profile profile3) {
        if (inventory.getStockLevel().containsKey(product)) {
            if (inventory.getStockLevel().get(product) >= quantity) {
                for (Profile profile : this.profile) {
                    if (profile == profile3) {
                        for (int i = 0; i < quantity; i++) {
//                            Product removedItem = inventory.removeItemFromInventory(product);
                            profile.AddtoBasket(product);
                        }
                    }
                }
            } else if (inventory.getStockLevel().get(product) < quantity) {
                return "Insufficient stock, only" + inventory.getStockLevel().get(product) + " available";
            }
            return "No stock available, check again at a later date";
        } else {
            return "Item does not exist and no stock available, check again at a later date";
        }
    }


    public String checkout(Profile profile) {





        for (Profile checkoutProfile : this.profile) {
            if (profile == checkoutProfile) {
                for (Product product : checkoutProfile.getBasket()) {
                    checkoutProfile.addItemToOrder(product);
                    this.inventory.removeCorrespondingItem(product);
                }
            }
        }
        profile.emptyBasket();
        return "Successfully checked out";
    }
}
