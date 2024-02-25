package com.project.BitlabTask.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private int id;
    private String name;
    private String surname;
    private String email;
    private String subject;
    private String imageUrl;
    private int exam;
    private String mark;
    @Column(nullable = false, updatable = false)
    private String studentCode;

}
