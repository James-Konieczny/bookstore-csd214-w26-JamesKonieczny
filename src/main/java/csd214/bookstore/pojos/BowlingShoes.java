package csd214.bookstore.pojos;

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
    public void initialize() {
        super.initialize();

        System.out.println("Enter Shoe Size:");
        this.shoeSize = Integer.parseInt(getInput("9"));

        super.initPriceCopies();
    }

    @Override
    public void sellItem() {
        System.out.println("Selling Bowling Shoes (Size " + shoeSize + ")...");
        setCopies(getCopies() - 1);
    }

    @Override
    public void edit() {
        super.edit();

        System.out.println("Edit Shoe Size [" + this.shoeSize + "]:");
        this.shoeSize = getInput(this.shoeSize);
    }

    @Override
    public String toString() {
        return "Bowling Shoes{Shoe Size='" + shoeSize + "', " + super.toString() + "}";
    }
}

