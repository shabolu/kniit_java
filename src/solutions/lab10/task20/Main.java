package solutions.lab10.task20;

import java.util.ArrayList;
import java.util.List;

class Box<T extends Number> {
    private List<T> numbers = new ArrayList<>();

    public void add(T number) {
        numbers.add(number);
    }

    public double sum() {
        double total = 0.0;
        
        for (T number : numbers) {
            total += number.doubleValue();
        }
        
        return total;
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Box<Integer> ---");
        Box<Integer> integerBox = new Box<>();
        integerBox.add(10);
        integerBox.add(20);
        
        System.out.println("Сумма: " + integerBox.sum()); 

        System.out.println("\n--- Box<Double> ---");
        Box<Double> doubleBox = new Box<>();
        doubleBox.add(1.5);
        doubleBox.add(2.5);
        
        System.out.println("Сумма: " + doubleBox.sum()); 
    }
}