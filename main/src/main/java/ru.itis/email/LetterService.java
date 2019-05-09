package ru.itis.email;

public interface LetterService {

    void sendConfirmLetter(String email, String letterText);
}
