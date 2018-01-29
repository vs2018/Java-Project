package Backend;

import java.util.ArrayList;

public class Payment<T> {

    ArrayList<T> wallet;

    public Payment(){
        this.wallet = new ArrayList<>();
    }

    public ArrayList<T> getCards() {
        return this.wallet;
    }

    public void addCard(T card) {
        this.wallet.add(card);
    }


}
