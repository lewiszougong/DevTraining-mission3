//package com.DevTraining.Mission3Improved.Repository;//package com.DevTraining.Mission3.Repository;
//
//
//import com.DevTraining.Mission3Improved.Model.Pet;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.jdbc.core.JdbcTemplate;
//
//import org.springframework.stereotype.Repository;
//
//import javax.sql.DataSource;
//import java.sql.*;
//
//
//@Repository
//public class Repo{
//        private JdbcTemplate jdbcTemplate;
//        public Repo(JdbcTemplate jdbcTemplate) {
//            this.jdbcTemplate = jdbcTemplate;
//        }
//
////public class Repo {
////    private DataSource dataSource;
////
////    public JdbcTemplate connectDataSource(){
////        dataSource=getDataSource();
////
////        JdbcTemplate jdbcTemplate=new JdbcTemplate();
////        jdbcTemplate.setDataSource(dataSource);
////
////        return jdbcTemplate;
////    }
////
////    public DriverManagerDataSource getDataSource(){
////        DriverManagerDataSource dataSource = new DriverManagerDataSource();
////
////        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
////
////        dataSource.setUrl("jdbc:mysql://localhost:3306/pet");
////
////        dataSource.setUsername("root");
////
////        dataSource.setPassword("a1s2d3f4");
////
////        return dataSource;
////    }
//}
