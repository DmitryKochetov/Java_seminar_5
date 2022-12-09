// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.

package DZ;

import java.util.*;

public class task1 {
    public static void main(String[] args) {
        Map<Integer, String> db = new HashMap<>();
        db.putIfAbsent(12345, "Иванов");
        db.putIfAbsent(12354, "Петров");
        db.putIfAbsent(12333, "Сидоров");
        db.putIfAbsent(12334, "Сидоров");

        Scanner scanner = new Scanner(System.in, "Cp866");
        System.out.println("Введите фамилию: ");
        String a = scanner.nextLine();
        scanner.close();
        // System.out.println(a);

        for (var item : db.entrySet()) {

            if (a.toLowerCase().equals(item.getValue().toLowerCase())) {

                System.out.println("Фамилия: " + item.getValue() + ", Телефон: " + item.getKey());
            }
        }

    }
}
