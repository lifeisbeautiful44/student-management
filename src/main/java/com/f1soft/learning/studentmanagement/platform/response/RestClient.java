package com.f1soft.learning.studentmanagement.platform.response;

import com.f1soft.learning.studentmanagement.dto.StudentDto;
import com.f1soft.learning.studentmanagement.exception.StudentApiException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class RestClient {
    public void callRestClient( StudentDto studentDto ) throws URISyntaxException, IOException, InterruptedException {

        String json = new ObjectMapper().writeValueAsString(studentDto);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI("http://localhost:8082/find/student"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> httpResponse =   httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        if (httpResponse.statusCode() == 200) {
            boolean success = Boolean.parseBoolean(httpResponse.body());
            System.out.println(success);
            if (success) {
                throw new StudentApiException(400,"Student already exists, cannot save ");
            }
        }
    }
}
