package csc180.roeback.lia.DearDiaryAPI;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DiaryRestDataSQL {
    public static String add(DiaryEntry entry){
        String dbURL = "jdbc:mysql://localhost:3306/deardiaryMySQL?createDatabaseIfNotExist=TRUE&allowPublicKeyRetrieval=TRUE&useSSL=FALSE";
        String username = "root";
        String password = "abc123";
        String SQL = String.format(
                "INSERT INTO diarytable (id`, `text`, `create_date`) VALUES ('%s', '%s', '%s');",
                entry.getId(), entry.getText(), entry.getCreateDate());
        try {
            Connection conn = DriverManager.getConnection(
                    dbURL, username, password);
            PreparedStatement preparedStatement = conn.prepareStatement(SQL);
 
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return "Entry Added! " + String.valueOf(entry.getId());
        return "";
    }
}
