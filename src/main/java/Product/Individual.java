package Product;

import Enums.Profession;
import Product.Seller;

public class Individual extends Seller {

    Profession profession;

    public Individual(String name, Profession profession){
        super(name);
        this.profession = profession;
    }

}
