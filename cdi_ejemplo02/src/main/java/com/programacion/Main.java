package com.programacion;

import com.programacion.services.MiBean;
import com.programacion.services.Operaciones;
import jakarta.enterprise.inject.spi.Bean;
import jakarta.enterprise.inject.spi.BeanManager;
import org.apache.webbeans.config.WebBeansContext;
import org.apache.webbeans.spi.ContainerLifecycle;

public class Main {
    public static void main(String[] args) {
        ContainerLifecycle lifecycle = WebBeansContext.getInstance()
                .getService(ContainerLifecycle.class);
        lifecycle.startApplication(null);
        BeanManager beanManager = lifecycle.getBeanManager();
        Bean<?> bean = beanManager.getBeans(Operaciones.class, MiBean.Literal.INSTANCE)
                .iterator().next();
        var context = beanManager.createCreationalContext(bean);
        Operaciones servicio = (Operaciones )beanManager.getReference(bean, Operaciones.class, null);
        int ret = servicio.sumar( 5, 9 );
        System.out.printf( "Respuesta: %d\n", ret );
    }
}
