package product;

public class EBook extends Product {
    private String name;
    private String title;
    private String author;
    private int price;

    public EBook(String title, String author, int price) {
        super();
        this.name = title + ". " + author;
        this.title = title;
        this.author = author;
        this.price = price;
    }
}
