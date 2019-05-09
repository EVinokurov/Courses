package ru.itis.email;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.itis.FormLetter;

@Service
public class LetterServiceImpl implements LetterService {

    private static final String URL_FOR_MESSAGES = "http://localhost:8090/confirm";
    private static final String URL_FOR_CONFIRM = "http://localhost:8080/";

    private RestTemplate restTemplate;

    @Autowired
    public LetterServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public void sendConfirmLetter(String email, String letterText) {
        try {
            String json = new ObjectMapper().
                    writeValueAsString(
                            new FormLetter
                                    (email, "confirmMessage", URL_FOR_CONFIRM + letterText));
            restTemplate.postForObject(URL_FOR_MESSAGES, json, String.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
