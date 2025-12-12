package solutions.lab11.task25;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FileProcessor processor = new FileProcessor();

        printMenu();

        while (true) {
            System.out.print("\n> ");
            String input = scanner.nextLine().trim();
            String[] parts = input.split(" ", 2);
            String command = parts[0];

            switch (command) {
                case "help" -> printMenu();
                case "scan" -> {
                    if (parts.length < 2) {
                        System.out.println("Укажите путь. Пример: scan /Users/name/Docs");
                    } else {
                        String path = parts[1].replace("\"", ""); 
                        processor.processPath(path);
                    }
                }

                case "list" -> processor.listFiles();

                case "saveLocal" -> {
                    if (parts.length < 2) {
                        System.out.println("Укажите ID. Пример: saveLocal 5");
                    } else {
                        try {
                            int id = Integer.parseInt(parts[1]);
                            processor.saveLocal(id);
                        } catch (NumberFormatException e) {
                            System.out.println("ID должен быть числом.");
                        }
                    }
                }

                case "exit" -> {
                    System.out.println("Выход.");
                    return;
                }

                default -> System.out.println("Неизвестная команда.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("=== Файловое хранилище ===");
        System.out.println("Команды:");
        System.out.println("1. scan [путь]       - Сканировать папку и сохранить файлы (<10MB) в БД");
        System.out.println("2. list              - Показать файлы в БД");
        System.out.println("3. saveLocal [id]    - Скачать файл из БД на диск");
        System.out.println("4. exit              - Выход");
        System.out.println("5. help.             - Вывести меню еще раз");
    }
}