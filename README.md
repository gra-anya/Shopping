***Избегание магических чисел***

объявлено глобальное поле minOrderSum (минимальная сумма заказа) [(строка 16)](https://github.com/gra-anya/Shopping/blob/main/src/main/java/OrderMaker.java) , вместо того чтобы просто использовать "магическое" число в методах.

***DRY***

создан метод printAvailableProducts() [(строка 29)](https://github.com/gra-anya/Shopping/blob/main/src/main/java/Store.java) для вывода доступных товаров, вместо того чтобы постоянно повторять это кусок кода.

***SOLID***

* *S - принцип единственной ответственности (Класс должен выполнять только те функции, для которых он логически предназначен)*

Функции заказа вынесены в класс [Order](https://github.com/gra-anya/Shopping/blob/main/src/main/java/Order.java), а не находятся в классе [Product](https://github.com/gra-anya/Shopping/blob/main/src/main/java/product/Product.java) (например).

* *O - Принцип открытости/закрытости (программные сущности должны быть открыты для расширения, но закрыты для модификации)*

Класс [OrderMaker](https://github.com/gra-anya/Shopping/blob/main/src/main/java/OrderMaker.java) использует метод sendMessage([строка 29](https://github.com/gra-anya/Shopping/blob/main/src/main/java/OrderMaker.java)) интерфейса [Messenger](https://github.com/gra-anya/Shopping/blob/main/src/main/java/messenger/Messenger.java)  для отправки сообщения. Для добавления новой функциональности (например отправка сообщений через Telegram) достаточно будет имплементировать в новый класс интерфейс [Messenger](https://github.com/gra-anya/Shopping/blob/main/src/main/java/messenger/Messenger.java) и реализовать в нем метод sendMessage, и все будет работать без модификаций.

* *L - Принцип замены Барбары Лисков (Наследники должны логически иметь возможность сыграть роль своих предков)*

Класс [VintageBook](https://github.com/gra-anya/Shopping/blob/main/src/main/java/product/VintageBook.java) наследуется от [Book](https://github.com/gra-anya/Shopping/blob/main/src/main/java/product/Book.java), так как может логически "играть эту роль", а класс [EBook](https://github.com/gra-anya/Shopping/blob/main/src/main/java/product/EBook.java) не наследуется от [Book](https://github.com/gra-anya/Shopping/blob/main/src/main/java/product/Book.java), хоть они и похожи.

* *D - принцип инверсии зависимостей(Всё зависит от абстракций (интерфейсов), а не от деталей реализации)*

Класс [Order](https://github.com/gra-anya/Shopping/blob/main/src/main/java/Order.java) использует в своем методе (строка 17) абстрактный класс [Product](https://github.com/gra-anya/Shopping/blob/main/src/main/java/product/Product.java), при добавлении нового класса-товара достаточно будет унаследовать его от [Product](https://github.com/gra-anya/Shopping/blob/main/src/main/java/product/Product.java), чтобы класс [Order](https://github.com/gra-anya/Shopping/blob/main/src/main/java/Order.java) его мог с ним работать.
