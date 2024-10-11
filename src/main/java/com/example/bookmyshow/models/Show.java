package com.example.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "shows") // table name changed as show is a reserved keyword in SQL
public class Show extends BaseModel {
    @ManyToOne
    private Movie movie;
    private Date startTime;
    private Date endTime;

    @ManyToOne
    private Screen screen;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
    private String language;
}

/*
      1    ->    1
    SHOW ----> MOVIE (Many to One)
    many   ->    1

      1    ->    1
    SHOW ----> SCREEN (Many to One)
    many   ->    1

 */