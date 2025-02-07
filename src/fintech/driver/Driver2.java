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
            String command = scanner.nextLine().trim();

            if (command.equals("create-account")) {
                String owner = scanner.nextLine().trim();
                String accountName = scanner.nextLine().trim();
                accounts.add(new Account(owner, accountName));
                System.out.println(accountName + "|" + owner + "|0.0");

            } else if (command.equals("create-transaction")) {
                String accountName = scanner.nextLine().trim();
                double amount = Double.parseDouble(scanner.nextLine().trim());
                String postedAt = scanner.nextLine().trim();
                String note = scanner.nextLine().trim();

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
                    System.out.println(transaction.getId() + "|" + transaction.getAccountName() + "|" +
                                       transaction.getAmount() + "|" + transaction.getPostedAt() + "|" +
                                       transaction.getNote() + "|" + account.getBalance());
                } else {
                    System.out.println("Akun tidak ditemukan!");
                }

                // Program berhenti setelah transaksi pertama selesai
                scanner.close();
                return; // Langsung keluar dari main method
            }
        }

        // Menutup Scanner jika tidak ada transaksi
        scanner.close();
    }
}
