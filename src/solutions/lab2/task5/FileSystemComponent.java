package solutions.lab2.task5;

public interface FileSystemComponent {
    String getName();
    int getSize();
    void add(FileSystemComponent component);
    void remove(FileSystemComponent component);
    void display(String indent);
}
