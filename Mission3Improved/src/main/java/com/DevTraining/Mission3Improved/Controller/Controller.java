package com.DevTraining.Mission3Improved.Controller;


import com.DevTraining.Mission3Improved.Model.*;
import com.DevTraining.Mission3Improved.Service.PostService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/home")
public class Controller {

    PostService postService;

    public Controller(PostService postService){
        this.postService=postService;
    }
    @PostMapping
    public String createResponse(@RequestBody PostPetRequest postPetRequest) throws SQLException{

        return postService.savePet(postPetRequest);
    }

    @GetMapping("/{id}")
    public GetPetResponse getValue(@PathVariable(value="id") int id) throws SQLException {

        return postService.getPet(id);
    }
    @PutMapping("/{id}")
    public String updateResponse(@PathVariable(value="id") int id, @RequestBody PutPetRequest putPetRequest) throws SQLException{

        return postService.updatePet(id,putPetRequest);
    }
    @DeleteMapping("/{id}")
    public String deleteResponse(@PathVariable(value= "id") int id) throws SQLException{
        return postService.deletePet(id);
    }



}


