import product.Product;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Store {
    private List<Product> products;
    private Set<Buyer> buyers;

    public Store() {
    }

    public Store(List<Product> products, Set<Buyer> buyers) {
        this.products = products;
        this.buyers = buyers;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Set<Buyer> getBuyers() {
        return buyers;
    }


    public void printAvailableProducts() {
        int index = 1;
        for (Product product : this.getProducts()) {
            System.out.println(index++ + ". " + product);
        }
    }

    public static class Builder {
        private List<Product> products;
        private Set<Buyer> buyers;

        public Builder setProduct(Product product) {
            if (products == null) {
                products = new ArrayList<>();
            }
            products.add(product);
            return this;
        }

        public Builder setBuyer(Buyer buyer) {
            if (buyers.isEmpty()) {
                buyers = new HashSet<>();
            }
            buyers.add(buyer);
            return this;
        }

        public Store build() {
            return new Store(products, buyers);
        }
    }
}
