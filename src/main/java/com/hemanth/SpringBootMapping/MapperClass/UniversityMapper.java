package com.hemanth.SpringBootMapping.MapperClass;

import com.hemanth.SpringBootMapping.dto.StudentDto;
import com.hemanth.SpringBootMapping.dto.UniversityDto;
import com.hemanth.SpringBootMapping.model.Student;
import com.hemanth.SpringBootMapping.model.University;
import org.springframework.stereotype.Component;

@Component
public class UniversityMapper
{

    public static University dtoToUniversity(UniversityDto universityDto)
    {
       University uni=new University();
       uni.setUid(universityDto.getUid());
       uni.setName(universityDto.getName());
       uni.setAddress(universityDto.getAddress());
       uni.setStud(universityDto.getStud());


       return uni;

    }

    public static UniversityDto universityToDto(University university)
    {
      UniversityDto universityDto=new UniversityDto();
      universityDto.setUid(university.getUid());
      universityDto.setName(university.getName());
      universityDto.setAddress(university.getAddress());
      universityDto.setStud(university.getStud());


      return universityDto;
    }
}
