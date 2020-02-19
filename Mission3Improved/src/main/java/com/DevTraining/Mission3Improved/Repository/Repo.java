package com.DevTraining.Mission3Improved.Repository;//package com.DevTraining.Mission3.Repository;


import org.springframework.stereotype.Repository;

import java.sql.*;


@Repository
public class Repo {


    public Statement connectDB() throws SQLException{

        Connection dbConnection = null;

        String urll = "jdbc:mysql://localhost:3306/pet";
        dbConnection = DriverManager.getConnection(urll, "root", "a1s2d3f4");
        Statement stat = dbConnection.createStatement();

        return stat;
    }
}
