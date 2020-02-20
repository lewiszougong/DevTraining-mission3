package com.DevTraining.Mission3Improved.Service;

//import com.DevTraining.Mission3Improved.Repository.Repo;
import com.DevTraining.Mission3Improved.Model.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;


import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

@Service
public class PostService {

    private  JdbcTemplate jdbcTemplate;

    public PostService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String savePet(PostPetRequest postPetRequest)  {
        String petName = postPetRequest.getPet();
        String petType = postPetRequest.getType();
        String petGender = postPetRequest.getGender();
        Integer petAge = postPetRequest.getAge();

        //jdbcTemplate=repo.connectDataSource();
        jdbcTemplate.update("INSERT INTO tbl_pet(pet,type,gender, age, isFavourite) values(?,?,?,?,?)",petName, petType, petGender, petAge, "Null");
        return "Created and saved";
    }
    public class PetRowMapper implements RowMapper<Pet>{
        @Override
        public Pet mapRow(ResultSet resultSet, int i) throws SQLException {
            Pet pet=new Pet();
            pet.setId(resultSet.getInt("id"));
            pet.setPet(resultSet.getString("pet"));
            pet.setType(resultSet.getString("type"));
            pet.setGender(resultSet.getString("gender"));
            pet.setAge(resultSet.getInt("age"));
            pet.setIsFavourite(resultSet.getString("isFavourite"));
            return pet;
        }
    }
    public Pet getPet(int ID) {
        //jdbcTemplate = repo.connectDataSource();
        return jdbcTemplate.queryForObject("SELECT * FROM tbl_pet WHERE id=?", new Object[]{ID}, new PetRowMapper());
    }


////    public String updatePet(int id, PutPetRequest putPetRequest){
////        strings.set(id, new PetEntity(putPetRequest.getPet(), putPetRequest.getType(), putPetRequest.getGender(), putPetRequest.getAge(), putPetRequest.getIsFavourite()));
////        return "Updated";
////    }
////
//
    public String updatePet(int ID, PutPetRequest putPetRequest) throws SQLException{

        //jdbcTemplate = repo.connectDataSource();
        String sql = "UPDATE tbl_pet SET pet =?, type =?, gender=?, age=?, isFavourite=? WHERE id =?";
        jdbcTemplate.update(sql,putPetRequest.getPet(), putPetRequest.getType(), putPetRequest.getGender(), putPetRequest.getAge(), putPetRequest.getIsFavourite(),ID);

        return"Updated";
   }
    public String deletePet(int ID) throws SQLException{
        //jdbcTemplate = repo.connectDataSource();
        String sql = "DELETE FROM tbl_pet WHERE id=?";
        jdbcTemplate.update(sql, ID);

        return "Deleted";
    }

}
