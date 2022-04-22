package product;

public class Book extends Product {
    private String name;
    private String title;
    private String author;
    private int price;
    private int pages;

    public Book(String title, String author, int price) {
        this.name = title + ". " + author;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    @Override
    public int getPrice() {
        return price;
    }

    public int setPages() {
        return pages;
    }

    @Override
    public String toString() {
        return name +
                ", цена: " + price +
                " уе";
    }
}
