import java.util.*;
import java.util.stream.Collectors;

public class Shop {

    private static final String TO_STRING_TEMPLATE = "%s; Number: %d";

    private ProductDequeue productDequeue;
    private Map<Product, Integer> productsNumber;

    public Shop() {
        productDequeue = new ProductDequeue();
        productsNumber = new WeakHashMap<>();
    }

    public void addProduct(Product product) {
        if (productsNumber.containsKey(product)) {
            productsNumber.put(product, productsNumber.get(product) + 1);
        } else {
            productDequeue.add(product);
            productsNumber.put(product, 1);
        }
    }

    public Collection<Product> getProducts() {
        return Collections.unmodifiableCollection(productDequeue.getProducts());
    }

    public Map<Product, Integer> getProductsNumber() {
        return Collections.unmodifiableMap(productsNumber);
    }

    public Product getProduct(String vendorCode) {
        return productDequeue.stream()
                .filter(product -> product.getVendorCode().equals(vendorCode))
                .findFirst()
                .get();
    }

    public Integer getProductNumber(String vendorCode) {
        return productsNumber.get(getProduct(vendorCode));
    }

    @Override
    public String toString() {
        return productDequeue.stream()
                .map(product -> String.format(TO_STRING_TEMPLATE, product.toString(), productsNumber.get(product)))
                .collect(Collectors.joining("\n"));
    }
}
