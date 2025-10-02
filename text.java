import java.util.Scanner;

public class SneakerShop {
    public static void main(String[] args) {
        String[] names = {"Nike Air Max", "Adidas Ultraboost", "Puma RS-X"};
        double[] prices = {120.0, 150.0, 100.0};
        int[] stock = {10, 5, 8};

        Scanner sc = new Scanner(System.in);

        System.out.println("Добро пожаловать в SneakerShop!");

        while (true) {
            System.out.println("\nАссортимент:");
            for (int i = 0; i < names.length; i++) {
                System.out.println((i + 1) + ". " + names[i] + " - $" + prices[i] + " (В наличии: " + stock[i] + ")");
            }
            System.out.println("0. Выход");
            System.out.print("Выберите номер товара для заказа: ");
            int choice = sc.nextInt();

            if (choice == 0) {
                System.out.println("Спасибо за посещение! Пока!");
                break;
            }

            if (choice < 1 || choice > names.length) {
                System.out.println("Неверный выбор. Попробуйте снова.");
                continue;
            }

            System.out.print("Введите количество: ");
            int qty = sc.nextInt();

            if (qty <= 0) {
                System.out.println("Количество должно быть больше нуля.");
                continue;
            }

            if (qty > stock[choice - 1]) {
                System.out.println("Извините, недостаточно товара на складе.");
                continue;
            }

            stock[choice - 1] -= qty;
            double total = prices[choice - 1] * qty;
            System.out.println("Вы заказали " + qty + " x " + names[choice - 1] + ". Итого: $" + total);
        }

        sc.close();
    }
}