package solutions.lab5.task9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final long GAME_DURATION_MS = 60000;

    public static void main(String[] args) {
        List<String> dictionary = getWords("dictionary.txt");

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalWordsShown = 0;
        int correctWordsCount = 0;
        int totalCharsTypedCorrectly = 0;

        System.out.println("=== ТРЕНАЖЕР ПЕЧАТИ ===");
        System.out.println("Задача: написать как можно большее количество задач за минуту");
        System.out.println("Нажмите ENTER, чтобы начать...");
        scanner.nextLine();

        long startTime = System.currentTimeMillis();
        System.out.println(">>> Старт! <<<");
        System.out.println();

        while (true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - startTime >= GAME_DURATION_MS) {
                System.out.println("\n--- Время вышло! ---");
                break;
            }

            String targetWord = dictionary.get(random.nextInt(dictionary.size()));
            System.out.println("Слово: " + targetWord);
            System.out.print("Ввод:  ");

            String userWord = scanner.nextLine().trim();

            long timeAfterInput = System.currentTimeMillis();
            if (timeAfterInput - startTime >= GAME_DURATION_MS) {
                System.out.println("\n--- Время вышло! (Последнее слово не учтено) ---");
                break;
            }

            totalWordsShown++;

            if (userWord.equals(targetWord)) {
                System.out.println("Верно!");
                correctWordsCount++;
                totalCharsTypedCorrectly += targetWord.length();
            } else {
                System.out.println("Ошибка!");
            }
            System.out.println("-------------------------");
        }

        long totalTimeSpent = Math.min(System.currentTimeMillis() - startTime, GAME_DURATION_MS);
        double seconds = totalTimeSpent / 1000.0;
        
        double charsPerSecond = totalCharsTypedCorrectly / seconds;
        double charsPerMinute = charsPerSecond * 60;

        System.out.println("\n=== Результаты ===");
        System.out.println("Всего слов выдано: " + totalWordsShown);
        System.out.println("Правильно введено слов: " + correctWordsCount);
        System.out.println("Введено правильных символов: " + totalCharsTypedCorrectly);
        System.out.printf("Скорость печати: %.2f симв/сек (%.0f симв/мин)\n", charsPerSecond, charsPerMinute);
        
        scanner.close();
    }

    public static List<String> getWords(String path) {
        List<String> words = new ArrayList<>();
        File file = new File(path);

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNext()) {
                String word = fileScanner.nextLine().trim();
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + file.getAbsolutePath());
        }
        return words;
    }
}