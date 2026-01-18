package csd214.bookstore.pojos;

import java.sql.SQLOutput;

public class Pen extends Stationary {
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void initialize() {
        super.initialize();

        System.out.println("Enter Pen Color:");
        this.color = getInput("Blue");
    }

    @Override
    public void sellItem() {
        System.out.println("Selling " + color + "Pen...");
    }
}
