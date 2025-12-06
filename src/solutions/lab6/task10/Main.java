package solutions.lab6.task10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    private static final int MAX_LIVES = 6;
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Виселица ===");

        boolean playAgain = true;
        List<String> dictionary = getWords("dictionary.txt");
        
        while (playAgain) {
            String secretWord = chooseWord(dictionary);
            
            playRound(secretWord);

            System.out.println("\nХотите сыграть еще раз? (да/нет)");
            String answer = scanner.nextLine().toLowerCase();
            if (!answer.equals("да") && !answer.equals("д")) {
                playAgain = false;
            }
        }
        
        System.out.println("Спасибо за игру!");
        scanner.close();
    }

    private static String chooseWord(List<String> dictionary) {
        System.out.println("\nВыберите режим:");
        System.out.println("1 - Одиночная игра (случайное слово)");
        System.out.println("2 - Игра для двоих (ввод слова вручную)");
        System.out.print("> ");
        
        String choice = scanner.nextLine();
        
        if (choice.equals("2")) {
            System.out.println("Игрок 1, введи слово для загадывания:");
            String input = scanner.nextLine().trim().toLowerCase();

            for (int i = 0; i < 50; i++) System.out.println();
            return input;
        } else {
            Random random = new Random();
            return dictionary.get(random.nextInt(dictionary.size()));
        }
    }

    private static void playRound(String secretWord) {
        List<Character> currentWordState = new ArrayList<>();
        for (int i = 0; i < secretWord.length(); i++) {
            currentWordState.add('_');
        }

        Set<Character> usedLetters = new HashSet<>();

        int lives = MAX_LIVES;
        
        while (lives > 0) {
            printGameState(currentWordState, usedLetters, lives);

            if (!currentWordState.contains('_')) {
                System.out.println("Победа! Вы угадали слово: " + secretWord.toUpperCase());
                return;
            }

            System.out.print("Введи букву: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
                System.out.println("Пожалуйста, введи одну букву.");
                continue;
            }

            char letter = input.charAt(0);

            if (usedLetters.contains(letter)) {
                System.out.println("Вы уже вводили эту букву!");
                continue;
            }

            usedLetters.add(letter);

            if (secretWord.indexOf(letter) >= 0) {
                System.out.println("Есть такая буква!");

                for (int i = 0; i < secretWord.length(); i++) {
                    if (secretWord.charAt(i) == letter) {
                        currentWordState.set(i, letter);
                    }
                }
            } else {
                System.out.println("Такой буквы нет.");
                lives--;
            }
        }

        System.out.println("\n💀 Вы проиграли! Жизни закончились.");
        System.out.println("Загаданное слово было: " + secretWord.toUpperCase());
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

    private static void printGameState(List<Character> state, Set<Character> used, int lives) {
        System.out.println("\n----------------------------");
        System.out.println("Слово: ");
        for (Character c : state) {
            System.out.print(c + " ");
        }
        System.out.println();
        System.out.println("Осталось жизней: " + lives);
        System.out.println("Использованные буквы: " + used);
        System.out.println("----------------------------");
    }
}