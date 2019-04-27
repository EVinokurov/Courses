package ru.itis.forms;

import lombok.Data;

@Data
public class SignUpForm {

    private String name;
    private String sName;
    private String thName;
    private String login;
    private String password;
    private Boolean isStudent;
    private String groupe;


}

