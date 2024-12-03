import java.io.Serializable;

public class Order implements Serializable {
    private int orderId;
    private int productId;
    private int quantity;

    public Order(int orderId, int productId, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Order [Order ID=" + orderId + ", Product ID=" + productId + ", Quantity=" + quantity + "]";
    }
}
