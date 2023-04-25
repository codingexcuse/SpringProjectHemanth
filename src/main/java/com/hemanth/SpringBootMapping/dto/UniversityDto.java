package com.hemanth.SpringBootMapping.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hemanth.SpringBootMapping.model.Student;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UniversityDto
{

    int uid;

    @NotNull(message = "Not Empty")
    String name;


    @NotBlank
    @Size(min=2,message = "Minimum characters should be minimum 2")
    String address;



    List<Student> stud=new ArrayList<>();

}
