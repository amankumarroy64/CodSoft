import java.util.Scanner;

public class ATM {
    private double balance;
    private Scanner scanner;

    public ATM(double initialBalance) {
        this.balance = initialBalance;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("Welcome to the ATM!");
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            int choice = getChoice();
            switch (choice) {
                case 1:
                    performWithdrawal();
                    break;
                case 2:
                    performDeposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    private int getChoice() {
        int choice = 0;
        while (true) {
            try {
                System.out.print("Enter your choice: ");
                choice = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
        return choice;
    }

    private void performWithdrawal() {
        System.out.print("Enter amount to withdraw: ");
        double amount = getValidAmount();
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal successful. Current Balance: $" + balance);
        } else {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }

    private void performDeposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = getValidAmount();
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Current Balance: $" + balance);
        } else {
            System.out.println("Invalid amount for deposit. Deposit failed.");
        }
    }

    private void checkBalance() {
        System.out.println("Current Balance: $" + balance);
    }

    private double getValidAmount() {
        double amount = 0;
        while (true) {
            try {
                amount = Double.parseDouble(scanner.nextLine());
                if (amount <= 0) {
                    System.out.println("Amount must be greater than zero. Please enter again: ");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid amount: ");
            }
        }
        return amount;
    }

    public static void main(String[] args) {
        ATM atm = new ATM(1000); // Initial balance of $1000
        atm.run();
    }
}

