package csc180.roeback.lia.DearDiaryAPI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class DiaryRestDataSQL {
    private static final String DB_URL =  "jdbc:mysql://localhost:3306/deardiaryMySQL?createDatabaseIfNotExist=TRUE&allowPublicKeyRetrieval=TRUE&useSSL=FALSE";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "abc123";
    @SuppressWarnings("CallToPrintStackTrace")
    public static String add(DiaryEntry entry){
        
        String SQL = String.format(
                "INSERT INTO diaryentries ( `id`, `text`, `createdate`) VALUES ('%s', '%s', '%s');",
                entry.getId(), entry.getText(), entry.getCreateDate());
        try {
            Connection conn = DriverManager.getConnection(
                    DB_URL, USERNAME, PASSWORD);
            PreparedStatement preparedStatement = conn.prepareStatement(SQL);
 
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return "Entry Added! " + String.valueOf(entry.getId());
    }
    @SuppressWarnings("CallToPrintStackTrace")
    public static ArrayList<DiaryEntry> getAll() {
        String SQL = String.format("SELECT * FROM diaryentries");
        ArrayList<DiaryEntry> entries = new ArrayList<>();
 
        try (Connection conn = DriverManager.getConnection(
                DB_URL, USERNAME, PASSWORD);
                PreparedStatement preparedStatement = conn.prepareStatement(SQL)) {
 
            ResultSet resultSet = preparedStatement.executeQuery();
 
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String text = resultSet.getString("text");
                String createDate = resultSet.getString("createDate");
 
                DiaryEntry de = new DiaryEntry(text, id,createDate);
                entries.add(de);
            }
 
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return entries;
    }
    @SuppressWarnings("CallToPrintStackTrace")
    public static DiaryEntry findById(int id) {
        String SQL = String.format("SELECT * FROM diaryentries WHERE (`id` = '%s');", id);
        DiaryEntry entry = null;        
 
        try (Connection conn = DriverManager.getConnection(
                DB_URL, USERNAME, PASSWORD);
                PreparedStatement preparedStatement = conn.prepareStatement(SQL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
 
            while (resultSet.next()) {
                int id2 = resultSet.getInt("id");
                String text = resultSet.getString("text");
                String createDate = resultSet.getString("createDate");
 
                entry = new DiaryEntry(text, id2, createDate);
                System.out.println("Found the entry" + entry.getText());
            }
 
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return entry;
    }
}
