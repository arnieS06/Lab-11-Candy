public class Candy {
    private String name;
    private String type;
    private double pricePerPound;
    private double quantityInStock;
    private boolean containsNuts;

    public Candy(String name, String type, double pricePerPound, boolean containsNuts) {
        if (name == null || type == null || pricePerPound <= 0) {
            throw new IllegalArgumentException("Invalid data");
        }

        this.name = name;
        this.type = type;
        this.pricePerPound = pricePerPound;
        this.containsNuts = containsNuts;
        this.quantityInStock = 0.0;

    }

    public void addStock(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException();
        }

        this.quantityInStock += amount;
    }

    public double removeStock(double amount) { // needs work

        if (amount <= 0) {
            throw new IllegalArgumentException("amount entered was too low");
        }

        else if (amount > getQuantityInStock()) {
            this.quantityInStock -= (amount - this.quantityInStock);
            return amount;
        }

        this.quantityInStock -= amount;
        return amount;
    }

    public String toString() {
        return ("Candy name: " + getName() + ", type: " + getType() + ", price/lb: " + getPricePerPound() + ", has nuts: " + isContainsNuts());
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPricePerPound() {
        return pricePerPound;
    }

    public double getQuantityInStock() {
        return quantityInStock;
    }

    public boolean isContainsNuts() {
        return containsNuts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPricePerPound(double pricePerPound) {
        this.pricePerPound = pricePerPound;
    }

    public void setContainsNuts(boolean containsNuts) {
        this.containsNuts = containsNuts;
    }


}
