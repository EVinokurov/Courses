package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.entities.Letter;

import java.util.List;
import java.util.Optional;

public interface LetterRepository extends JpaRepository<Letter, Long> {

    List<Letter> findAllByStatusOfLetter(boolean status);

    Optional<Letter> findByReceiver(String receiver);

    Optional<Letter> findById(Long id);

}
