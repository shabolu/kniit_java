package solutions.first;

public class Main {
    public static void main(String[] args) {
        for (var i = 1; i <= 90; i += 10) {
            String line = Integer.toString(i);
            for (var j = i + 1; j < i + 10; j++) {
                line = line + ", " + Integer.toString(j);
            }
            System.out.println(line);
        }
    }
}