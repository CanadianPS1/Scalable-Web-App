package com.example.Controllers;
import java.sql.*;
import java.util.ArrayList;
import com.example.Models.*; 
public class SlothRestDataSQL{
    @SuppressWarnings("CallToPrintStackTrace")
    public static String add(Sloth sloth){
        if(findById(sloth.getSlothID()) != null) return "Id Conflict";
        String SQL = String.format(
                "INSERT INTO sloths (`slothID`, `name`, `slothLevel`, `speed`) VALUES ('%s', '%s', '%s', '%s');",
                sloth.getSlothID(), sloth.getName(), sloth.getSlothLevel(), sloth.getSlothSpeed(), sloth.getSlothID());
        try{
            Connection conn = DriverManager.getConnection(Settings.dbURL, Settings.username, Settings.password);
            PreparedStatement preparedStatement = conn.prepareStatement(SQL);
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows);
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Sloth Added! " + String.valueOf(sloth.getSlothID());
    }
    @SuppressWarnings("CallToPrintStackTrace")
    public static Sloth findById(int id){
        String SQL = String.format("SELECT * FROM sloths WHERE (`slothID` = '%s');", id);
        Sloth sloth = null;
        try(Connection conn = DriverManager.getConnection(
                Settings.dbURL, Settings.username, Settings.password);
                PreparedStatement preparedStatement = conn.prepareStatement(SQL)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int slothID = resultSet.getInt("slothID");
                String name = resultSet.getString("name");
                int slothLevel = resultSet.getInt("slothLevel");
                int speed = resultSet.getInt("speed");
                sloth = new Sloth(slothID, name, slothLevel, speed);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return sloth;
    }
    @SuppressWarnings("CallToPrintStackTrace")
    public static ArrayList<Sloth> getAll(){
        String SQL = String.format("SELECT * FROM sloths");
        ArrayList<Sloth> sloths = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(Settings.dbURL, Settings.username, Settings.password);
                PreparedStatement preparedStatement = conn.prepareStatement(SQL)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int slothID = resultSet.getInt("slothID");
                String name = resultSet.getString("name");
                int slothLevel = resultSet.getInt("slothLevel");
                int speed = resultSet.getInt("speed");
                Sloth sloth = new Sloth(slothID, name, slothLevel, speed);
                sloths.add(sloth);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return sloths;
    }
    @SuppressWarnings("CallToPrintStackTrace")
    public static Sloth update(Sloth sloth){
        String SQL = String.format(
                "UPDATE sloths SET `name` = '%s', `slothLevel` = '%s', `speed` = '%s' WHERE (`slothID` = '%s');",
                sloth.getName(), sloth.getSlothLevel(),sloth.getSlothSpeed(), sloth.getSlothID());
        try{
            Connection conn = DriverManager.getConnection(
                    Settings.dbURL, Settings.username, Settings.password);
            PreparedStatement preparedStatement = conn.prepareStatement(SQL);
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows);
            if(affectedRows == 1) return sloth;
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @SuppressWarnings("CallToPrintStackTrace")
    public static String delete(int id){
        String SQL = String.format("DELETE FROM sloths WHERE (`slothID` = '%s');", id);
        try(Connection conn = DriverManager.getConnection(Settings.dbURL, Settings.username, Settings.password);
            PreparedStatement preparedStatement = conn.prepareStatement(SQL)){
                preparedStatement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "Id " + id + " Deleted";
    }
}