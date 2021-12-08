import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Objects;

public class Product {

    private final double cost;
    private final LocalDate shelfLife;
    private final String vendorCode;

    public Product(double cost, LocalDate shelfLife, String vendorCode) {
        this.cost = cost;
        this.shelfLife = shelfLife;
        this.vendorCode = vendorCode;
    }

    public double getCost() {
        return cost;
    }

    public LocalDate getShelfLife() {
        return shelfLife;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    private String getFromattedShelfLife() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);
        return formatter.format(shelfLife);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cost, shelfLife, vendorCode);
    }

    @Override
    public String toString() {
        return "Product: {" +
                "cost: " + cost +
                ", shelfLife: " + getFromattedShelfLife() +
                ", vendorCode: '" + vendorCode + '\'' +
                '}';
    }
}
