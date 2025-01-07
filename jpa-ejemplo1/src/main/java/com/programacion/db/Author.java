package com.programacion.db;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "authors")
@Data
public class Author {
    @Id
    private Integer id;
    private String nombre;

    @Basic(fetch = FetchType.LAZY) // HINT: Por defecto es EAGER
    private String apellido;

}
