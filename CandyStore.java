import java.util.ArrayList;

public class CandyStore {
    private ArrayList<Candy> inventory = new ArrayList<Candy>();
    private ArrayList<Customer> customers = new ArrayList<Customer>();
    private int MAX_INVENTORY = 1000;
    private int MAX_CUSTOMERS = 1000;

    public CandyStore() {
        this.inventory = new ArrayList<Candy>(MAX_INVENTORY);
        this.customers = new ArrayList<Customer>(MAX_CUSTOMERS);
    }

    public int getInventorySize() {
        return this.inventory.size();
    }

    public int getCustomerCount() {
        return this.customers.size();
    }

    public void addCandy(Candy candy) {
        if (this.inventory.size() + 1 > MAX_INVENTORY) {
            throw new IllegalStateException("inventory is full");
        }
        if (this.inventory.contains(candy)) {
            throw new IllegalStateException("Candy is already in inventory");
        }

        this.inventory.add(candy);
    }


    public Candy findCandy(String name) {
        for (Candy candy : this.inventory) {
            if (candy.getName().equals(name)) {
                return candy;
            }
        }
        throw new IllegalArgumentException("could not find candy");
    }

    public void addCustomer(String name, String loyaltyNumber) {
        if (this.customers.size() + 1 > MAX_CUSTOMERS) {
            throw new IllegalStateException("store is full");
        }

        for (Customer customer : this.customers) {
            if (customer.getLoyaltyNumber().equals(loyaltyNumber)) {
                throw new IllegalStateException("customer with this loyalty number already exists");
            }
        }

        Customer newCustomer = new Customer(name, loyaltyNumber);
        this.customers.add(newCustomer);
    }

    public void addCustomer(Customer c) {
        if (this.customers.size() + 1 > MAX_CUSTOMERS) {
            throw new IllegalStateException("store is full.");
        }

        for (Customer customer : this.customers) {
            if (customer.getLoyaltyNumber().equals(c.getLoyaltyNumber())) {
                throw new IllegalStateException("customer with this loyalty number already in store");
            }
        }

        this.customers.add(c);
    }

    public Customer findCustomer(String loyaltyNumber) {
        for (int i = 0; i < this.customers.size(); i++) {
            Customer currentCustomer = this.customers.get(i);
            if (currentCustomer.getLoyaltyNumber().equals(loyaltyNumber)) {
                return currentCustomer;
            }
        }
        throw new IllegalArgumentException("wasn't able to find a customer with that loyalty number");
    }

    public ArrayList<Candy> findNutFreeCandy() {
        ArrayList<Candy> nutFreeCandy = new ArrayList<Candy>();

        for (Candy candy : this.inventory) {
            if (!candy.isContainsNuts()) {
                nutFreeCandy.add(candy);
            }
        }

        return nutFreeCandy;
    }

    public ArrayList<Candy> findLowStock(double threshold) {
        ArrayList<Candy> lowStockCandy = new ArrayList<Candy>();

        for (int i = 0; i < this.inventory.size(); i++) {
            Candy candy = this.inventory.get(i);
            if (candy.getQuantityInStock() < threshold) {
                lowStockCandy.add(candy);
            }
        }
        return lowStockCandy;
    }

    public ArrayList<Candy> findCandyByType(String type) {
        ArrayList<Candy> matchingCandy = new ArrayList<Candy>();

        for (Candy candy : this.inventory) {
            if (candy.getType().equals(type)) {
                matchingCandy.add(candy);
            }
        }

        return matchingCandy;
    }

    public ArrayList<Candy> getInventory() {
        return inventory;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public int getMAX_INVENTORY() {
        return MAX_INVENTORY;
    }

    public int getMAX_CUSTOMERS() {
        return MAX_CUSTOMERS;
    }
}