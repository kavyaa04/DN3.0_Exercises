import java.util.Arrays;

class Product implements Comparable<Product> {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public int compareTo(Product other) {
        return this.productName.compareTo(other.productName);
    }
}

public class SearchFunctionality {
    public static Product linearSearch(Product[] products, String searchTerm) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(searchTerm)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String searchTerm) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = searchTerm.compareToIgnoreCase(products[mid].getProductName());

            if (result == 0) {
                return products[mid];
            }
            if (result > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product("P001", "Laptop", "Electronics"),
            new Product("P002", "Smartphone", "Electronics"),
            new Product("P003", "Book", "Stationery"),
            new Product("P004", "Chair", "Furniture")
        };

        Arrays.sort(products); // Sorting the array for binary search

        Product foundProduct = linearSearch(products, "Book");
        System.out.println(foundProduct != null ? foundProduct.getProductName() : "Product not found");

        foundProduct = binarySearch(products, "Laptop");
        System.out.println(foundProduct != null ? foundProduct.getProductName() : "Product not found");
    }
}
