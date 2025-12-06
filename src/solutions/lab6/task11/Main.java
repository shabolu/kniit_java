package solutions.lab6.task11;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        TreeSet<String> students = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addStudent(students, scanner);
                    break;
                case "2":
                    removeStudent(students, scanner);
                    break;
                case "3":
                    showAllStudents(students);
                    break;
                case "4":
                    findStudent(students, scanner);
                    break;
                case "5":
                    System.out.println("Выход из программы...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверная команда. Попробуйте снова.");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("Меню:");
        System.out.println("1. Добавить студента");
        System.out.println("2. Удалить студента");
        System.out.println("3. Показать всех студентов");
        System.out.println("4. Найти студента");
        System.out.println("5. Выйти");
        System.out.print("Выберите опцию: ");
    }

    private static void addStudent(TreeSet<String> students, Scanner scanner) {
        System.out.print("\nВведите имя студента: ");
        String name = scanner.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("\nИмя не может быть пустым.");
            return;
        }

        if (students.add(name)) {
            System.out.println("\nСтудент успешно добавлен.");
        } else {
            System.out.println("\nОшибка: Такой студент уже есть в списке.");
        }
    }

    private static void removeStudent(TreeSet<String> students, Scanner scanner) {
        System.out.print("Введите имя студента для удаления: ");
        String name = scanner.nextLine().trim();

        if (students.remove(name)) {
            System.out.println("\nСтудент удален.");
        } else {
            System.out.println("\nОшибка: Студент не найден.");
        }
    }

    private static void showAllStudents(TreeSet<String> students) {
        if (students.isEmpty()) {
            System.out.println("\nСписок студентов пуст.");
        } else {
            System.out.println("\n--- Список студентов ---");

            students.forEach(System.out::println);
        }
    }

    private static void findStudent(TreeSet<String> students, Scanner scanner) {
        System.out.print("Введите имя студента для поиска: ");
        String name = scanner.nextLine().trim();

        if (students.contains(name)) {
            System.out.println("\nСтудент найден!");
        } else {
            System.out.println("\nСтудент не найден.");
        }
    }
}