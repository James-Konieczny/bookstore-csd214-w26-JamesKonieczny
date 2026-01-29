package csd214.bookstore.pojos;

import java.util.Objects;
import java.util.Scanner;

public abstract class Stationary extends Product{
    private String brand;
    private double price = 0.0;
    private int copies = 0;


    public Stationary(String brand, double price, int copies) {
        this.brand = brand;
        this.price = price;
        this.copies = copies;
    }

    // shortcut: alt + insert
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Stationary() {

    }

    @Override
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getCopies() {
        return copies;
    }
    public void setCopies(int copies) {
        this.copies = copies;
    }

    @Override
    public String toString() {
        return "Stationary{" +
                "brand='" + brand + '\'' +
                ", price=" + price + ", copies=" + copies +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Stationary)) return false;
        Stationary that = (Stationary) o;
        return Double.compare(that.price, price) == 0 &&
                Objects.equals(brand, that.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, price);
    }

    @Override
    public void initialize(Scanner input) {
//        super.initialize(); // Critical: let Parent ask for Name/Price
        System.out.println("Enter Brand:");
        this.brand = getInput(input, "Generic");
    }

    protected void initPriceCopies(Scanner input) {
        System.out.println("Enter copies:");
        this.copies = getInput(input, 0);

        System.out.println("Enter price:");
        this.price = getInput(input, 0.0);
    }

    @Override
    public void edit(Scanner input) {
        // 1. Edit Parent fields (Title, Price, Copies)
//        super.edit();

        // 2. Edit Self fields
        System.out.println("Edit Author [" + this.brand + "]:");
        this.brand = getInput(input, this.brand);

        System.out.println("Edit Price [" + this.price + "]:");
        this.price = getInput(input, this.price);

        System.out.println("Edit Copies [" + this.copies + "]:");
        this.copies = getInput(input, this.copies);
    }
}
