import java.time.LocalDate;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

public class ProductDequeue {

    private Deque<Product> products;

    public ProductDequeue() {
        products = new ArrayDeque<>();
    }

    public void add(Product product) {
        LocalDate shelfLife = product.getShelfLife();
        if (products.isEmpty()) {
            products.add(product);
        } else if (products.getFirst().getShelfLife().isAfter(shelfLife)) {
            products.addFirst(product);
        } else {
            products.addLast(product);
        }
    }

    public void add(Product ...products) {
        for (Product p : products) {
            add(p);
        }
    }

    @Override
    public String toString() {
        return products.stream()
                .map(Product::toString)
                .collect(Collectors.joining("\n"));
    }
}
