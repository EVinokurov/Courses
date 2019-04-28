package ru.itis.forms;

import lombok.Data;

@Data
public class SignUpForm {

    private String fName;
    private String sName;
    private String thName;
    private String login;
    private String password;
    private int role;
    private String group;
    private int courseNumber;
}

