package com.programacion;

import com.programacion.servicios.interfaces.ManejadorPersistencia;
import com.programacion.servicios.interfaces.TransferenciaBancaria;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTransferenciasSpring {
    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("app.xml");

        context.getBean(TransferenciaBancaria.class);
        TransferenciaBancaria servicio = context.getBean(TransferenciaBancaria.class);
        var manejadorPersistencia = context.getBean(ManejadorPersistencia.class);

        var cuenta1 = manejadorPersistencia.buscarCuenta("001");
        var cuenta2 = manejadorPersistencia.buscarCuenta("002");

        System.out.println(cuenta1);
        System.out.println(cuenta2);

        servicio.transferir("001","002",50);

        cuenta1 = manejadorPersistencia.buscarCuenta("001");
        cuenta2 = manejadorPersistencia.buscarCuenta("002");

        System.out.println("Despues de la transferencia de la cuenta 2 a la cuenta 1");
        System.out.println(cuenta1);
        System.out.println(cuenta2);
//        var manejadorPersistencia = container.select(ManejadorPersistencia.class).get();
//        var cuenta = manejadorPersistencia.buscarCuenta("001");
//
//        System.out.println(cuenta);
        context.close();
    }
}
