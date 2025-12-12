package solutions.lab11.task25;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class FileDAO {
    public void saveFile(File file) throws SQLException, IOException {
        String sql = "INSERT INTO files (file_name, file_binary) VALUES (?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, file.getName());

            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] fileBytes = new byte[(int) file.length()];
                fis.read(fileBytes);
                statement.setBytes(2, fileBytes);
            }

            statement.executeUpdate();
        }
    }

    public Map<Integer, String> getAllFilesList() throws SQLException {
        Map<Integer, String> files = new HashMap<>();
        String sql = "SELECT id, file_name FROM files ORDER BY id";

        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                files.put(rs.getInt("id"), rs.getString("file_name"));
            }
        }
        return files;
    }

    public SavedFile getFileById(int id) throws SQLException {
        String sql = "SELECT file_name, file_binary FROM files WHERE id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setInt(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("file_name");
                    byte[] content = rs.getBytes("file_binary");
                    return new SavedFile(name, content);
                }
            }
        }
        return null;
    }

    public static class SavedFile {
        public String name;
        public byte[] content;

        public SavedFile(String name, byte[] content) {
            this.name = name;
            this.content = content;
        }
    }
}