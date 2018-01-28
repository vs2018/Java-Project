package Person;

import Enums.Profession;
import Person.Seller;

public class Individual extends Seller {

    Profession profession;

    public Individual(String name, Profession profession){
        super(name);
        this.profession = profession;
    }

}
