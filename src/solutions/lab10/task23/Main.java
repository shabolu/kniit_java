package solutions.lab10.task23;

public class Main {
    public static <T> void printType(T obj) {
        if (obj == null) {
            System.out.println("Object is null");
            return;
        }

        System.out.println(obj.getClass().getName());
    }

    public static void main(String[] args) {
        System.out.print("123 -> ");
        printType(123); 

        System.out.print("\"Hello\" -> ");
        printType("Hello"); 

        System.out.print("45.5 -> ");
        printType(45.5);

        System.out.print("Поток (Thread) -> ");
        printType(new Thread());
    }
}