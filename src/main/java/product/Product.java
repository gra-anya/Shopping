package product;

public abstract class Product {

    protected String name;
    protected int price;

    public Product(){
    }

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return name +
                ", цена: " + price +
                "уе, количество:";
    }
}
