package solutions.lab10.task19;

public class Main {
    public static <T extends Comparable<T>> T findMax(T[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        T max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i].compareTo(max) > 0) {
                max = array[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Integer[] numbers = {1, 10, 3, 4, 5};
        System.out.println("Максимальное число: " + findMax(numbers)); // 10

        String[] words = {"apple", "banana", "cherry", "orange"};
        System.out.println("Максимальная строка: " + findMax(words)); // orange (так как 'o' идет позже 'c')

        Double[] doubles = {1.5, 9.9, 3.14, -20.0};
        System.out.println("Максимальное дробное: " + findMax(doubles)); // 9.9
    }
}