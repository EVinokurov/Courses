package ru.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.entities.Letter;

import java.util.List;
import java.util.Optional;
@Repository
public interface LetterRepository extends JpaRepository<Letter, Long> {

    Optional<Letter> findByReceiver(String receiver);

    Optional<Letter> findById(Long id);

}
