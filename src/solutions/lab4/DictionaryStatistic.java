package solutions.lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DictionaryStatistic {
    private String[] words;
    private int dictionarySize;
    private int polindrom;
    private int maxWordLength;
    private int minWordLength;
    private char[] alphabet;
    private int[] frequency;

    public DictionaryStatistic(String[] words, char[] alphabet) {
        this.words = words;
        this.alphabet = alphabet;
        this.dictionarySize = words.length;
        this.frequency = new int[alphabet.length];
        
        this.maxWordLength = 0;
        this.minWordLength = Integer.MAX_VALUE;

        analyze();
    }

    private void analyze() {
        for (String word : words) {
            String lowerWord = word.toLowerCase();

            if (lowerWord.length() > maxWordLength) {
                maxWordLength = lowerWord.length();
            }
            if (lowerWord.length() < minWordLength) {
                minWordLength = lowerWord.length();
            }

            if (isPalindrome(lowerWord)) {
                polindrom++;
            }

            countLetters(lowerWord);
        }
    }

    private boolean isPalindrome(String word) {
        if (word.length() < 2) return false;

        int left = 0;
        int right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private void countLetters(String word) {
        char[] chars = word.toCharArray();
        for (char c : chars) {
            for (int i = 0; i < alphabet.length; i++) {
                if (c == alphabet[i]) {
                    frequency[i]++;
                    break;
                }
            }
        }
    }

    public String getRandomWord() {
        if (dictionarySize == 0) return null;
        Random random = new Random();
        int index = random.nextInt(dictionarySize);
        return words[index];
    }

    public void printSymbolsStat() {
        System.out.println("--- Частота букв в словаре ---");
        for (int i = 0; i < alphabet.length; i++) {
            if (frequency[i] > 0) {
                System.out.println(alphabet[i] + " - " + frequency[i]);
            }
        }
    }

    public void printGeneralStat() {
        System.out.println("--- Общая статистика ---");
        System.out.println("Количество слов: " + dictionarySize);
        System.out.println("Палиндромов: " + polindrom);
        System.out.println("Мин. длина слова: " + minWordLength);
        System.out.println("Макс. длина слова: " + maxWordLength);
    }

    public List<String> findSubWords(String inputWord) {
        List<String> foundWords = new ArrayList<>();
        int[] inputCharsCount = getCharCounts(inputWord.toLowerCase());

        for (String dictWord : words) {
            if (dictWord.length() > inputWord.length()) continue;
            
            int[] dictWordCharsCount = getCharCounts(dictWord.toLowerCase());

            if (canFormWord(inputCharsCount, dictWordCharsCount)) {
                foundWords.add(dictWord);
            }
        }
        return foundWords;
    }

    private int[] getCharCounts(String s) {
        int[] counts = new int[alphabet.length];
        for (char c : s.toCharArray()) {
            for (int i = 0; i < alphabet.length; i++) {
                if (c == alphabet[i]) {
                    counts[i]++;
                    break;
                }
            }
        }
        return counts;
    }

    private boolean canFormWord(int[] sourceCounts, int[] targetCounts) {
        for (int i = 0; i < sourceCounts.length; i++) {
            if (targetCounts[i] > sourceCounts[i]) {
                return false;
            }
        }
        return true;
    }
}