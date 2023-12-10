package com.f1soft.learning.studentmanagement.dto;

public class UniversityFactoryDto {

    private int score;
    private String stream;

    public UniversityFactoryDto(int score, String stream) {
        this.score = score;
        this.stream = stream;
    }

    public int getScore() {
        return score;
    }

    public String getStream() {
        return stream;
    }

    @Override
    public String toString() {
        return "UniversityFactoryDto{" +
                "score=" + score +
                ", stream='" + stream + '\'' +
                '}';
    }


}
