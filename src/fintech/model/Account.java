package fintech.model;

/**
 * @author 12S23023 Lenni Hutapea
 * @author 12S23045 Chintya Reginauli Rajagukguk
 */
public class Account {

    private String owner;
    private String accountName;
    private double balance;

    public Account(String _owner, String _accountName) {
        this.owner = _owner;
        this.accountName = _accountName;
        this.balance = 0.0;
    }

    public String getowner() {
        return owner;
    }

    public String getAccountNumber() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void increaseBalance(double amount) {
        this.balance += amount;
    }

    public void decreaseBalance(double amount) {
        if (amount > balance) {
            System.out.println("Saldo tidak mencukupi!");
        } else {
            this.balance -= amount;
        }
    }

    @Override
    public String toString() {
        return accountName + "|" + owner + "|" + balance;
    }
}