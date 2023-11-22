package com.deepweb.convo.entities;

import com.deepweb.convo.constants.UserType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
public class UserModel {

    private Long id;
    private String firstName;
    private String lastName;
    private UserType userType;
}
