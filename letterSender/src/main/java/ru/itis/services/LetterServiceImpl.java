package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.itis.entities.Letter;
import ru.itis.repository.MailRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LetterServiceImpl implements LetterService {

    MailRepository mailRepository;

    @Autowired
    public LetterServiceImpl(MailRepository mailRepository) {
        this.mailRepository = mailRepository;
    }

    @Override
    public void saveLetter(Letter letter) {
        mailRepository.save(letter);
    }

    @Override
    public List<Letter> findAllByStatus(boolean status) {
       return  mailRepository.findAllByStatusOfLetter(status);
    }

    @Override
    public Optional<Letter> findByReceiver(String receiver) {
        return mailRepository.findByReceiver(receiver);
    }
}
