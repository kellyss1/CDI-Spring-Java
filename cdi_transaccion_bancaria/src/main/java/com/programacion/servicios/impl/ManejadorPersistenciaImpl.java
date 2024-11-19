package com.programacion.servicios.impl;

import com.programacion.db.Cuenta;
import com.programacion.servicios.interfaces.ManejadorPersistencia;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@ApplicationScoped
public class ManejadorPersistenciaImpl  implements ManejadorPersistencia {

    @Inject
    DataSource dataSource;

    @Override
    public Cuenta buscarCuenta(String numero) {
        //obtener conexion a la base de datos, consultar la cuenta bancaria
        try(var con = dataSource.getConnection()){

            PreparedStatement pstat = con.prepareStatement("SELECT * FROM cuentas WHERE numero = ?");
            pstat.setString(1, numero);
            ResultSet rs = pstat.executeQuery();

            if(rs.next()){
                Cuenta cuenta = new Cuenta();
                cuenta.setId(rs.getInt("id"));
                cuenta.setNumero(rs.getString("numero"));
                cuenta.setSaldo(rs.getDouble("saldo"));

                return cuenta;
            }
        } catch(Exception ex){
            throw new RuntimeException(ex);
        }
        throw new RuntimeException("Cuenta no encontrada: "+ numero);
    }

    @Override
    public void actualizarCuenta(Cuenta cuenta, double monto) {
        try(var con = dataSource.getConnection()) {

            PreparedStatement pstat = con.prepareStatement("UPDATE cuentas SET saldo =saldo + ? WHERE numero = ?");
            pstat.setDouble(1, monto);
            pstat.setString(2, cuenta.getNumero());
            pstat.executeUpdate();
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
