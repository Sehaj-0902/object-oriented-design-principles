import java.util.ArrayList;

class Product {
    // Class attributes
    private String productName;
    private double price;

    // Parameterized Constructor
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
    }

    // Method to get product price
    public double getProductPrice() {
        return price;
    }

    // Method to get product details
    public String getProductDetails() {
        return productName + " - Rs " + price;
    }
}

class Order {
    // Class attributes
    private int orderId;
    private ArrayList<Product> products;

    // Parameterized Constructor
    public Order(int orderId) {
        this.orderId = orderId;
        this.products = new ArrayList<>();
    }

    // Method to add products
    public void addProduct(Product product) {
        products.add(product);
    }

    // Method to calculate total cost
    public double calculateTotalCost() {
        double totalCost = 0;
        for (Product product : products) {
            totalCost += product.getProductPrice();
        }
        return totalCost;
    }

    // Method to display order details
    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Products:");
        for (Product product : products) {
            System.out.println("-> " + product.getProductDetails());
        }
        System.out.println("Total: Rs " + calculateTotalCost());
    }
}

class Customer {
    // Class attributes
    private String customerName;
    private ArrayList<Order> orders;

    // Parameterized Constructor
    public Customer(String customerName) {
        this.customerName = customerName;
        this.orders = new ArrayList<>();
    }

    // Method to get customer name
    public String getCustomerName() {
        return customerName;
    }

    // Method to place an order
    public void placeOrder(Order order) {
        orders.add(order);
    }

    // Method to display order details
    public void displayOrderDetails() {
        System.out.println(customerName + "'s order details:");
        for (Order order : orders) {
            order.displayOrderDetails();
        }
    }
}

public class ECommerceSystem {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Charlie");

        Product product1 = new Product("Laptop", 12000.0);
        Product product2 = new Product("Mouse", 2500.0);
        Product product3 = new Product("Keyboard", 5000.0);
        Product product4 = new Product("Charger", 3500.0);

        Order order1 = new Order(101);
        order1.addProduct(product1);
        order1.addProduct(product2);

        Order order2 = new Order(102);
        order2.addProduct(product3);
        order2.addProduct(product4);

        customer1.placeOrder(order1);
        customer2.placeOrder(order2);

        customer1.displayOrderDetails();
        customer2.displayOrderDetails();
    }
}

/*
Output:
    Alice's order details:
    Order ID: 101
    Products:
    -> Laptop - Rs 12000.0
    -> Mouse - Rs 2500.0
    Total: Rs 14500.0
    Charlie's order details:
    Order ID: 102
    Products:
    -> Keyboard - Rs 5000.0
    -> Charger - Rs 3500.0
    Total: Rs 8500.0
 */