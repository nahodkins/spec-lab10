import java.util.*;
import java.util.stream.Collectors;

public class CommonProductStorage {

    private Map<String, Product> commonStorage;
    private Map<String, List<Product>> collisionStorage;

    public CommonProductStorage() {
        commonStorage = new HashMap<>();
        collisionStorage = new HashMap<>();
    }

    public void addNewStorage(ProductStorage storage) {
        storage.getArticleProductMap()
                .forEach((key, value) -> {
                    if (collisionStorage.containsKey(key)) {
                        collisionStorage.get(key).add(value);
                    } else {
                        if (commonStorage.containsKey(key)) {
                            collisionStorage.put(key, new ArrayList<>(List.of(value)));
                            collisionStorage.get(key).add(commonStorage.get(key));
                            commonStorage.remove(key);
                        } else {
                            commonStorage.put(key, value);
                        }
                    }
                });
    }

    public List<Product> getSortedProducts() {
        return commonStorage.values().stream()
                .sorted(Comparator.comparing(Product::getShelfLife))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Common storage: " + commonStorage +
                "\nCollision storage: " + collisionStorage;
    }
}
