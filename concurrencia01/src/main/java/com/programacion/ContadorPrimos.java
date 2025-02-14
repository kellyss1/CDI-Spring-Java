package com.programacion;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class ContadorPrimos {

    // Metodo serial para contar primos
    public static int countPrimosSerial(int N) {
        int count = 0;
        for (int i = 2; i <= N; i++) {
            if (esPrimo(i)) {
                count++;
            }
        }
        return count;
    }

    // Metodo para verificar si un numero es primo
    private static boolean esPrimo(int num) {
        if (num < 2) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // Clase para la version concurrente con Fork-Join
    static class TaskPrimos extends RecursiveTask<Integer> {
        private static final int THRESHOLD = 10_000; // Tamaño mínimo de la tarea
        private final int inicio, fin;

        TaskPrimos(int inicio, int fin) {
            this.inicio = inicio;
            this.fin = fin;
        }

        @Override
        protected Integer compute() {
            if (fin - inicio <= THRESHOLD) { // Si el rango es pequeño, resolver secuencialmente
                int count = 0;
                for (int i = inicio; i <= fin; i++) {
                    if (esPrimo(i)) {
                        count++;
                    }
                }
                return count;
            } else { // Dividir en subtareas
                int mid = (inicio + fin) / 2;
                TaskPrimos taskDerecha = new TaskPrimos(inicio, mid);
                TaskPrimos taskIzquierda = new TaskPrimos(mid + 1, fin);

                taskDerecha.fork(); // Ejecutar en paralelo
                int izqResult = taskIzquierda.compute();
                int derechaResult = taskDerecha.join();

                return derechaResult + izqResult;
            }
        }
    }

    // Metodo concurrente con Fork-Join
    public static int countPrimosParalelo(int N) {
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(new TaskPrimos(2, N));
    }

    // Metodo principal para medir tiempos y comparar
    public static void main(String[] args) {
        int N = 1_000_000;

        long startTime = System.currentTimeMillis();
        int serialResult = countPrimosSerial(N);
        long serialTime = System.currentTimeMillis() - startTime;
        System.out.println("Serial: " + serialResult + " primos en " + serialTime + " ms");

        startTime = System.currentTimeMillis();
        int parallelResult = countPrimosParalelo(N);
        long parallelTime = System.currentTimeMillis() - startTime;
        System.out.println("Paralelo: " + parallelResult + " primos en " + parallelTime + " ms");
    }
}

