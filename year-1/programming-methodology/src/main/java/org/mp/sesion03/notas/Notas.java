package org.mp.sesion03.notas;

import org.mp.sesion03.pares.Par;

/**
 * Clase que gestiona las calificaciones de un grupo de alumnos.
 * Utiliza un array de objetos Par para almacenar el ID del alumno y su nota.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 30-03-2026
 */
public class Notas {

    private Par<String, Double>[] calificaciones;
    private int numCalificaciones;

    /**
     * Constructor que inicializa el array de calificaciones con una capacidad dada.
     * * @param capacidad Número máximo de notas que se pueden almacenar.
     *
     * @throws IllegalArgumentException si la capacidad es menor o igual a cero.
     */
    @SuppressWarnings("unchecked")
    public Notas(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad máxima debe ser un número positivo.");
        }
        this.calificaciones = (Par<String, Double>[]) new Par[capacidad];
        this.numCalificaciones = 0;
    }

    /**
     * Añade una nueva nota si el alumno no existe previamente y hay espacio.
     * * @param idAlumno Identificador único del alumno.
     *
     * @param nota Valor numérico de la calificación (0.0 a 10.0).
     * @return true si se añadió con éxito, false en caso contrario.
     */
    public boolean agregarNota(String idAlumno, Double nota) {

        if (idAlumno == null || idAlumno.trim().isEmpty() || nota == null) {
            return false;
        }

        if (nota < 0.0 || nota > 10.0) {
            return false;
        }

        // Comprobar si el alumno ya está registrado (evitar duplicados)
        for (int i = 0; i < numCalificaciones; i++) {
            if (calificaciones[i].getPrimero().equalsIgnoreCase(idAlumno)) {
                return false;
            }
        }

        // Comprobar si hay espacio en el array
        if (numCalificaciones >= calificaciones.length) {
            return false;
        }

        calificaciones[numCalificaciones] = new Par<>(idAlumno, nota);
        numCalificaciones++;

        return true;
    }

    /**
     * Busca la nota de un alumno por su ID.
     * * @param idAlumno Identificador del alumno a buscar.
     *
     * @return La nota del alumno o null si no se encuentra o el ID es inválido.
     */
    public Double obtenerNota(String idAlumno) {
        if (idAlumno == null || idAlumno.trim().isEmpty()) {
            return null;
        }

        for (int i = 0; i < numCalificaciones; i++) {
            if (calificaciones[i].getPrimero().equalsIgnoreCase(idAlumno)) {
                return calificaciones[i].getSegundo();
            }
        }

        return null;
    }

    /**
     * Calcula la media aritmética de todas las notas registradas.
     * * @return El promedio de las notas o 0.0 si no hay calificaciones.
     */
    public double calcularMedia() {
        if (numCalificaciones == 0) {
            return 0.0;
        }
        double sumaTotal = 0.0;
        for (int i = 0; i < numCalificaciones; i++) {
            sumaTotal += calificaciones[i].getSegundo();
        }
        return sumaTotal / numCalificaciones;
    }

    /**
     * Genera una cadena de texto con el listado de todos los alumnos y sus notas.
     * * @return String con el listado formateado.
     */
    public String listarNotas() {
        if (numCalificaciones == 0) {
            return "No hay calificaciones registradas.";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numCalificaciones; i++) {
            sb.append("Alumno: ").append(calificaciones[i].getPrimero())
                    .append(", Nota: ").append(calificaciones[i].getSegundo())
                    .append("\n");
        }
        return sb.toString();
    }

    /**
     * @return Devuelve el total de número de notas.
     */
    public int getNumeroNotas() {
        return numCalificaciones;
    }

}