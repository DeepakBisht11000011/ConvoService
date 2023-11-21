package com.deepweb.convo.entities;

import com.deepweb.convo.constants.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel {
    private Long id;
    private String firstName;
    private String lastName;
    private UserType userType;
}
