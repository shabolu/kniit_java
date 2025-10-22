package solutions.lab2.task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) { 
            System.out.print("Введите первое число: ");
            String input1 = scanner.nextLine();

            if ("exit".equals(input1)) {
                System.out.println("Выход из программы");
                break;
            }

            double num1;
            try {
                num1 = Double.parseDouble(input1);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: некорректный ввод числа");
                continue;
            }

            System.out.print("Введите оператор (+, -, *, /): ");
            String operator = scanner.nextLine();

            System.out.print("Введите второе число: ");
            String input2 = scanner.nextLine();

            double num2;
            try {
                num2 = Double.parseDouble(input2);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: некорректный ввод числа");
                continue;
            }

            double result = 0;
            try {
                switch (operator) {
                    case "+" -> result = Calculator.add(num1, num2);
                    case "-" -> result = Calculator.subtract(num1, num2);
                    case "/" -> result = Calculator.divide(num1, num2);
                    case "*" -> result = Calculator.multiply(num1, num2);
                    default -> throw new IllegalOperatorException("Недопустимый оператор: " + operator);
                }
                System.out.println("Результат: " + result);

            } catch (IllegalOperatorException | IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }
}
