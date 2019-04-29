package ru.itis.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignUpForm {

    private String fName;
    private String sName;
    private String thName;
    private String login;
    private String hashPassword;
    private int role;
    private String group;
    private int courseNumber;
}

