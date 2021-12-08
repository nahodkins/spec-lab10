import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Product banana = new Product(25.0, LocalDate.of(2022, 2, 1), "A123");
        Product apple = new Product(25.0, LocalDate.of(2022, 1, 1), "A124");
        Product tomato = new Product(25.0, LocalDate.of(2022, 3, 1), "A125");
        Product chocolate = new Product(25.0, LocalDate.of(2021, 12, 20), "A127");

        Shop shop = new Shop();
        shop.addProduct(banana);
        shop.addProduct(banana);
        shop.addProduct(apple);
        shop.addProduct(tomato);
        shop.addProduct(chocolate);
        System.out.println(shop);
        System.out.println();
        System.out.println(shop.getProduct("A123"));
        System.out.println(shop.getProductNumber("A123"));
    }
}
