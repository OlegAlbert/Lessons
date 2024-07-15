import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // слова, которые будем обрабатывать
        String[] words = {
                "dog", "cat", "dog", "hamster", "cat", "dog",
                "fish", "hedgehog", "grape", "hedgehog", "fish", "dog",
                "snake", "cat", "bird", "hedgehog"
        };

        // словарь для хранения уникальных слов
        Set<String> uniqueWords = new HashSet<>();

        // подсчет частоты слов
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            uniqueWords.add(word);

            // добавляем слова в подсчет. Если слово уже есть, то увеличиваем счетчик
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }

        System.out.println("Уникальные слова: " + uniqueWords);
        System.out.println("Частота втречаемости слов: " + wordCount);


        // Задание №2

        // создание телефонной книжки
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Иванов", "123456789");
        phoneBook.add("Петров", "987654321");
        phoneBook.add("Сидоров", "555555555");
        phoneBook.add("Петров", "333333333");
        phoneBook.add("Иванов", "444444444");
        phoneBook.add("Ежов", "8787878787");

        System.out.println("Телефоны фамилии Иванов: " + phoneBook.get("Иванов"));
        System.out.println("Телефоны фамилии Петров: " + phoneBook.get("Петров"));
        System.out.println("Телефоны фамилии Сидоров: " + phoneBook.get("Сидоров"));
        System.out.println("Телефоны фамилии Ежов: " + phoneBook.get("Ежов"));
        System.out.println("Телефоны фамилии Абутьев: " + phoneBook.get("Абутьев"));
    }
}