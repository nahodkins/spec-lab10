import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Product banana = new Product(25.0, LocalDate.of(2022, 2, 1), "A123");
        Product apple = new Product(25.0, LocalDate.of(2022, 1, 1), "A124");
        Product tomato = new Product(25.0, LocalDate.of(2022, 3, 1), "A125");
        Product chocolate = new Product(25.0, LocalDate.of(2021, 12, 20), "A126");

        ProductStorage storage = new ProductStorage();
        storage.add(banana);
        storage.add(apple);
        storage.add(tomato);
        storage.add(chocolate);
        System.out.println(storage);
        System.out.println();
        System.out.println(storage.get("A126"));
    }
}
