package solutions.lab10.task21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();

        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "blueberry");
        
        List<String> bWords = filter(words, s -> s.startsWith("b"));
        
        System.out.println("Слова на 'b': " + bWords); 


        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        List<Integer> evens = filter(numbers, n -> n % 2 == 0);
        
        System.out.println("Четные числа: " + evens);


        List<String> longWords = filter(words, s -> s.length() > 5);
        System.out.println("Длинные слова: " + longWords);
    }
}