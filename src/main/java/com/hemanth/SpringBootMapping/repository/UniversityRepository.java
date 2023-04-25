package com.hemanth.SpringBootMapping.repository;

import com.hemanth.SpringBootMapping.model.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository<University,Integer>
{
}
