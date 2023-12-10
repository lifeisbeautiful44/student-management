package com.f1soft.learning.studentmanagement.abstractfactory;

import com.f1soft.learning.studentmanagement.exception.StudentApiException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

@Service
public class TrihbuwanUniversityFactory extends UniversityFactory {
    @Override
    public Course getCourses(String stream) {

        switch(stream)
        {
            case "COMPUTER_SCIENCE":
            {
                return new PatanCampusCsCourse();
            }
            case "MANAGEMENT":
            {
                return new PatanCampusManagementCourse();
            }
        }
        throw new StudentApiException(400,stream + " course is not available");

    }


}
