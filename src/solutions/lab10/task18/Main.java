package solutions.lab10.task18;

class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public U getSecond() {
        return second;
    }

    public void setSecond(U second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "Pair{first=" + first + ", second=" + second + "}";
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Тест 1: String и Integer ---");
        Pair<String, Integer> pair = new Pair<>("Age", 30);
        
        System.out.println("Ключ: " + pair.getFirst());   // Age
        System.out.println("Значение: " + pair.getSecond()); // 30
        
        pair.setSecond(35);
        System.out.println("Новое значение: " + pair.getSecond()); // 35

        System.out.println();

        System.out.println("--- Тест 2: Координаты (Double, Double) ---");
        Pair<Double, Double> coordinates = new Pair<>(55.75, 37.61);
        System.out.println("Координаты: " + coordinates);
        
        System.out.println("--- Тест 3: Словарь (String, String) ---");
        Pair<String, String> translation = new Pair<>("Hello", "Привет");
        System.out.println(translation.getFirst() + " -> " + translation.getSecond());
    }
}