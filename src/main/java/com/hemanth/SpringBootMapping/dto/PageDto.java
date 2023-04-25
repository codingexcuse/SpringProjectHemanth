package com.hemanth.SpringBootMapping.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PageDto
{
    List<StudentDto> content;
    int pageNo;

    int pageSize;

    int total_Element;

    int total_Page;

    boolean isLast;

}
