public class Main {
    public static void main(String[] args) {
        // два счета
        BankAccount account1 = new BankAccount("Иван Иванов");
        BankAccount account2 = new BankAccount("Илья Макаров");

        // Пополняем первый счет
        boolean depositResult = account1.deposit(1400);
        System.out.println("Пополнение: " + (depositResult ? "успешно" : "неудачно"));

        // Снимаем деньги
        boolean withdrawResult = account1.withdraw(500);
        System.out.println("Снятие: " + (withdrawResult ? "успешно" : "неудачно"));

        // Переводим деньги
        boolean transferResult = account1.transfer(account2, 700);
        System.out.println("Перевод: " + (transferResult ? "успешно" : "неудачно"));

        // Проверяем балансы
        System.out.println("Баланс account1: " + account1.getBalance());
        System.out.println("Баланс account2: " + account2.getBalance());

        // Пробуем снять больше, чем на счете
        boolean invalidWithdraw = account1.withdraw(1000);
        System.out.println("Попытка снять 1000: " + (invalidWithdraw ? "успешно" : "неудачно"));
    }
}
