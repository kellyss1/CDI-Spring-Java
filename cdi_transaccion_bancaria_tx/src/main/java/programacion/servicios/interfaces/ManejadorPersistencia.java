package programacion.servicios.interfaces;

import programacion.db.Cuenta;

public interface ManejadorPersistencia {
    Cuenta buscarCuenta(String numero);
    void actualizarSaldo(Cuenta cuenta, double monto);
}
