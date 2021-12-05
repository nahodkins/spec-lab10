import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Product banana = new Product(25.0, LocalDate.of(2022, 2, 1), "A123");
        Product apple = new Product(25.0, LocalDate.of(2022, 1, 1), "A124");
        Product tomato = new Product(25.0, LocalDate.of(2022, 3, 1), "A125");
        ProductDequeue dequeue = new ProductDequeue();
        dequeue.add(banana, apple, tomato);

        System.out.println(dequeue);
    }
}
