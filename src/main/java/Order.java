
import messenger.Messenger;
import product.Product;

import java.util.HashMap;
import java.util.Map;

public class Order {

    private Map<Product, Integer> products;
    private Buyer buyer;

    public Order(Buyer buyer) {
        products = new HashMap<>();
        this.buyer = buyer;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public Buyer getBuyer() {
        return buyer;
    }


    public Order putProduct(Product product, int count) {
        if (products.containsKey(product)) {
            products.put(product, products.get(product) + count);
        } else {
            products.put(product, count);
        }
        return this;
    }

    public int orderSum() {
        int sum = 0;
        for (Product product : products.keySet()) {
            sum += product.getPrice() * products.get(product);
        }
        return sum;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("Ваш заказ: \n");
        int index = 1;
        for (Product product : products.keySet()) {
            builder.append(product)
                    .append(" ")
                    .append(products.get(product))
                    .append("\n");
        }
        builder.append("Сумма вашего заказа: " + orderSum());
        return builder.toString();
    }

}
