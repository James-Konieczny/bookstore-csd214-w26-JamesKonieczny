package csd214.bookstore.pojos;

import java.util.Objects;
import java.util.Scanner;

public class BowlingShoes extends BowlingSupply {
    private int shoeSize;

    public int getShoeSize() {
        return shoeSize;
    }

    public void setShoeSize(int shoeSize) {
        this.shoeSize = shoeSize;
    }

    public BowlingShoes(){}

    public BowlingShoes(int shoeSize, String color, double price, int copies){
        super(color, price, copies);
        this.shoeSize = shoeSize;
    }

    @Override
    public void initialize(Scanner input) {
        super.initialize(input);

        System.out.println("Enter Shoe Size:");
        this.shoeSize = Integer.parseInt(getInput(input, "9"));

        super.initPriceCopies(input);
    }

    @Override
    public void sellItem() {
        System.out.println("Selling Bowling Shoes (Size " + shoeSize + ")...");
        setCopies(getCopies() - 1);
    }

    @Override
    public void edit(Scanner input) {
        super.edit(input);

        System.out.println("Edit Shoe Size [" + this.shoeSize + "]:");
        this.shoeSize = getInput(input, this.shoeSize);
    }

    @Override
    public String toString() {
        return "Bowling Shoes{Shoe Size='" + shoeSize + "', " + super.toString() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BowlingShoes)) return false;
        if (!super.equals(o)) return false;
        BowlingShoes bowlingshoes = (BowlingShoes) o;
        return Objects.equals(shoeSize, bowlingshoes.shoeSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), shoeSize);
    }
}

