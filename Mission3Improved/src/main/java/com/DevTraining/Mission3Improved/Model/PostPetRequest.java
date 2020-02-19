package com.DevTraining.Mission3Improved.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PostPetRequest {
    String pet;
    String type;
    String gender;
    Integer age;
}
