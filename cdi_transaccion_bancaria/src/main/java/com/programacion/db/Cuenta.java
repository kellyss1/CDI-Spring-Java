package com.programacion.db;

import lombok.Data;
import lombok.Getter;

@Data
public class Cuenta {
    private Integer id;
    private String numero;
    private Double saldo;
}
