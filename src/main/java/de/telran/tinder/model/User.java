package de.telran.tinder.model;

import lombok.*;

// POJO - Plain old java object - старый добрый джава объект
@Data
public class User {

    private long id;
    private String name;
    private int rating;
    private String description;
}
