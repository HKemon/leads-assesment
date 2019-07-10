package com.leads.assesment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student implements Serializable {
    private static final long serialVersionUID = 152356L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String name;
    private int age;
    private String address;
}
