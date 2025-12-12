package solutions.lab8;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User implements Serializable {
    private String name;
    private int age;
    private String email;

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", Возраст: " + age + ", Email: " + email;
    }
}

class UserManager {
    private static final String FILE_NAME = "users.ser";

    public static void saveUsers(List<User> users) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(users);
            System.out.println("Список успешно сохранён в файл.");
        } catch (IOException e) {
            System.err.println("Ошибка при сохранении файла: " + e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    public static List<User> loadUsers() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            List<User> users = (List<User>) ois.readObject();
            System.out.println("Список успешно загружен из файла.");
            return users;
        } catch (FileNotFoundException e) {
            System.out.println("Файл сохранения не найден. Создан новый список.");
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Ошибка при загрузке файла: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}

public class Main {
    private static List<User> users = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int action = getValidIntInput();

            switch (action) {
                case 1 -> addUser();
                case 2 -> showUsers();
                case 3 -> UserManager.saveUsers(users);
                case 4 -> users = UserManager.loadUsers();
                case 5 -> {
                    UserManager.saveUsers(users);
                    System.out.println("Программа завершена. До свидания!");
                    return;
                }
                default -> System.out.println("Неверный выбор. Попробуйте снова.");
            }
            System.out.println();
        }
    }

    private static void printMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1. Добавить нового пользователя");
        System.out.println("2. Показать всех пользователей");
        System.out.println("3. Сохранить список пользователей в файл");
        System.out.println("4. Загрузить список пользователей из файла");
        System.out.println("5. Выйти");
        System.out.print("Введите номер действия: ");
    }

    private static void addUser() {
        System.out.print("Введите имя пользователя: ");
        String name = scanner.nextLine();

        System.out.print("Введите возраст: ");
        int age = getValidIntInput();

        System.out.print("Введите email: ");
        String email = scanner.nextLine();

        User newUser = new User(name, age, email);
        users.add(newUser);
        System.out.println("Пользователь добавлен.");
    }

    private static void showUsers() {
        if (users.isEmpty()) {
            System.out.println("Список пользователей пуст.");
        } else {
            System.out.println("Список пользователей:");
            for (int i = 0; i < users.size(); i++) {
                System.out.println((i + 1) + ". " + users.get(i));
            }
        }
    }

    private static int getValidIntInput() {
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Ошибка! Введите целое число: ");
            }
        }
    }
}