package com.programacion;

import java.util.ArrayList;
import java.util.concurrent.Callable;

public class SumaVectorMain {

    static class ResultHolder{

        ArrayList<Integer> sumas = new ArrayList<>();
        ResultHolder (int tasks){
            for (int i = 0; i < tasks; i++) {
                sumas.add(0);
            }
        }

        private int sumResults(){
            int resultado = 0;
            for(int suma: sumas){
                resultado += suma;
            } return resultado;
        }

        public void agregarSuma() {
            sumas.add(0);
        }
    }

//    static Integer sumaSerial(int[] datos) {
//        int suma = 0;
//        for (int i = 0; i < datos.length; i++) {
//            suma = suma+datos[i];
//        }
//        return suma;
//    }


    static Integer sumaThreads(int[] datos, int tasks) throws Exception{

        ArrayList<SumaTask> task = new ArrayList<>();
        for(int i=0; i < tasks; i++){
            task.add(new SumaTask(datos, i*(datos.length/tasks), (i+1)*(datos.length/tasks)));
        }
//
//        int octavo = datos.length / 8;
//
//        SumaTask task1 = new SumaTask(datos,0, octavo);
//        SumaTask task2 = new SumaTask(datos,octavo, octavo*2);
//        SumaTask task3 = new SumaTask(datos,octavo*2, octavo*3);


        final ResultHolder result = new ResultHolder(tasks);

        ArrayList<Thread> threads = new ArrayList<>();
        if(datos.length % tasks != 0){
            int modulo = datos.length % tasks;
            task.add(new SumaTask(datos, datos.length-modulo, datos.length));
            System.out.println("Se ha creado un hilo adicional, ya que el tamaño del vector no es divisible entre el número de tareas");
            tasks++;
            result.agregarSuma();
        }
        for(int i=0; i < tasks; i++){
            int finalI = i;
            threads.add(new Thread(() -> {result.sumas.set(finalI, task.get(finalI).call());}));
            threads.get(i).start();
        } threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        return result.sumResults();
        //return result.suma1 + result.suma2+ result.suma3+ result.suma4+ result.suma5+ result.suma6+ result.suma7+ result.suma8;
    }

    static class SumaTask implements Callable<Integer> {
        private int[] data;
        private int start;
        private int end;

        SumaTask(int[] data, int start, int end){
            this.data = data;
            this.start = start;
            this.end = end;
        }


        @Override
        public Integer call() {
            System.out.printf("[%s] inicio Calculando suma, start%d, end%d\n" , Thread.currentThread().getName(), start, end);
            try{
                Thread.sleep(10_000);
            }catch (Exception e){
            }
            int suma = 0;
            for (int i=start; i<end; i++){
                suma = suma + data[i];
            }
            System.out.printf("[%s] Fin calculando suma, start%d, end%d\n" , Thread.currentThread().getName(),start, end);
            return suma;
        }
    }



    public static void main(String[] args) throws Exception{
        //[0,1,2,3,4,..........99]
        int[] vector = new int[1_000];

        for (int i = 0; i < vector.length; i++) {
            vector[i] = i;
        }

        int suma = sumaThreads(vector, 4);
        System.out.println("Suma total: " + suma);
    }

}
