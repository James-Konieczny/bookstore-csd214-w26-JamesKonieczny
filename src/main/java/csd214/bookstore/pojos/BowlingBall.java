package csd214.bookstore.pojos;

public class BowlingBall extends BowlingSupply {
    private int weight;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public void initialize() {
        super.initialize();

        System.out.println("Enter Ball Weight (lbs):");
        this.weight = getInput(12);
    }

    @Override
    public void sellItem() {
        System.out.println("Selling " + weight + "lb Bowling Ball (Color " + getColor() + ")...");
    }

    @Override
    public void edit() {
        super.edit();

        System.out.println("Edit Weight [" + this.weight + "]:");
        this.weight = getInput(this.weight);
    }

    @Override
    public String toString() {
        return "Bowling Ball{weight='" + weight + "', " + super.toString() + "}";
    }
}
