package com.example.Controllers;

public class Settings {
    public static enum DBStatus {
        ARRAYLIST,
        JSON,
        SQL,
        JPA;
    }

    public static DBStatus dbStatus = DBStatus.JSON;
    public static String dbURL = "jdbc:mysql://localhost:3306/fantasy_world?createDatabaseIfNotExist=TRUE&allowPublicKeyRetrieval=TRUE&useSSL=FALSE";
    public static String username = "root";
    public static String password = "abc123";

}
