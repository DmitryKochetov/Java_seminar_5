// Пусть дан список сотрудников:Иван Иванов ( и остальные, полный текст дз будет на платформе) 
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
// Светлана Петрова

package DZ;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class task2 {
    public static void main(String[] args) throws IOException {
        // объявляем переменные и читаем из файла
        String filePath = "DZ\\base.txt";
        int i = 0;
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        HashMap<String, Integer> uniqueNames = new HashMap<String, Integer>();
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "UTF-8"));
        while ((line = reader.readLine()) != null) {
            // делим строку на части и вытаскиваем в массив. Фамилии не интересуют
            String[] parts = line.split(" ", 2);
            if (parts.length >= 1) {
                int key = i;
                String name = parts[0];
                i++;
                String value = parts[0];
                // тут мы помещаем в словарь уникальные ключи и имена как значения, а в другой
                // словарь одновременно помещаем
                // имена как ключи и нулевые значения, поскольку они не могут повторяться, то
                // получим словарь уникальных имён
                map.putIfAbsent(key, value);
                uniqueNames.putIfAbsent(name, 0);
            }
        }
        for (Integer key : map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }

        reader.close();

        // проверяем, что значения одного словаря содержатся как ключи в списке
        // уникальных имен и в таком случае, увеличиваем соответствующее значение на 1

        for (var item : map.entrySet()) {

            if (uniqueNames.containsKey(item.getValue())) {
                int value = uniqueNames.get(item.getValue());
                uniqueNames.put(item.getValue(), ++value);
            }
        }



        System.out.println("\nКоличество повторяющихся имён в записях файла base.txt:");
        for (String key : uniqueNames.keySet()) {
        System.out.println(key + ":" + uniqueNames.get(key));
        }


        System.out.println("\nКоличество повторяющихся имён в записях файла base.txt по убыванию:");
        
        Map<String, Integer> sortedMapReverseOrder = uniqueNames.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(sortedMapReverseOrder);


    }
}
