package org.mp.sesion03.notas;

import org.mp.sesion03.pares.Par;

public class Notas {

	private Par<String, Double>[] calificaciones;
	private int numCalificaciones;

	public Notas(int capacidad) {
		this.calificaciones = new Par[capacidad];
		this.numCalificaciones = 0;
	}

	public boolean agregarNota(String idAlumno, Double nota) {

		if (idAlumno == null || idAlumno.equals("") || nota == null) {
			return false;
		}

		if (numCalificaciones >= calificaciones.length) {
			return false;
		}

		for (int i = 0; i < numCalificaciones; i++) {
			if (calificaciones[i].getPrimero().equalsIgnoreCase(idAlumno)) {
				return false;
			}
		}

		calificaciones[numCalificaciones] = new Par<>(idAlumno, nota);
		numCalificaciones++;

		return true;
	}

	public Double obtenerNota(String idAlumno) {

		for (int i = 0; i < calificaciones.length; i++) {

			if (calificaciones[i].getPrimero().equalsIgnoreCase(idAlumno)) {
				return calificaciones[i].getSegundo();
			}

		}

		return null;

	}

	public Double calcularMedia() {

		if (numCalificaciones == 0) {
			return 0.0;
		}

		double media = 0.0;

		for (int i = 0; i < calificaciones.length; i++) {

			media += calificaciones[i].getSegundo();

		}

		return media / numCalificaciones;

	}

	public int getNumeroNotas() {
		return numCalificaciones;
	}

	public String listarNotas() {

		if (numCalificaciones == 0) {
			return "No hay calificaciones registradas.";
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < numCalificaciones; i++) {
			sb.append("Alumno: ").append(calificaciones[i].getPrimero()).append(", Nota: ")
					.append(calificaciones[i].getSegundo()).append("\n");
		}

		return sb.toString();
	}
}
