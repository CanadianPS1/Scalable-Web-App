package com.example.Controllers;
import java.sql.*;
import java.util.ArrayList;
import com.example.Models.*; 
public class JungleRestDataSQL{
    @SuppressWarnings("CallToPrintStackTrace")
    public static String add(Jungle jungle){
        System.out.println(jungle);
        if(findById(jungle.getJungleID()) != null) return "Id Conflict";
        String SQL = String.format(
                "INSERT INTO jungles (`jungleID`, `jungleName`, `jungleSize`, `slothID`, `treeID`) VALUES ('%s', '%s', '%s', '%s', '%s');",
                jungle.getJungleID(), jungle.getJungleName(), jungle.getJungleSize(), jungle.getSlothID(), jungle.getTreeID(), jungle.getJungleID());
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
        return "Jungle Added! " + String.valueOf(jungle.getJungleID());
    }
    @SuppressWarnings({"CallToPrintStackTrace", "UnnecessaryTemporaryOnConversionFromString"})
    public static Jungle findById(int id){
        String SQL = String.format("SELECT * FROM jungles WHERE (`jungleID` = '%s');", id);
        Jungle jungle = null;
        try(Connection conn = DriverManager.getConnection(
                Settings.dbURL, Settings.username, Settings.password);
                PreparedStatement preparedStatement = conn.prepareStatement(SQL)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int jungleID = resultSet.getInt("jungleID");
                String jungleName = resultSet.getString("jungleName");
                int jungleSize = resultSet.getInt("jungleSize");
                int slothID = resultSet.getInt("slothID");
                int treeID = resultSet.getInt("treeID");
                //String slothIDsRaw = resultSet.getString("slothID");
                // ArrayList<Integer> slothID = new ArrayList<>();
                // if (slothIDsRaw != null && !slothIDsRaw.isEmpty()) {
                //     for (String s : slothIDsRaw.split(",")) {
                //         slothID.add(Integer.parseInt(s.trim()));
                //     }
                // }

                // String treeIDsRaw = resultSet.getString("treeID");
                // ArrayList<Integer> treeID = new ArrayList<>();
                // if (treeIDsRaw != null && !treeIDsRaw.isEmpty()) {
                //     for (String s : treeIDsRaw.split(",")) {
                //         treeID.add(Integer.parseInt(s.trim()));
                //     }
                // }
                jungle = new Jungle(jungleID, jungleName, jungleSize, slothID, treeID);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return jungle;
    }
    @SuppressWarnings({"CallToPrintStackTrace", "UnnecessaryTemporaryOnConversionFromString"})
    public static ArrayList<Jungle> getAll(){
        String SQL = String.format("SELECT * FROM jungles");
        ArrayList<Jungle> jungles = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(Settings.dbURL, Settings.username, Settings.password);
                PreparedStatement preparedStatement = conn.prepareStatement(SQL)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int jungleID = resultSet.getInt("jungleID");
                String jungleName = resultSet.getString("jungleName");
                int jungleSize = resultSet.getInt("jungleSize");
                int slothID = resultSet.getInt("slothID");
                int treeID = resultSet.getInt("treeID");
                //String slothIDsRaw = resultSet.getString("slothID");
                // ArrayList<Integer> slothID = new ArrayList<>();
                // if (slothIDsRaw != null && !slothIDsRaw.isEmpty()) {
                //     for (String s : slothIDsRaw.split(",")) {
                //         slothID.add(Integer.parseInt(s.trim()));
                //     }
                // }

                // String treeIDsRaw = resultSet.getString("treeID");
                // ArrayList<Integer> treeID = new ArrayList<>();
                // if (treeIDsRaw != null && !treeIDsRaw.isEmpty()) {
                //     for (String s : treeIDsRaw.split(",")) {
                //         treeID.add(Integer.parseInt(s.trim()));
                //     }
                // }
                Jungle jungle = new Jungle(jungleID, jungleName, jungleSize, slothID, treeID);
                jungles.add(jungle);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return jungles;
    }
    @SuppressWarnings("CallToPrintStackTrace")
    public static Jungle update(Jungle jungle){
        String SQL = String.format(
                "UPDATE jungles SET `jungleID` = '%s', `jungleName` = '%s', `jungleSize` = '%s', `slothID` = '%s', `treeID` = '%s' WHERE (`jungleID` = '%s');",
                jungle.getJungleID(), jungle.getJungleName(),jungle.getJungleSize(), jungle.getSlothID(), jungle.getTreeID(), jungle.getJungleID());
        try{
            Connection conn = DriverManager.getConnection(
                    Settings.dbURL, Settings.username, Settings.password);
            PreparedStatement preparedStatement = conn.prepareStatement(SQL);
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows);
            if(affectedRows == 1) return jungle;
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @SuppressWarnings("CallToPrintStackTrace")
    public static String delete(int id){
        String SQL = String.format("DELETE FROM jungles WHERE (`jungleID` = '%s');", id);
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