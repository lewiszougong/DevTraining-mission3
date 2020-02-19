package com.DevTraining.Mission3Improved.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class GetPetResponse {
    private String pet;
    private String type;
    private String gender;
    private Integer age;
    private Boolean isFavourite;

}

