package com.example.entity;


import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
public class Horses implements Serializable {

    @Id
    private long id;

    private String name;
}
