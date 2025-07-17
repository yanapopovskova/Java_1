import java.time.LocalDateTime;

public class BankAccount {
    BankAccount(String ownerName) {
        this.ownerName = ownerName;
        this.balance = 0;
        this.openDate = LocalDateTime.now();
        this.isBlocked = false;
    }
    private String ownerName;
    private int balance;
    private LocalDateTime openDate;
    private boolean isBlocked;

    //Метод для пополнения счета
    public boolean deposit(int amound) {
        if (isBlocked || amound <= 0) {
            return false;
        }
        balance += amound;
        return true;
    }

    //Метод для снятия денег
    public boolean withdraw(int amound) {
        if (isBlocked || amound <= 0 || amound > balance) {
            return false;
        }
        balance -= amound;
        return true;
    }

    // Метод для перевода денег на другой счет
    public boolean transfer(BankAccount otherAccount, int amount) {
        if (isBlocked || otherAccount == null || otherAccount.isBlocked ||
                amount <= 0 || amount > balance) {
            return false;
        }

        // Снимаем деньги с текущего счета
        this.balance -= amount;
        // Зачисляем на другой счет
        otherAccount.balance += amount;
        return true;
    }
    public String getOwnerName() {
        return ownerName;
    }

    public int getBalance() {
        return balance;
    }

    public LocalDateTime getOpenDate() {
        return openDate;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setBlocked(boolean blocked) {
        isBlocked = blocked;
    }
}