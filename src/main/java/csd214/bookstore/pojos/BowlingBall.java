package csd214.bookstore.pojos;

import java.util.Objects;
import java.util.Scanner;

public class BowlingBall extends BowlingSupply {
    private int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public BowlingBall(){}

    public BowlingBall(int weight, String color, double price, int copies){
        super(color, price, copies);
        this.weight = weight;
    }

    @Override
    public void initialize(Scanner input) {
        super.initialize(input);

        System.out.println("Enter Ball Weight (lbs):");
        this.weight = getInput(input, 12);

        super.initPriceCopies(input);
    }

    @Override
    public void sellItem() {
        System.out.println("Selling " + weight + "lb Bowling Ball (Color " + getColor() + ")...");
        setCopies(getCopies() - 1);
    }

    @Override
    public void edit(Scanner input) {
        super.edit(input);

        System.out.println("Edit Weight [" + this.weight + "]:");
        this.weight = getInput(input, this.weight);
    }

    @Override
    public String toString() {
        return "Bowling Ball{weight='" + weight + "', " + super.toString() + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BowlingBall)) return false;
        if (!super.equals(o)) return false;
        BowlingBall bowlingball = (BowlingBall) o;
        return Objects.equals(weight, bowlingball.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), weight);
    }
}

