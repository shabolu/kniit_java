package solutions.lab2.task5;

public class Main {
    public static void main(String[] args) {
        FileSystemComponent file1 = new File("file1.txt", 100);
        FileSystemComponent file2 = new File("file2.txt", 200);
        FileSystemComponent file3 = new File("file3.txt", 300);

        FileSystemComponent folder1 = new Folder("Folder1");
        FileSystemComponent folder2 = new Folder("Folder2");

        folder1.add(file1);
        folder1.add(file2);

        folder2.add(file3);
        folder2.add(folder1);

        folder2.display("");

        System.out.println("Суммарный объем папки Folder2: " + folder2.getSize() + " bytes");
    }
}

