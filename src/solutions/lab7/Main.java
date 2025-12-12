package solutions.lab7;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {
    public static void main(String[] args) {
        Path rootPath = Paths.get("test_folder"); 

        createTestEnvironmentIfNeeded(rootPath);

        System.out.println("Начинаем обход директории: " + rootPath.toAbsolutePath());

        WordCountingVisitor visitor = new WordCountingVisitor();

        try {
            Files.walkFileTree(rootPath, visitor);

            System.out.println("------------------------------------------------");
            System.out.println("Обход завершен.");
            System.out.println("Всего текстовых файлов найдено: " + visitor.getTextFilesCount());
            System.out.println("Общее количество слов во всех файлах: " + visitor.getTotalWordCount());

        } catch (IOException e) {
            System.out.println("Ошибка при обходе дерева файлов: " + e.getMessage());
        }
    }

    private static class WordCountingVisitor extends SimpleFileVisitor<Path> {
        private long totalWordCount = 0;
        private int textFilesCount = 0;

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
            if (file.toString().endsWith(".txt")) {
                textFilesCount++;
                long wordsInFile = countWords(file);
                
                totalWordCount += wordsInFile;

                System.out.println("Файл: " + file.getFileName() + " -> слов: " + wordsInFile);
            }
            return FileVisitResult.CONTINUE;
        }

        private long countWords(Path file) {
            long count = 0;
            try (BufferedReader reader = Files.newBufferedReader(file)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.trim().isEmpty()) continue;
                    
                    String[] words = line.trim().split("\\s+");
                    count += words.length;
                }
            } catch (IOException e) {
                System.out.println("Не удалось прочитать файл: " + file);
            }
            return count;
        }

        public long getTotalWordCount() {
            return totalWordCount;
        }

        public int getTextFilesCount() {
            return textFilesCount;
        }
    }

    private static void createTestEnvironmentIfNeeded(Path root) {
        if (Files.exists(root)) return;

        try {
            System.out.println("Создаем тестовую структуру папок...");
            Files.createDirectories(root.resolve("subfolder1"));
            Files.createDirectories(root.resolve("subfolder2/deep"));

            Files.write(root.resolve("note1.txt"), "Hello world this is java".getBytes());
            Files.write(root.resolve("image.png"), "not a text file".getBytes());
            Files.write(root.resolve("subfolder1/note2.txt"), "NIO is very powerful".getBytes());
            Files.write(root.resolve("subfolder2/deep/note3.txt"), "Recursive file walking example".getBytes());
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}