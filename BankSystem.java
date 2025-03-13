import java.util.ArrayList;

class Bank {
    // Class attributes
    private String bankName;
    private ArrayList<Customer> customers;

    // Parameterized Constructor
    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
    }

    // Method to open account
    public void openAccount(Customer customer) {
        customers.add(customer);
        System.out.println(customer.getCustomerName() + " opened an account at " + bankName);
    }

    // Method to get bank name
    public String getBankName() {
        return bankName;
    }
}

class Customer {
    // Class attributes
    private String customerName;
    private double balance;
    private Bank bank;

    // Parameterized Constructor
    public Customer(String customerName, double balance, Bank bank) {
        this.customerName = customerName;
        this.balance = balance;
        this.bank = bank;
    }

    // Method to view balance
    public void viewBalance() {
        System.out.println("Balance: Rs " + balance);
    }

    // Method to get customer name
    public String getCustomerName() {
        return customerName;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(customerName + " deposited Rs " + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println(customerName + " withdrew Rs " + amount);
        } else if (amount <= 0){
            System.out.println("Invalid withdraw amount");
        }
        else {
            System.out.println("Insufficient balance.");
        }
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Bank bank = new Bank("SBI");

        Customer customer1 = new Customer("Alice", 1000.0, bank);
        Customer customer2 = new Customer("Charlie", 500.0, bank);

        bank.openAccount(customer1);
        bank.openAccount(customer2);

        System.out.println(customer1.getCustomerName() + "'s Bank Details:");
        customer1.viewBalance();
        customer1.deposit(200);
        customer1.viewBalance();

        System.out.println(customer2.getCustomerName() + "'s Bank Details:");
        customer2.viewBalance();
        customer2.withdraw(100);
        customer2.viewBalance();
    }
}

/*
Output:
    Alice opened an account at SBI
    Charlie opened an account at SBI
    Alice's Bank Details:
    Balance: Rs 1000.0
    Alice deposited Rs 200.0
    Balance: Rs 1200.0
    Charlie's Bank Details:
    Balance: Rs 500.0
    Charlie withdrew Rs 100.0
    Balance: Rs 400.0
 */