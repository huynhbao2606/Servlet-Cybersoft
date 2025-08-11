package com.example.crm.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    private  int id;
    private String email;
    private String password;
    private String fullname;
    private String avatar;
    Role role;
}
