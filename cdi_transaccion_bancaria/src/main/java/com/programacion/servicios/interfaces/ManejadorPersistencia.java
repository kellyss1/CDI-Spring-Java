package com.programacion.servicios.interfaces;

import com.programacion.db.Cuenta;

public interface ManejadorPersistencia {
    Cuenta buscarCuenta(String numero);
    void actualizarCuenta(Cuenta cuenta, double monto);
}
