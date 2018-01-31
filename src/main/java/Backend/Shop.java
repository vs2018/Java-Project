package Backend;

import Person.Profile;
import Product.Book;
import Product.Product;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Shop {

    Inventory inventory;
    ArrayList<Profile> profile;

    public Shop(Inventory inventory) {
        this.inventory = inventory;
        this.profile = new ArrayList<>();


    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public ArrayList<Profile> getProfile() {
        return this.profile;
    }

    public void addProfile(Profile profile) {
        this.profile.add(profile);
    }

//    public String addItemToBasket(Product product, int quantity, Profile profile3) {
//        if (inventory.getStockLevel().containsKey(product.getName())) {
//            if (inventory.getStockLevel().get(product.getName()) >= quantity) {
//                Profile profile = getSpecificProfile(profile3);
//                        for (int i = 0; i < quantity; i++) {
////                            Product removedItem = inventory.removeItemFromInventory(product);
//                            profile.AddtoBasket(product);
//                        }
//                }
//            } else if (inventory.getStockLevel().get(product.getName()) < quantity) {
//                return "Insufficient stock, only" + inventory.getStockLevel().get(product.getName()) + " available";
//            }
//        else {
//            return "There is no stock available at present, check again at a later date";
//        }
//        return "Item added to basket";
//    }

    public void addItemToBasket(Product product, int quantity, Profile profile){
      for(Profile specificProfile: this.profile){
          if(specificProfile == profile){
              if((inventory.getStockLevel().containsKey(product.getName()) && (inventory.getStockLevel().get(product.getName()) >= quantity))){
                  for (int i = 0; i < quantity; i++) {
                      specificProfile.AddtoBasket(product);
                  }
              } else if ((inventory.getStockLevel().containsKey(product.getName()) && (inventory.getStockLevel().get(product.getName()) < quantity))){
                  for (int i = 0; i < inventory.getStockLevel().get(product.getName()); i++) {
                      specificProfile.AddtoBasket(product);
                  }
              }
          }
      }
    }

    public Profile getSpecificProfile(Profile profile) {
        Profile result = null;
        for(Profile checkOutProfile: this.profile){
            if(checkOutProfile == profile){
                result = checkOutProfile;
            }
        }
        return result;
    }

    public Address getDefaultDeliveryAddress(Profile profile) {
        Address result = null;
        Profile checkOutProfile = getSpecificProfile(profile);
        for(Address address: checkOutProfile.getAddressList()){
            if(Boolean.TRUE.equals(address.getDeliveryAddress())) {
                result = address;
            }
        }
        return result;
    }


    public void buy(Profile profile, String date) {
        LocalDate convertedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("M/d/yyyy"));
        Profile checkOutProfile = getSpecificProfile(profile);
        for(Product product: checkOutProfile.getBasket()) {
            product.setCheckOutDate(convertedDate);
            checkOutProfile.addItemToOrder(product);
            this.inventory.removeCorrespondingItem(product);
        }
        checkOutProfile.emptyBasket();
//        checkout(profile);
    }

//    public String checkout(Profile profile) {
//        for (Profile checkoutProfile : this.profile) {
//            if (profile == checkoutProfile) {
//                for (Product product : checkoutProfile.getBasket()) {
//                    checkoutProfile.addItemToOrder(product);
//                    this.inventory.removeCorrespondingItem(product);
//                }
//            }
//        }
//        profile.emptyBasket();
//        return "Successfully checked out";
//    }
}
