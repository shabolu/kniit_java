package solutions.lab9.task14;

import java.util.Scanner;

enum TrafficLight {
    RED, YELLOW, GREEN;

    public TrafficLight getNextLight() {
        switch (this) {
            case RED -> {
                return GREEN;
            }
            case GREEN -> {
                return YELLOW;
            }
            case YELLOW -> {
                return RED;
            }
            default -> throw new IllegalStateException("Неизвестный статус: " + this);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите текущий сигнал светофора (RED, YELLOW, GREEN): ");
        String input = scanner.nextLine().trim().toUpperCase();

        try {
            TrafficLight currentLight = TrafficLight.valueOf(input);

            TrafficLight nextLight = currentLight.getNextLight();

            System.out.println("Следующий сигнал: " + nextLight);

        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: Такого сигнала светофора не существует. Введите RED, YELLOW или GREEN.");
        }
    }
}