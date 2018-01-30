import Backend.Address;
import Backend.Inventory;
import Backend.Shop;
import Person.Profile;
import Product.Product;
import org.junit.Before;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ShopTest {

    Shop shop;
    Profile profile;


    @Before
    public void before(){
        
    }

























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
            System.out.println(convertedDate);
            product.setCheckOutDate(convertedDate);
            checkOutProfile.addItemToOrder(product);
            this.inventory.removeCorrespondingItem(product);
        }
        checkOutProfile.emptyBasket();
//        checkout(profile);
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
