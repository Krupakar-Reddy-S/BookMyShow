package com.example.bookmyshow.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseModel {
    @Id // Identifies as Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto Increment starting from 1
    private long id;

    // Auditing attributes
    private Date createdAt;
    private Date lastModifiedAt;
}


/*
MappedSupeClass annotation -

    1. No table for parent class.
    2 All the attributes of parent class will be present as
    columns in all the child class tables.
 */