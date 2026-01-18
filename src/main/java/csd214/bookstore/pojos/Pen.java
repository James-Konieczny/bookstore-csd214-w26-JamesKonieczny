package csd214.bookstore.pojos;

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
        System.out.println("Selling " + color + " Pen...");
    }

    @Override
    public void edit() {
        super.edit();
        System.out.println("Edit Color [" + this.color + "]:");
        this.color = getInput(this.color);
    }
}
