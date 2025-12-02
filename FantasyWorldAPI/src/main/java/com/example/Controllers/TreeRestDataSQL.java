package com.example.Controllers;
import java.sql.*;
import java.util.ArrayList;
import com.example.Models.*; 
public class TreeRestDataSQL{
    @SuppressWarnings("CallToPrintStackTrace")
    public static String add(Tree tree){
        if(findById(tree.getTreeID()) != null) return "Id Conflict";
        String SQL = String.format(
                "INSERT INTO trees (`treeID`, `age`, `treeType`, `slothID`) VALUES ('%s', '%s', '%s', '%s');",
                tree.getTreeID(), tree.getAge(), tree.getTreeType(), tree.getSlothID(), tree.getTreeID());
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
        return "Tree Added! " + String.valueOf(tree.getTreeID());
    }
    @SuppressWarnings("CallToPrintStackTrace")
    public static Tree findById(int id){
        String SQL = String.format("SELECT * FROM trees WHERE (`treeID` = '%s');", id);
        Tree tree = null;
        try(Connection conn = DriverManager.getConnection(
                Settings.dbURL, Settings.username, Settings.password);
                PreparedStatement preparedStatement = conn.prepareStatement(SQL)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int treeID = resultSet.getInt("treeID");
                String treeType = resultSet.getString("treeType");
                int age = resultSet.getInt("age");
                int slothID = resultSet.getInt("slothId");
                tree = new Tree(age, treeID, treeType, slothID);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return tree;
    }
    @SuppressWarnings("CallToPrintStackTrace")
    public static ArrayList<Tree> getAll(){
        String SQL = String.format("SELECT * FROM trees");
        ArrayList<Tree> trees = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(Settings.dbURL, Settings.username, Settings.password);
                PreparedStatement preparedStatement = conn.prepareStatement(SQL)){
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int treeID = resultSet.getInt("treeID");
                String treeType = resultSet.getString("treeType");
                int age = resultSet.getInt("age");
                int slothID = resultSet.getInt("slothId");
                Tree tree = new Tree(age, treeID, treeType, slothID);
                trees.add(tree);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return trees;
    }
    @SuppressWarnings("CallToPrintStackTrace")
    public static Tree update(Tree tree){
        String SQL = String.format(
                "UPDATE trees SET `treeID` = '%s', `treeType` = '%s', `age` = '%s', `slothID` = '%s' WHERE (`treeID` = '%s');",
                tree.getTreeID(), tree.getTreeType(),tree.getAge(), tree.getSlothID(), tree.getTreeID());
        try{
            Connection conn = DriverManager.getConnection(
                    Settings.dbURL, Settings.username, Settings.password);
            PreparedStatement preparedStatement = conn.prepareStatement(SQL);
            int affectedRows = preparedStatement.executeUpdate();
            System.out.println(affectedRows);
            if(affectedRows == 1) return tree;
        }catch(SQLException e){
            e.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    @SuppressWarnings("CallToPrintStackTrace")
    public static String delete(int id){
        String SQL = String.format("DELETE FROM trees WHERE (`treeID` = '%s');", id);
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