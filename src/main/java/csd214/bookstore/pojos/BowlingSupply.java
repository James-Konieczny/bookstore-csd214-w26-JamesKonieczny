package csd214.bookstore.pojos;

import java.util.Scanner;

public abstract class BowlingSupply extends Product {
    private String color;
    private double price = 0.0;
    private int copies = 0;


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BowlingSupply() {
    }

    public BowlingSupply(String color, double price, int copies) {
        this.color = color;
        this.price = price;
        this.copies = copies;
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
    public void initialize(Scanner input) {
        //       super.initialize();

        System.out.println("Enter Color: ");
        this.color = getInput(input, "Blue");
    }

    protected void initPriceCopies(Scanner input) {
        System.out.println("Enter copies:");
        this.copies = getInput(input, 0);

        System.out.println("Enter price:");
        this.price = getInput(input, 0.0);
    }

    @Override
    public void edit(Scanner input) {
        //       super.edit();

        System.out.println("Edit Color [" + this.color + "]:");
        this.color = getInput(input, this.color);

        System.out.println("Edit Price [" + this.price + "]:");
        this.price = getInput(input, this.price);

        System.out.println("Edit Copies [" + this.copies + "]:");
        this.copies = getInput(input, this.copies);
    }

    @Override
    public String toString() {
        return "BowlingSupply{" +
                "color='" + color + '\'' +
                ", price=" + price + ", copies=" + copies +
                '}';
    }
}

