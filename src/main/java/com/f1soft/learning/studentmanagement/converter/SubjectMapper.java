package com.f1soft.learning.studentmanagement.converter;

import com.f1soft.learning.studentmanagement.dto.SubjectDto;
import com.f1soft.learning.studentmanagement.entity.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SubjectMapper {


    public static Subject mapSubjectDtoToEntity(SubjectDto subjectDto)
    {
        Subject subject = new Subject();
        subject.setName(subjectDto.getName());
        subject.setStudent_id(subjectDto.getStudent_id());
        return subject;
    }

    public static List<SubjectDto> mapSubjectEntityToDto(List<Subject> subjectList)
    {
        return subjectList.stream()
                .map(subject -> {
                    SubjectDto subjectDto = new SubjectDto();
                    subjectDto.setName(subject.getName());
                   return subjectDto;
                })
                .collect(Collectors.toList());

    }
}
