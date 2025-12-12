package solutions.lab11.task25;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

public class FileProcessor {
    private final FileDAO fileDAO = new FileDAO();
    private static final long MAX_SIZE = 10 * 1024 * 1024;

    public void processPath(String path) {
        File root = new File(path);

        if (!root.exists()) {
            System.out.println("Ошибка: Путь не существует.");
            return;
        }

        if (root.isFile()) {
            processSingleFile(root);
        } else if (root.isDirectory()) {
            processDirectory(root);
        }
    }

    private void processDirectory(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    processDirectory(file);
                } else {
                    processSingleFile(file);
                }
            }
        }
    }

    private void processSingleFile(File file) {
        if (file.length() > MAX_SIZE) {
            System.out.println("Пропуск (слишком большой): " + file.getName());
            return;
        }

        try {
            System.out.print("Загрузка: " + file.getName() + "... ");
            fileDAO.saveFile(file);
            System.out.println("ОК.");
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public void listFiles() {
        try {
            Map<Integer, String> files = fileDAO.getAllFilesList();
            if (files.isEmpty()) {
                System.out.println("База данных пуста.");
            } else {
                System.out.println("--- Файлы в БД ---");
                for (Map.Entry<Integer, String> entry : files.entrySet()) {
                    System.out.println("ID: " + entry.getKey() + " | Имя: " + entry.getValue());
                }
            }
        } catch (SQLException e) {
            System.err.println("Ошибка БД: " + e.getMessage());
        }
    }

    public void saveLocal(int id) {
        try {
            FileDAO.SavedFile savedFile = fileDAO.getFileById(id);
            if (savedFile == null) {
                System.out.println("Файл с ID " + id + " не найден.");
                return;
            }

            File outputFile = new File(savedFile.name);
            
            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                fos.write(savedFile.content);
            }

            System.out.println("Файл успешно сохранён на диск: " + outputFile.getAbsolutePath());

        } catch (IOException | SQLException e) {
            System.err.println("Ошибка при сохранении: " + e.getMessage());
        }
    }
}