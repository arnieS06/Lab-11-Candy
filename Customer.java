public class Customer {
    private String name;
    private double loyaltyPoints;
    private String loyaltyNumber;

    public Customer(String name, String loyaltyNumber) {
        if ((name == null || loyaltyNumber == null) || (name.isEmpty() || loyaltyNumber.isEmpty())) {
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.loyaltyNumber = loyaltyNumber;
    }

    public void addPoints(double points) {
        if (points < 0) {
            throw new IllegalArgumentException("Bad input");
        }

        this.loyaltyPoints += points;
    }

    public void removePoints(double points) {
        if (points < 0) {
            throw new IllegalArgumentException("Bad input");
        }

        this.loyaltyPoints -= points;
    }

    public String getName() {
        return name;
    }

    public String getLoyaltyNumber() {
        return loyaltyNumber;
    }

    public String getLoyaltyPoints() {
        return loyaltyPoints;
    }

    public void setLoyaltyPoints(String loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }
}
