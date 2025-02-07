package fintech.driver;

/**
 * @author 12S23023 Lenni Hutapea
 * @author 12S23045 Chintya Reginauli Rajagukguk
 */

import java.util.Scanner;

import fintech.model.Account;

public class Driver1 {

    public static void main(String[] _args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        if (!command.equals("create-account")) {
            System.out.println("Perintah tidak dikenali!");
            scanner.close();
            return;
        }

        String owner = scanner.nextLine();
        String accountName = scanner.nextLine();

        Account account = new Account(owner, accountName);
        System.out.println(account);

        scanner.close();
    }
}