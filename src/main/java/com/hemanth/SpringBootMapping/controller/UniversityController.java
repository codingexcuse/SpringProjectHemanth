package com.hemanth.SpringBootMapping.controller;

import com.hemanth.SpringBootMapping.dto.UniversityDto;
import com.hemanth.SpringBootMapping.model.Student;
import com.hemanth.SpringBootMapping.model.University;
import com.hemanth.SpringBootMapping.service.StudentService;
import com.hemanth.SpringBootMapping.service.UniversityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/university")
@RestController
public class UniversityController
{



    @Autowired
    UniversityService us;

    @RequestMapping(method = RequestMethod.POST,value = "/users")
    public UniversityDto addingUniversity(@Valid @RequestBody UniversityDto university)
    {
        return us.addUniversity(university);

    }



    @RequestMapping(method = RequestMethod.GET,value = "/details")
    public List<UniversityDto> gettingUniversity()
    {
        return us.getUniversity();
    }


    @RequestMapping(method = RequestMethod.PUT,value = "/update")
    public String upUniversity(@RequestBody UniversityDto s)
    {
        return us.updateUniversity(s);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/delete")
    public String deleteUniversity()
    {
        return us.deleteUniversity();
    }


    @RequestMapping(method = RequestMethod.DELETE,value = "/delete/{username}")
    public void deleteUniversityById(@PathVariable("username") int id)
    {
        us.deleteUniversityBy(id);
    }






}
