package csd214.bookstore.pojos;

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
    public void initialize() {
 //       super.initialize();

        System.out.println("Enter Color: ");
        this.color = getInput("Blue");
    }

    protected void initPriceCopies() {
        System.out.println("Enter copies:");
        this.copies = getInput(0);

        System.out.println("Enter price:");
        this.price = getInput(0.0);
    }

    @Override
    public void edit() {
 //       super.edit();

        System.out.println("Edit Color [" + this.color + "]:");
        this.color = getInput(this.color);

        System.out.println("Edit Price [" + this.price + "]:");
        this.price = getInput(this.price);

        System.out.println("Edit Copies [" + this.copies + "]:");
        this.copies = getInput(this.copies);
    }

    @Override
    public String toString() {
        return "BowlingSupply{" +
                "color='" + color + '\'' +
                ", price=" + price + ", copies=" + copies +
                '}';
    }
}
