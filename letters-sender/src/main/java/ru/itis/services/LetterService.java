package ru.itis.services;

import ru.itis.FormLetter;
import ru.itis.entities.Letter;

import java.util.List;
import java.util.Optional;

public interface LetterService {

    Optional<Letter> findByReceiver(String receiver);

    void save(String letter);
}
