package com.DevTraining.Mission3Improved.Service;

import com.DevTraining.Mission3Improved.Repository.Repo;
import com.DevTraining.Mission3Improved.Model.*;
import org.springframework.data.relational.core.sql.SQL;
import org.springframework.stereotype.Service;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

@Service
public class PostService {

   private Repo repo;
    Connection dbConnection = null;

    public PostService(Repo repo) {
        this.repo = repo;
    }


    public String savePet(PostPetRequest postPetRequest) throws SQLException {
        String petName = postPetRequest.getPet();
        String petType = postPetRequest.getType();
        String petGender = postPetRequest.getGender();
        Integer petAge = postPetRequest.getAge();

        Connection dbConnection = null;

        Statement stat=repo.connectDB();
        String sql = "SELECT * FROM tbl_pet";
        stat.executeQuery(sql);

        String saveInput = "INSERT INTO tbl_pet(pet, type, gender, age, isFavourite)"
                + "VALUES('"+petName+ "', '" +petType+ "', '" +petGender+ "', '" +petAge+ "', 'Null')";
        stat.executeUpdate(saveInput);
        return "Created and saved";

    }

//        String INSERT_SQL="INSERT INTO tbl_pet(name, address, email) values(:name, :address, :email)";
//        NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;
//        KeyHolder holder= new GeneratedKeyHolder();
//        SqlParameterSource parameter= new MapSqlParameterSource()
//                .addValue("pet",postPetRequest.getPet())
//                .addValue("type",postPetRequest.getType())
//                .addValue("gender", postPetRequest.getGender())
//                .addValue("age",postPetRequest.getAge());
//        namedParameterJdbcTemplate.update(INSERT_SQL,parameter, holder);


    public GetPetResponse getPet(int ID) throws SQLException{
        GetPetResponse pet= new GetPetResponse();
        Connection dbConnection = null;
        String pet_col;
        String type_col;
        String gender_col;
        Integer age_col;

        Statement stat =repo.connectDB();
        String sql = "SELECT * FROM tbl_pet WHERE id ="+ID;
        ResultSet rs = stat.executeQuery(sql);

        rs.next();
        int id_col=rs.getInt("id");
        pet_col=rs.getString("pet");
        type_col=rs.getString("type");
        gender_col=rs.getString("gender");
        age_col=rs.getInt("age");

        pet.setPet(pet_col);
        pet.setType(type_col);
        pet.setGender(gender_col);
        pet.setAge(age_col);
        return pet;
    }
//    public String updatePet(int id, PutPetRequest putPetRequest){
//        strings.set(id, new PetEntity(putPetRequest.getPet(), putPetRequest.getType(), putPetRequest.getGender(), putPetRequest.getAge(), putPetRequest.getIsFavourite()));
//        return "Updated";
//    }
//

    public String updatePet(int ID, PutPetRequest putPetRequest) throws SQLException{
        Statement stat =repo.connectDB();
        String sql = "UPDATE tbl_pet SET pet ='"+putPetRequest.getPet()+"', type ='"+putPetRequest.getType()+
                "', gender='"+putPetRequest.getGender()+"', age="+putPetRequest.getAge()+
                ", isFavourite='"+putPetRequest.getIsFavourite()+"' WHERE id = "+ID;
        stat.executeUpdate(sql);


        return"Updated";
    }
    public String deletePet(int ID) throws SQLException{
        Statement stat=repo.connectDB();
        String sql = "DELETE FROM tbl_pet WHERE id IN ("+ID+")" ;
        stat.executeUpdate(sql);
        return "Deleted";
    }

}
