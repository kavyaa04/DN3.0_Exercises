import java.util.HashMap;

class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class InventoryManagement {
    private HashMap<String, Product> inventory;

    public InventoryManagement() {
        inventory = new HashMap<>();
    }

    public void addProduct(String productId, String productName, int quantity, double price) {
        Product product = new Product(productId, productName, quantity, price);
        inventory.put(productId, product);
    }

    public void updateProduct(String productId, int quantity, double price) {
        Product product = inventory.get(productId);
        if (product != null) {
            product.setQuantity(quantity);
            product.setPrice(price);
        }
    }

    public void deleteProduct(String productId) {
        inventory.remove(productId);
    }

    public Product getProduct(String productId) {
        return inventory.get(productId);
    }
}

public class Main {
    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();
        inventory.addProduct("P001", "Product1", 100, 10.5);
        inventory.addProduct("P002", "Product2", 200, 15.0);

        inventory.updateProduct("P001", 150, 10.0);

        Product product = inventory.getProduct("P001");
        System.out.println("Product ID: " + product.getProductId() + ", Name: " + product.getProductName() +
                           ", Quantity: " + product.getQuantity() + ", Price: " + product.getPrice());

        inventory.deleteProduct("P002");
    }
}
