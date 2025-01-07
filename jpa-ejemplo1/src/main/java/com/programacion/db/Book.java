package com.programacion.db;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "books")
@Data
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
