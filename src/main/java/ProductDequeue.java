import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public Stream<Product> stream() {
        return products.stream();
    }

    public Queue<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return products.stream()
                .map(Product::toString)
                .collect(Collectors.joining("\n"));
    }
}
