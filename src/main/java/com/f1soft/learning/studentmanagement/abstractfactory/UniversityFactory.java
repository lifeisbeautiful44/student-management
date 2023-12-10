package com.f1soft.learning.studentmanagement.abstractfactory;

public abstract  class UniversityFactory {

    public static int scores = 80;

    public static UniversityFactory getUniversityFactory(int score)
    {
        if(score > scores)
        {
            return new TrihbuwanUniversityFactory();
        }else
        {
            return new PokharaUniversityFactory();
        }
    }

    public abstract Course getCourses(String stream);
}
