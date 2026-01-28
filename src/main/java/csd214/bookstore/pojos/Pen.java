package csd214.bookstore.pojos;

import java.util.Objects;
import java.util.Scanner;

public class Pen extends Stationary {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Pen(){}

    public Pen(String color, String brand, double price, int copies){
        super(brand, price, copies);
        this.color = color;
    }

    @Override
    public void initialize(Scanner input) {
        super.initialize(input);

        System.out.println("Enter Pen Color:");
        this.color = getInput(input, "Blue");

        super.initPriceCopies(input);
    }

    @Override
    public void sellItem() {
        System.out.println("Selling " + color + " Pen...");
        setCopies(getCopies() - 1);
    }

    @Override
    public void edit(Scanner input) {
        super.edit(input);
        System.out.println("Edit Color [" + this.color + "]:");
        this.color = getInput(input, this.color);
    }

    @Override
    public String toString() {
        return "Pen{color='" + color + "', " + super.toString() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pen)) return false;
        if (!super.equals(o)) return false;
        Pen pen = (Pen) o;
        return Objects.equals(color, pen.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color);
    }
}