package fintech.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import fintech.model.Account;
import fintech.model.Transaction;

/**
 * @author 12S23023 Lenni Hutapea
 * @author 12S23045 Chintya Reginauli Rajagukguk
 */

public class Driver2 {

    public static void main(String[] _args) {
        Scanner scanner = new Scanner(System.in);
        List<Account> accounts = new ArrayList<>();
        List<Transaction> transactions = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String command = scanner.nextLine();

            if (command.equals("create-account")) {
                String owner = scanner.nextLine();
                String accountName = scanner.nextLine();
                accounts.add(new Account(owner, accountName));
                System.out.println(accountName + "|" + owner + "|0.0");

            } else if (command.equals("create-transaction")) {
                String accountName = scanner.nextLine();
                double amount = Double.parseDouble(scanner.nextLine());
                String postedAt = scanner.nextLine();
                String note = scanner.nextLine();

                Account account = null;
                for (Account acc : accounts) {
                    if (acc.getAccountNumber().equals(accountName)) {
                        account = acc;
                        break;
                    }
                }

                if (account != null) {
                    account.increaseBalance(amount);
                    Transaction transaction = new Transaction(accountName, amount, postedAt, note);
                    transactions.add(transaction);
                    System.out.println(transaction + "|" + account.getBalance());
                } else {
                    System.out.println("Akun tidak ditemukan!");
                }
            }
        }

        scanner.close();

        System.exit(0);
    }
}