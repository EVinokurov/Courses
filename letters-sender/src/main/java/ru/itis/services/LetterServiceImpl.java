package ru.itis.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.FormLetter;
import ru.itis.entities.Letter;
import ru.itis.repository.LetterRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class LetterServiceImpl implements LetterService {

    private LetterRepository letterRepository;

    @Autowired
    public LetterServiceImpl(LetterRepository letterRepository) {
        this.letterRepository = letterRepository;
    }

    @Override
    public Optional<Letter> findByReceiver(String receiver) {
        return letterRepository.findByReceiver(receiver);
    }

    @Override
    public void save(String letterForm) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            FormLetter letter = mapper.readValue(letterForm, FormLetter.class);
            Letter newLetter = Letter.builder()
                    .receiver(letter.getReceiver())
                    .subjectMatter(letter.getSubjectMatter())
                    .letterText(letter.getLetterText())
                    .statusOfSendingLetter(false)
                    .build();
            letterRepository.save(newLetter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
