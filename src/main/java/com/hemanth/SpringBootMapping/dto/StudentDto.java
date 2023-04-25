package com.hemanth.SpringBootMapping.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hemanth.SpringBootMapping.model.University;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto
{
    int usn;

    @NotBlank
    @Size(min=2,message = "Name must have atLeast 2 characters")
    String name;

    @NotNull(message = "Branch cannot be Null")
    String branch;

    @Email(message = "Please Enter Valid Email Format. ")
    String email;

    @JsonBackReference
    University university;

    private Date createdDate;

    private Date lastModifiedDate;

    private String createdBy;


    private String modifiedBy;

}
