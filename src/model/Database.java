package model;

import java.sql.*;

public class Database {
    Connection conn;
    Statement statement;
    ResultSet resultSet;

    public Database(String dbName, Strig user, String password){
        try{
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
            }
            catch(ClassNotFoundException e){

            }
             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306//"+dbName, user, password);
             statement = conn.createStatement();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    Object[][] executeQuery(String query){
        try
        {
            Object[][] obj;
            resultSet = statement.executeQuery(query);

            ResultSetMetaData metaData = resultSet.getMetaData();
            
            System.out.println("Number of columns: " + metaData.getColumnCount());
            
            for(int i = 0; i < metaData.getColumnCount(); i++){
                System.out.println("Col at " + 0 + " = " + metaData.getColumnName(i));
            }

            // while(resultSet.next()){

            // }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }

        return null;
    }


}
