package Product;

import Enums.*;

import java.text.ParseException;

public class Electronic extends Product{

    ElectronicType electronicType;
    Entity entity;

    public Electronic(String name, ElectronicType electronicType, String releaseDate, Department department, double rrp, double price, Condition condition, Entity entity) throws ParseException {
        super(name, releaseDate, department, rrp, price, condition);
        this.electronicType = electronicType;
        super.addSeller(entity);
    }

    public ElectronicType getElectronicType() {
        return this.electronicType;
    }







}
