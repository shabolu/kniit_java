package solutions.lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final char[] RUS_ALPHABET = {
            'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й',
            'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф',
            'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я'
    };

    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        
        File file = new File("dictionary.txt"); 

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine().trim();
                if (!line.isEmpty()) {
                    wordList.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл словаря не найден!");
            return;
        }

        String[] wordsArray = wordList.toArray(new String[0]);

        DictionaryStatistic stats = new DictionaryStatistic(wordsArray, RUS_ALPHABET);

        stats.printGeneralStat();
        System.out.println();
        stats.printSymbolsStat();
        System.out.println();
        System.out.println("Случайное слово: " + stats.getRandomWord());
        System.out.println();

        Scanner consoleScanner = new Scanner(System.in);
        System.out.println("=== ИГРА В СЛОВА ===");
        System.out.println("Введите слово (или 'exit' для выхода):");

        while (true) {
            System.out.print("> ");
            String input = consoleScanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            List<String> subWords = stats.findSubWords(input);
            
            if (subWords.isEmpty()) {
                System.out.println("Ничего не найдено.");
            } else {
                System.out.println("Найдено слов: " + subWords.size());
                
                System.out.println(String.join(", ", subWords));
            }
            System.out.println();
        }
        
        consoleScanner.close();
    }
}
