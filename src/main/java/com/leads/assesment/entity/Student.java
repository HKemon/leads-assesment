package com.leads.assesment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/*
 * Stores the Values of Student object
 */

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

    @Size(min = 4, message = "Name has to be at least 4 character long")
    @NotNull(message = "Name cannot be null")
    private String name;

    private int age;

    @Size(min = 10, message = "Address has to be at least 10 character long")
    @NotNull(message = "Address cannot be null")
    private String address;

    @Past(message = "Date of Birth has to be past")
    @NotNull(message = "Birth date cannot be null")
    private Date dateOfBirth;
}
