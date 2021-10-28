package com.example.herokutry.models.entities;


import javax.persistence.*;

@Entity
@Table(name = "chars")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;
    @Column
    public String name;
    @Column
    public double rating;

}
