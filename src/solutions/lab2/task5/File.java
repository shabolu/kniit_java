package solutions.lab2.task5;

public class File implements FileSystemComponent {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }
    
    @Override
    public void add(FileSystemComponent component) {
        throw new UnsupportedOperationException("Невозможно добавить элемент в файл.");
    }

    @Override
    public void remove(FileSystemComponent component) {
        throw new UnsupportedOperationException("Невозможно удалить элемент из файла.");
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + getName() + " (" + getSize() + " bytes)");
    }
}
