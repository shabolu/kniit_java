package solutions.lab11.task24;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);

        printMenu();

        while (true) {
            System.out.print("\nВведите команду: ");
            String input = scanner.nextLine().trim();
            
            if (input.isEmpty()) continue;

            String[] parts = input.split("\\s+");
            String command = parts[0].toLowerCase();

            try {
                switch (command) {
                    case "help" -> printMenu();
                    case "add" -> {
                        if (parts.length < 3) {
                            System.out.println("Использование: add [name] [email]");
                        } else {
                            String name = parts[1];
                            String email = parts[2];
                            userService.registerUser(name, email);
                        }
                    }

                    case "list" -> userService.listAllUsers();

                    case "update" -> {
                        if (parts.length < 4) {
                            System.out.println("Использование: update [id] [new_name] [new_email]");
                        } else {
                            int id = Integer.parseInt(parts[1]);
                            String newName = parts[2];
                            String newEmail = parts[3];
                            userService.updateUser(id, newName, newEmail);
                        }
                    }

                    case "delete" -> {
                        if (parts.length < 2) {
                            System.out.println("Использование: delete [id]");
                        } else {
                            int id = Integer.parseInt(parts[1]);
                            userService.deleteUser(id);
                        }
                    }

                    case "exit" -> {
                        System.out.println("Выход из программы...");
                        return;
                    }

                    default -> System.out.println("Неизвестная команда.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: ID должен быть числом.");
            } catch (Exception e) {
                System.out.println("Произошла ошибка: " + e.getMessage());
            }
        }
    }

    public static void printMenu() {
        System.out.println("Доступные команды:");
        System.out.println(" - help");
        System.out.println(" - add [name] [email]");
        System.out.println(" - list");
        System.out.println(" - update [id] [new_name] [new_email]");
        System.out.println(" - delete [id]");
        System.out.println(" - exit");
    }
}