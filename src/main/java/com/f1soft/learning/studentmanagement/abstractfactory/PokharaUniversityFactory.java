package com.f1soft.learning.studentmanagement.abstractfactory;

import com.f1soft.learning.studentmanagement.exception.StudentApiException;
import org.springframework.stereotype.Service;

@Service
public class PokharaUniversityFactory extends UniversityFactory{
    @Override
    public Course getCourses(String stream) {
        switch(stream)
        {
            case "COMPUTER_SCIENCE":
            {
                return new NcitComputerScienceCourse();
            }
            case "MANAGEMENT":
            {
                return new NcitManagementCourse();
            }

        }
        throw new StudentApiException(400,stream + " course is not available");

    }
}
