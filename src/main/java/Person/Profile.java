package Person;

import Backend.*;
import Enums.DeliveryOption;
import Product.Product;

import java.util.ArrayList;

public class Profile {

    Basket basket;
    Order orders;
    ArrayList<Address> addresses;
    ArrayList<PaymentCard> payments;
    GiftCard giftcard;
    String email;
    int phone;
    WishList wishList;

    public Profile(Basket basket, Order orders, Address address, PaymentCard card, String email, int phone, WishList wishList) {
        this.basket = basket;
        this.orders = orders;
        this.addresses = new ArrayList<>();
        addAddresstoList(address);
        this.payments = new ArrayList<>();
        this.payments.add(card);
        this.giftcard = null;
        this.email = email;
        this.phone = phone;
        this.wishList = wishList;
    }




    public ArrayList<Address> getAddressList(){
        return this.addresses;
    }

    public void addAddresstoList(Address address){
        this.addresses.add(address);
    }

    public void deleteAddressFromList(Address address){
        for(int i = 0; i < getAddressList().size(); i++){
            if(address == getAddressList().get(i)){
                this.addresses.remove(i);
            }
        }
    }

    public ArrayList<Product> getOrder(){
        return this.orders.getOrders();
    }

    public ArrayList<Product> getBasket() {
        return this.basket.getBasket();
    }

    public void AddtoBasket(Product product){
        this.basket.addtoBasket(product);
    }

    public void emptyBasket(){
        this.basket.clearBasket();
    }

    public ArrayList<PaymentCard> getPayments() {
        return this.payments;
    }

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }

    public WishList getWishList() {
        return wishList;
    }

    public void deleteItemFromBasket(Product movie) {
        for(int i = 0; i < getBasket().size(); i++){
            if(getBasket().get(i) == movie){
                getBasket().remove(i);
            }
        }
    }

    public void addItemToOrder(Product removedItem) {
        getOrder().add(removedItem);
    }

    public void changeDeliveryAddress(Address defaultAddress) {
        for(Address address: this.addresses){
            if(defaultAddress == address){
                address.setDefaultDeliveryAddress(true);
            } else if(defaultAddress != address){
                address.setDefaultDeliveryAddress(false);
            }
        }
    }

    public void addAddress(Address address) {
        this.addresses.add(address);
    }

    public void addCard(PaymentCard card) {
        this.payments.add(card);
    }

    public void deleteCard(Payment deleteCard){
        for(int i = 0; i < this.payments.size(); i++){
            if(this.payments.get(i) == deleteCard){
                this.payments.remove(i);
            }
        }
    }

    public void setDefaultPaymentsCard(PaymentCard defaultPaymentsCard) {
        for(PaymentCard card: this.payments){
            if(card == defaultPaymentsCard){
                card.setDefaultCard();
            } else if(card != defaultPaymentsCard){
                card.removeDefaultCardSetting();
            }
        }
    }

    public PaymentCard getDefaultPaymentsCard() {
        PaymentCard result = null;
        for(PaymentCard card: this.payments){
            if(Boolean.TRUE.equals(card.getDefaultCard())){
                result = card;
            }
        }
        return result;
    }

    public void addGiftCardBalance(GiftCard giftCard) {
        this.giftcard.topUpBalanceWithGiftCard(giftCard);
    }

    public DeliveryOption getDeliveryOption() {
        return this.basket.getDelivery();
    }

    public void setDeliveryOption(DeliveryOption delivery) {
        this.basket.setDelivery(delivery);
    }

    public double getTotal(){
        return this.basket.getBasketTotal();
    }

    public double getGiftCardTotal(){
        return this.giftcard.getBalance();
    }

    public double newTotalAfterApplyingGiftCard(){
        double total = 0.00;
        if(getTotal() >= getGiftCardTotal()){
            total = getTotal() - getGiftCardTotal();
            this.giftcard.resetGiftCardBalance();
        } else if (getTotal() < getGiftCardTotal()) {
            total = 0.00;
            this.giftcard.decreaseGiftCardBalance(getTotal());
        }
        return total;
    }


    public void setGiftCard(GiftCard giftCard) {
        this.giftcard = giftCard;
    }

    public double getGiftCardBalance() {
        return this.giftcard.getBalance();
    }
}
