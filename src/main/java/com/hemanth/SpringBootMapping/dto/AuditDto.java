package com.hemanth.SpringBootMapping.dto;

import com.hemanth.SpringBootMapping.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditDto
{
    private Student student;
}
