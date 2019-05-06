package ru.itis.services;

import ru.itis.entities.Letter;

import java.util.List;
import java.util.Optional;

public interface LetterService {

    void saveLetter(Letter letter);

    List<Letter> findAllByStatus(boolean status);

    Optional<Letter> findByReceiver(String receiver);
}
