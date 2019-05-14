package ru.itis.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EditProfileForm {

    private String fName;
    private String sName;
    private String thName;
    private String groupNumber;
    private int courseNumber;
}
