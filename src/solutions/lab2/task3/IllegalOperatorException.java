package solutions.lab2.task3;

public class IllegalOperatorException extends Exception { // Или extends RuntimeException
    public IllegalOperatorException(String message) {
        super(message);
    }
}
