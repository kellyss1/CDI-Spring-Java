package com.programacion.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Entity
@Table(name = "books")
@Getter
@Setter
@ToString
public class Book {
    @Id
    private Integer id;
    private String isbn;
    private String titulo;
    private BigDecimal precio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "authors_id")
    private Author author;

}
