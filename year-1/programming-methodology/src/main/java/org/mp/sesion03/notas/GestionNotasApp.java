package org.mp.sesion03.notas;

/**
 * Clase de prueba para gestionar la lógica de las calificaciones.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 30-03-2026
 */
public class GestionNotasApp {

    public static void main(String[] args) {

        // Crear instancia de notas con una capacidad pequeña para probar límites.
        Notas notasParcialProgramacion = new Notas(3);

        System.out.println("--- Añadiendo notas del parcial ---");
        System.out.println("Añadiendo a Andrei (8.5): " + notasParcialProgramacion.agregarNota("Andrei", 8.5));
        System.out.println("Añadiendo a Luis (9.0): " + notasParcialProgramacion.agregarNota("Luis", 9.0));

        // Demostrar el uso de obtener nota y calcular media
        System.out.println("\n--- Pruebas de consulta y cálculo ---");
        System.out.println("Nota de Andrei: " + notasParcialProgramacion.obtenerNota("Andrei"));
        System.out.println("Media actual: " + notasParcialProgramacion.calcularMedia());

        // Demostrar manejo de duplicados
        System.out.println("\n--- Prueba de Duplicados ---");
        System.out.println("Intentando añadir Andrei otra vez (debe ser false): " + notasParcialProgramacion.agregarNota("Andrei", 5.0));

        // Demostrar maneja de falta de espacio
        System.out.println("\n--- Prueba de límite de espacio ---");
        System.out.println("Añadiendo a Valentin para llenar la capacidad: " + notasParcialProgramacion.agregarNota("Valentin", 6.0));
        System.out.println("Intentando añadir a Juan (debe dar false por falta de espacio): " + notasParcialProgramacion.agregarNota("Juan", 7.0));

        // Demostrar el listado de notas
        System.out.println("\n--- Listado Final de Notas ---");
        System.out.println(notasParcialProgramacion.listarNotas());

        System.out.printf("La media es: %.2f%n", notasParcialProgramacion.calcularMedia());
    }

}
