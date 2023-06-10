package com.example.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.io.Serializable;

@Entity
@Getter
public class Horses implements Serializable {

    @Id
    private long id;

    private String name;
}
