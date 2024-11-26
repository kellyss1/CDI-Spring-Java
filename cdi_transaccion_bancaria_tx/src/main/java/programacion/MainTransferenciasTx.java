package programacion;

import programacion.servicios.interfaces.ManejadorPersistencia;
import programacion.servicios.interfaces.TransferenciaBancaria;
import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;

public class MainTransferenciasTx {
    public static void main(String[] args) {
        SeContainer container = SeContainerInitializer.newInstance().initialize();
        TransferenciaBancaria servicio = container.select(TransferenciaBancaria.class).get();

        var manejadorPersistencia = container.select(ManejadorPersistencia.class).get();
        System.out.println(servicio);

        String num1 = "001";
        String num2 = "002";

        var cuenta1 = manejadorPersistencia.buscarCuenta(num1);
        var cuenta2 = manejadorPersistencia.buscarCuenta(num2);

        System.out.println(cuenta1);
        System.out.println(cuenta2);

        servicio.transferir(num2, num1, 50);

        cuenta1 = manejadorPersistencia.buscarCuenta(num1);
        cuenta2 = manejadorPersistencia.buscarCuenta(num2);

        System.out.println(cuenta1);
        System.out.println(cuenta2);
//
//        System.out.println(cuenta);
        container.close();
    }
}
