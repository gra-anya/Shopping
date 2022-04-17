
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

    public void printOrder() {
        System.out.println("Ваш заказ");
        int index = 1;
        for (Product product : products.keySet()) {
            System.out.println(product + " " + products.get(product));
        }
        System.out.println("Сумма вашего заказа: " + orderSum());

    }

}
