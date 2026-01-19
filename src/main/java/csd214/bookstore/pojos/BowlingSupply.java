package csd214.bookstore.pojos;

public abstract class BowlingSupply extends Product {
    private String color;
    private double price = 0.0;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public BowlingSupply() {
    }

    @Override
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void initialize() {
 //       super.initialize();

        System.out.println("Enter Color: ");
        this.color = getInput("Blue");
    }

    @Override
    public void edit() {
 //       super.edit();

        System.out.println("Edit Color [" + this.color + "]:");
        this.color = getInput(this.color);
    }

    @Override
    public String toString() {
        return "BowlingSupply{" +
                "color='" + color + '\'' +
                '}';
    }
}
