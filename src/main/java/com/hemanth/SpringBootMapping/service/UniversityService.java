package com.hemanth.SpringBootMapping.service;

import com.hemanth.SpringBootMapping.MapperClass.UniversityMapper;
import com.hemanth.SpringBootMapping.controller.UniversityController;
import com.hemanth.SpringBootMapping.dto.UniversityDto;
import com.hemanth.SpringBootMapping.exception.UniversityIdNotFoundException;
import com.hemanth.SpringBootMapping.model.Student;
import com.hemanth.SpringBootMapping.model.University;
import com.hemanth.SpringBootMapping.repository.StudentRepository;
import com.hemanth.SpringBootMapping.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UniversityService
{


    @Autowired
    UniversityRepository ur;


    public UniversityDto addUniversity(UniversityDto university)
    {

       University result= UniversityMapper.dtoToUniversity(university);
       ur.save(result);
       return university;

    }

    public List<UniversityDto> getUniversity()
    {
        List<University> newUniversity=ur.findAll();
        List<UniversityDto> result=new ArrayList<>();

        for(University i:newUniversity)
        {
            UniversityDto ss=UniversityMapper.universityToDto(i);
            result.add(ss);
        }

        return result;


    }


    public String updateUniversity(UniversityDto ut)
    {
        University result=UniversityMapper.dtoToUniversity(ut);
        ur.save(result);
        return "Updated University Details Successfully";

    }

    public String deleteUniversity()
    {
         ur.deleteAll();
        return "All University Deleted Successfully";
    }


    public void deleteUniversityBy(int id)
    {
        if(id <0)
        {
            throw new UniversityIdNotFoundException("Id of University Entered is Invalid");
        }
        ur.deleteById(id);
        System.out.println("Deleted the students with the id"+id);

    }


}
