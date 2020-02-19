package com.DevTraining.Mission3Improved;

import java.sql.*;
public class testSQL {
    public static void main(String[] args) {
        Connection dbConnection = null;

        try {
            String url = "jdbc:mysql://localhost:3306/pet";
            dbConnection = DriverManager.getConnection(url, "root","a1s2d3f4");
            Statement stat = dbConnection.createStatement();
            String sql = "SELECT * FROM tbl_pet";
            ResultSet rs = stat.executeQuery(sql);


            String saveInput= "INSERT INTO tbl_pet(id, pet, type, gender, age, isFavourite)"
                    + "VALUES(7,'Crocodile','Animal', 'Male', 5 ,'True')";
            stat.executeUpdate(saveInput);

            System.out.println("Successful");
        } catch (SQLException ex) {
            System.out.println("An error occurred while connecting MySQL databse");
            ex.printStackTrace();
        }
    }

}
