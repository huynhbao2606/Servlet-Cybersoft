package com.example.crm.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Role {
    private int id;
    private String name;
    private String description;
}
