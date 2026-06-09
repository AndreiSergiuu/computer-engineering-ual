package org.mp.sesion08.utilidades;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

/**
 * Métodos estáticos para operaciones con archivos y directorios usando {@code java.io} y {@code java.nio}.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 09-06-2026
 */
public class UtilidadesArchivos {

    // -------------------------------------------------------------------------
    // java.io.File
    // -------------------------------------------------------------------------

    /**
     * Crea un nuevo archivo en la ruta especificada.
     *
     * @param ruta Ruta del archivo a crear.
     * @throws IOException Si no se puede crear el archivo.
     */
    public static void crearArchivo(String ruta) throws IOException {
        new File(ruta).createNewFile();
    }

    /**
     * @param ruta Ruta a verificar.
     * @return {@code true} si el archivo existe.
     */
    public static boolean verificarExistenciaArchivo(String ruta) {
        return new File(ruta).exists();
    }

    /**
     * Elimina el archivo en la ruta indicada.
     *
     * @param ruta Ruta del archivo a eliminar.
     * @return {@code true} si fue eliminado; {@code false} si no existía o falló.
     */
    public static boolean eliminarArchivo(String ruta) {
        return new File(ruta).delete();
    }

    /**
     * @param rutaCompleta Ruta completa del archivo.
     * @return Nombre del archivo (última parte de la ruta).
     */
    public static String obtenerNombreArchivo(String rutaCompleta) {
        return new File(rutaCompleta).getName();
    }

    /**
     * @param rutaCompleta Ruta completa del archivo.
     * @return Ruta del directorio padre.
     */
    public static String obtenerRutaPadre(String rutaCompleta) {
        return new File(rutaCompleta).getParent();
    }

    // -------------------------------------------------------------------------
    // java.nio.file.Files
    // -------------------------------------------------------------------------

    /**
     * Copia un archivo de origen a destino, reemplazando si ya existe.
     *
     * @param rutaOrigen  Ruta del archivo origen.
     * @param rutaDestino Ruta del archivo destino.
     * @throws IOException Si la copia falla.
     */
    public static void copiarArchivo(String rutaOrigen, String rutaDestino) throws IOException {
        Files.copy(Paths.get(rutaOrigen), Paths.get(rutaDestino), StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * Mueve un archivo de origen a destino.
     *
     * @param rutaOrigen  Ruta del archivo origen.
     * @param rutaDestino Ruta del archivo destino.
     * @throws IOException Si el movimiento falla.
     */
    public static void moverArchivo(String rutaOrigen, String rutaDestino) throws IOException {
        Files.move(Paths.get(rutaOrigen), Paths.get(rutaDestino), StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * @param ruta Ruta del archivo.
     * @return Tamaño en bytes.
     * @throws IOException Si no se puede acceder al archivo.
     */
    public static long obtenerTamanioArchivo(String ruta) throws IOException {
        return Files.size(Paths.get(ruta));
    }

    /**
     * @param ruta Ruta a verificar.
     * @return {@code true} si la ruta corresponde a un directorio.
     */
    public static boolean verificarSiEsDirectorio(String ruta) {
        return Files.isDirectory(Paths.get(ruta));
    }

    // -------------------------------------------------------------------------
    // java.nio.file.Path
    // -------------------------------------------------------------------------

    /**
     * @return Ruta actual de trabajo del sistema.
     */
    public static Path obtenerRutaActual() {
        return Paths.get("").toAbsolutePath();
    }

    /**
     * @return Ruta raíz del sistema de archivos.
     */
    public static Path obtenerRutaRaiz() {
        return Paths.get("").toAbsolutePath().getRoot();
    }

    /**
     * @param rutaBase      Ruta base de referencia.
     * @param rutaEspecifica Ruta de la que se quiere obtener la relativa.
     * @return Ruta relativa de {@code rutaEspecifica} respecto a {@code rutaBase}.
     */
    public static Path obtenerRutaRelativa(Path rutaBase, Path rutaEspecifica) {
        return rutaBase.relativize(rutaEspecifica);
    }

    // -------------------------------------------------------------------------
    // java.nio.file.Paths
    // -------------------------------------------------------------------------

    /**
     * @param ruta Objeto Path.
     * @return Representación en cadena de la ruta.
     */
    public static String obtenerStringRuta(Path ruta) {
        return ruta.toString();
    }

    /**
     * @param ruta1 Primera ruta.
     * @param ruta2 Segunda ruta.
     * @return {@code true} si ambas rutas son iguales.
     */
    public static boolean compararRutas(Path ruta1, Path ruta2) {
        return ruta1.equals(ruta2);
    }

    // -------------------------------------------------------------------------
    // Otros métodos
    // -------------------------------------------------------------------------

    /**
     * Copia un directorio y su contenido de forma recursiva.
     *
     * @param rutaOrigen  Directorio origen.
     * @param rutaDestino Directorio destino (se crea si no existe).
     * @throws IOException Si la copia falla.
     */
    public static void copiarDirectorioRecursivamente(String rutaOrigen, String rutaDestino) throws IOException {
        Path origen  = Paths.get(rutaOrigen);
        Path destino = Paths.get(rutaDestino);
        Files.walkFileTree(origen, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                Path target = destino.resolve(origen.relativize(dir));
                Files.createDirectories(target);
                return FileVisitResult.CONTINUE;
            }
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.copy(file, destino.resolve(origen.relativize(file)), StandardCopyOption.REPLACE_EXISTING);
                return FileVisitResult.CONTINUE;
            }
        });
    }

    /**
     * Copia al directorio destino solo los archivos cuyo nombre coincida con el patrón regex.
     *
     * @param rutaOrigen     Directorio origen.
     * @param rutaDestino    Directorio destino (se crea si no existe).
     * @param filtroNombre   Expresión regular para filtrar por nombre de archivo.
     * @throws IOException Si la copia falla.
     */
    public static void copiarArchivosConFiltro(String rutaOrigen, String rutaDestino, String filtroNombre)
            throws IOException {
        Path origen  = Paths.get(rutaOrigen);
        Path destino = Paths.get(rutaDestino);
        Files.createDirectories(destino);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(origen)) {
            for (Path entry : stream) {
                if (Files.isRegularFile(entry) && entry.getFileName().toString().matches(filtroNombre)) {
                    Files.copy(entry, destino.resolve(entry.getFileName()), StandardCopyOption.REPLACE_EXISTING);
                }
            }
        }
    }

    /**
     * @param rutaDirectorio Ruta del directorio a listar.
     * @return Lista de archivos (no directorios) en el directorio.
     * @throws IOException Si el directorio no puede leerse.
     */
    public static List<File> listarArchivosEnDirectorio(String rutaDirectorio) throws IOException {
        List<File> archivos = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(rutaDirectorio))) {
            for (Path entry : stream) {
                if (Files.isRegularFile(entry)) archivos.add(entry.toFile());
            }
        }
        return archivos;
    }

    /**
     * Recorre un directorio recursivamente aplicando el {@link FileVisitor} dado.
     *
     * @param rutaDirectorio Directorio raíz del recorrido.
     * @param visitor        Visitante a aplicar en cada nodo.
     * @throws IOException Si el recorrido falla.
     */
    public static void recorrerDirectorioRecursivamente(String rutaDirectorio, FileVisitor<Path> visitor)
            throws IOException {
        Files.walkFileTree(Paths.get(rutaDirectorio), visitor);
    }
}