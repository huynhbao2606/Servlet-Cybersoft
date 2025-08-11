package com.example.crm.entity;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Job {
    private int id;
    private String name;
    private Date  start_date;
    private Date  end_date;
}
