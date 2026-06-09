package org.mp.sesion08.conjuntodatos;

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Lee y manipula datos tabulares desde un archivo de texto con separador configurable.
 * La primera línea se interpreta como cabecera; el resto son filas de datos.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 09-06-2026
 */
public class ConjuntoDatos {

    private File archivoTexto;
    private String separador;
    private Locale locale;
    private ArrayList<String> cabecera;
    private int numeroLineas;
    private int numeroColumnas;
    private String[][] datosString;

    /**
     * Lee el archivo y construye el conjunto de datos.
     *
     * @param archivoTexto Archivo de texto de entrada.
     * @param separador    Carácter(es) delimitador(es) de columnas.
     * @param locale       Locale para interpretar valores numéricos.
     * @throws IOException Si el archivo no puede leerse.
     */
    public ConjuntoDatos(File archivoTexto, String separador, Locale locale) throws IOException {
        this.archivoTexto = archivoTexto;
        this.separador    = separador;
        this.locale       = locale;
        this.cabecera     = new ArrayList<>();

        // Primera pasada: contar líneas y columnas
        int filas = 0;
        int columnas = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(archivoTexto))) {
            String linea = br.readLine(); // cabecera
            if (linea != null) {
                String[] cols = linea.split(separador, -1);
                columnas = cols.length;
                for (String col : cols) cabecera.add(col.trim());
            }
            while (br.readLine() != null) filas++;
        }

        this.numeroColumnas = columnas;
        this.numeroLineas   = filas;
        this.datosString    = leerDatos(archivoTexto, filas, columnas);
    }

    /**
     * Lee las filas de datos (sin cabecera) y las almacena en un array bidimensional.
     */
    private String[][] leerDatos(File archivo, int filas, int columnas) throws IOException {
        String[][] datos = new String[filas][columnas];
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            br.readLine(); // saltar cabecera
            for (int i = 0; i < filas; i++) {
                String linea = br.readLine();
                if (linea != null) {
                    String[] partes = linea.split(separador, -1);
                    for (int j = 0; j < columnas; j++) {
                        datos[i][j] = j < partes.length ? partes[j].trim() : "";
                    }
                }
            }
        }
        return datos;
    }

    /** @return Archivo de texto fuente. */
    public File getArchivoTexto() { return archivoTexto; }

    /** @return Separador de columnas. */
    public String getSeparador() { return separador; }

    /** @return Locale del conjunto de datos. */
    public Locale getLocale() { return locale; }

    /** @return Cabecera (nombres de columnas). */
    public ArrayList<String> getCabecera() { return cabecera; }

    /** @return Número de filas de datos (sin contar la cabecera). */
    public int getNumeroLineas() { return numeroLineas; }

    /** @return Número de columnas. */
    public int getNumeroColumnas() { return numeroColumnas; }

    /** @return Array bidimensional con todos los datos como String. */
    public String[][] getDatosString() { return datosString; }

    /**
     * Devuelve todos los valores de la columna indicada por índice.
     *
     * @param indice Índice de columna (0-based).
     * @return Array con los valores de la columna.
     * @throws ArrayIndexOutOfBoundsException Si el índice está fuera de rango.
     */
    public String[] getColumna(int indice) {
        if (indice < 0 || indice >= numeroColumnas) {
            throw new ArrayIndexOutOfBoundsException("Índice de columna fuera de rango: " + indice);
        }
        String[] columna = new String[numeroLineas];
        for (int i = 0; i < numeroLineas; i++) columna[i] = datosString[i][indice];
        return columna;
    }

    /**
     * Devuelve todos los valores de la columna con el nombre indicado.
     *
     * @param nombre Nombre de la columna según la cabecera.
     * @return Array con los valores, o {@code null} si no existe la columna.
     */
    public String[] getColumna(String nombre) {
        int idx = cabecera.indexOf(nombre);
        if (idx == -1) return null;
        return getColumna(idx);
    }

    /**
     * Exporta un subconjunto de columnas a un nuevo archivo de texto.
     *
     * @param cabeceraSalida Nombres de las columnas a exportar.
     * @param rutaSalida     Ruta del archivo de salida.
     * @param sep            Separador a usar en el archivo de salida.
     * @throws IOException Si no se puede escribir el archivo.
     */
    public void exportar(String[] cabeceraSalida, String rutaSalida, String sep) throws IOException {
        // Resolver los índices de las columnas pedidas
        int[] indices = new int[cabeceraSalida.length];
        for (int i = 0; i < cabeceraSalida.length; i++) {
            indices[i] = cabecera.indexOf(cabeceraSalida[i]);
        }

        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(rutaSalida)))) {
            // Cabecera
            pw.println(String.join(sep, cabeceraSalida));
            // Filas
            for (int i = 0; i < numeroLineas; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < indices.length; j++) {
                    if (j > 0) sb.append(sep);
                    sb.append(indices[j] >= 0 ? datosString[i][indices[j]] : "");
                }
                pw.println(sb.toString());
            }
        }
    }
}