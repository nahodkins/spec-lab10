import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class ProductDequeue {

    private Queue<Product> products;

    public ProductDequeue() {
        products = new PriorityQueue<>(Comparator.comparing(Product::getShelfLife));
    }

    public void add(Product product) {
        products.add(product);
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
