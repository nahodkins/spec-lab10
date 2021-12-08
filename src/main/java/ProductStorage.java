import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductStorage {

    private static final String TO_STRING_TEMPLATE = "article#%s: %s";

    private Map<String, Product> articleProductMap;

    public ProductStorage() {
        articleProductMap = new HashMap<>();
    }

    public void add(Product product) {
        articleProductMap.put(product.getVendorCode(), product);
    }

    public Product get(String vendorCode) {
        return articleProductMap.getOrDefault(vendorCode, null);
    }

    public Map<String, Product> getArticleProductMap() {
        return articleProductMap;
    }

    @Override
    public String toString() {
        return articleProductMap.entrySet().stream()
                .map(entry -> String.format(TO_STRING_TEMPLATE, entry.getKey(), entry.getValue()))
                .collect(Collectors.joining("\n"));
    }
}
