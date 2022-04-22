import messenger.ConsoleMessenger;
import messenger.Messenger;
import product.Book;
import product.Product;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderMaker {
    private Store store;
    private Messenger messenger;
    private BufferedReader reader;
    private Buyer buyer;
    private Order order;
    private int minOrderSum = 1000;

    public OrderMaker() {
        messenger = new ConsoleMessenger();
        reader = new BufferedReader(new InputStreamReader(System.in));
        store = new Store.Builder()
                .setProduct(new Book("Братья Карамазовы", "Ф.М.Достоевский", 500))
                .setProduct(new Book("Идиот", "Ф.М.Достоевский", 300))
                .setProduct(new Book("Темные аллеи", "И.А.Бунин", 200))
                .build();
    }

    public void beginOrder() throws IOException {
        messenger.sendMessage("Здравствуйте. Для авторизации введите свой email и имя.");
        buyer = new Buyer(reader.readLine(), reader.readLine());
        order = new Order(buyer, messenger);
        messenger.sendMessage("Список доступных товаров:");
        store.printAvailableProducts();
    }

    public void orderAcceptance() throws IOException {
        while (isSumOrderSmallerThenMin()) {
            messenger.sendMessage("Выберите товар, формат *Индекс Количество*");
            messenger.sendMessage("Минимальная сумма заказа: " + minOrderSum);
            messenger.sendMessage("Для завершения заказа введите END");
            String input = reader.readLine();
            if (input.equalsIgnoreCase("END")) {
                break;
            }
            String[] orderStr = input.split(" ");
            Product product = store.getProducts().get(Integer.parseInt(orderStr[0]) - 1);
            int count = Integer.parseInt(orderStr[1]);
            order.putProduct(product, count);
            messenger.sendMessage(order.toString());
        }
        messenger.sendMessage("Спасибо за Ваш заказ!");
    }

    public boolean isSumOrderSmallerThenMin() {
        return order.orderSum() < minOrderSum;
    }


    public static void main(String[] args) throws IOException {
        OrderMaker orderMaker = new OrderMaker();
        orderMaker.beginOrder();
        orderMaker.orderAcceptance();
    }

}
