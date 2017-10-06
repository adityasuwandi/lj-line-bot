package com.example.demo.Dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.*;

public class DbConnection {

    private static Connection connection;

    public static Connection getConnection() throws URISyntaxException {
        URI dbUri = null;
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://ec2-107-22-235-167.compute-1.amazonaws.com:5432/d7nbmgm92matum",
                    "zmygtmuyqsoyzj" , "268f98d0a2e5a5f3f9b57d5f99d14a116e6bcad0eec08078faeb2c821c8e143d"
            );
        } catch (Exception ex){
            System.out.println("Error start connection DB : " + ex.toString());
        }
        return connection;
    }
    public static void CloseConnection(Connection connection){
        if(connection==null){
            return;
        } else{
            try {
                connection.close();
                System.out.println("Connection closed successfully!");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Failed closing connection : " + e.toString());
            }
        }
    }
    public static void ClosePreparedStatement(PreparedStatement preparedStatement){
        if(preparedStatement==null){
            return;
        } else{
            try {
                preparedStatement.close();
                System.out.println("Prepared Statement closed successfully!");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Failed closing prepared statement : " + e.toString());
            }
        }
    }
    public static void CloseResultSet(ResultSet resultSet){
        if(resultSet==null){
            return;
        } else{
            try {
                resultSet.close();
                System.out.println("Result Set closed successfully!");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Failed closing result set : " + e.toString());
            }
        }
    }
}
