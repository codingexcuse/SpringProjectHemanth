package com.hemanth.SpringBootMapping.repository;

import com.hemanth.SpringBootMapping.model.Student;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer>
{

}
