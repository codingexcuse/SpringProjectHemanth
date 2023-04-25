package com.hemanth.SpringBootMapping.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;


    @Data
    @NoArgsConstructor
    @Entity
    @AllArgsConstructor

    @Table(name="Student")
    @EntityListeners(AuditingEntityListener.class)  //this for the Auditing Details
    public class Student
    {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        int id;


        String name;


        String branch;


        String email;

        @JsonBackReference
        @ManyToOne
        @JoinColumn(name="university_id",referencedColumnName = "uid")
        University university;



        @Temporal(TemporalType.TIMESTAMP)
        @CreatedDate
        private Date createdDate;

        @LastModifiedDate
        @Temporal(TemporalType.TIMESTAMP)
        private Date lastModifiedDate;

        @CreatedBy
        private String createdBy;

        @LastModifiedBy
        private String modifiedBy;




    }

