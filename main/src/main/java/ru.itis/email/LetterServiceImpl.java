package ru.itis.email;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.itis.FormLetter;

@Service
public class LetterServiceImpl implements LetterService {

    private static final String URL_FOR_MESSAGES = "http://localhost:8090/confirm";
    private static final String URL_FOR_CONFIRM = "http://localhost:8080/";

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public void sendConfirmLetter(String email, String text) {
        try {
            String json = new ObjectMapper().
                    writeValueAsString(
                            new FormLetter(
                                    email, "confirmMessage", URL_FOR_CONFIRM + text));
            restTemplate.postForObject(URL_FOR_MESSAGES, json, String.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
