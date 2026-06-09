package org.mp.sesion09;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mp.sesion09.audio.GestorBiblioteca;
import org.mp.sesion09.mp3.Artista;
import org.mp.sesion09.mp3.Biblioteca;
import org.mp.sesion09.mp3.Cancion;
import org.mp.sesion09.mp3.LectorMetadatosMP3;
import org.mp.sesion09.mp3.dao.BibliotecaJSONDAO;
import org.mp.sesion09.mp3.dao.BibliotecaXMLDAO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

public class LibraryMP3Test {

    @TempDir
    Path tempDir;

    @Test
    public void testID3v1Reader() throws IOException {
        Path mp3Path = tempDir.resolve("test.mp3");
        createFakeMP3(mp3Path, "Bohemian Rhapsody", "Queen", "A Night at the Opera", "1975");

        Cancion cancion = LectorMetadatosMP3.leer(mp3Path.toString());
        assertEquals("Bohemian Rhapsody", cancion.getTitulo());
        assertEquals("Queen", cancion.getArtista());
        assertEquals("A Night at the Opera", cancion.getAlbum());
        assertEquals("1975", cancion.getAnio());
    }

    @Test
    public void testLibraryHierarchy() {
        Biblioteca lib = new Biblioteca();
        lib.anadirCancion(new Cancion("S1", "Artist A", "Album X", "2024", "/path/1"));
        lib.anadirCancion(new Cancion("S2", "Artist A", "Album X", "2024", "/path/2"));
        lib.anadirCancion(new Cancion("S3", "Artist B", "Album Y", "2024", "/path/3"));

        assertEquals(2, lib.getArtistas().size());
        assertEquals(3, lib.getNumeroCanciones());

        Artista a = null;
        Object[] artistas = lib.getArtistas().toArray();
        for (int i = 0; i < artistas.length; i++) {
            Artista art = (Artista) artistas[i];
            if (art.getNombre().equals("Artist A")) {
                a = art;
                break;
            }
        }
        assertNotNull(a);
        assertEquals(1, a.getAlbums().size());
    }

    @Test
    public void testPersistencia() throws IOException {
        Biblioteca lib = new Biblioteca();
        lib.anadirCancion(new Cancion("Imagine", "John Lennon", "Imagine", "1971", "p1"));
        
        // Persistencia JSON
        String jsonPath = "biblioteca.json";
        BibliotecaJSONDAO jsonDAO = new BibliotecaJSONDAO();
        jsonDAO.guardar(lib, jsonPath);
        
        Biblioteca loadedJSON = jsonDAO.cargar(jsonPath);
        assertEquals(1, loadedJSON.getNumeroCanciones());
        
        Object[] artistasJSON = loadedJSON.getArtistas().toArray();
        Artista primerArtistaJSON = (Artista) artistasJSON[0];
        assertEquals("John Lennon", primerArtistaJSON.getNombre());

        // Persistencia XML
        String xmlPath = "biblioteca.xml";
        BibliotecaXMLDAO xmlDAO = new BibliotecaXMLDAO();
        xmlDAO.guardar(lib, xmlPath);
        
        Biblioteca loadedXML = xmlDAO.cargar(xmlPath);
        assertEquals(1, loadedXML.getNumeroCanciones());
    }

    @Test
    public void testMP3AppSimulado() throws IOException {
        String rutaAudio = "src/main/resources/audio";
        Biblioteca biblioteca = GestorBiblioteca.escanearCarpeta(rutaAudio);
        
        // Verificamos que se han leído canciones (sabemos que hay 12 archivos de Mozart)
        assertTrue(biblioteca.getNumeroCanciones() >= 12);

        // Guardar para inspección manual
        new BibliotecaXMLDAO().guardar(biblioteca, "biblioteca_real.xml");
        new BibliotecaJSONDAO().guardar(biblioteca, "biblioteca_real.json");
        
        // Simulación de la tabla de MP3App (buscando al menos una canción conocida)
        boolean encontrada = false;
        Object[] artistas = biblioteca.getArtistas().toArray();
        for (int i = 0; i < artistas.length; i++) {
            Artista artista = (Artista) artistas[i];
            if (artista.getNombre().contains("Mozart")) {
                encontrada = true;
                break;
            }
        }
        assertTrue(encontrada, "Debería haber canciones de Mozart en la biblioteca real");
    }

    private void createFakeMP3(Path path, String title, String artist, String album, String year) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(path.toFile())) {
            // Escribir 1024 bytes de "ruido" simulado
            fos.write(new byte[1024]);
            
            // Escribir los 128 bytes de ID3v1 al final
            byte[] tag = new byte[128];
            System.arraycopy("TAG".getBytes(StandardCharsets.ISO_8859_1), 0, tag, 0, 3);
            copyString(tag, title, 3, 30);
            copyString(tag, artist, 33, 30);
            copyString(tag, album, 63, 30);
            copyString(tag, year, 93, 4);
            
            fos.write(tag);
        }
    }

    private void copyString(byte[] target, String source, int offset, int maxLength) {
        byte[] bytes = source.getBytes(StandardCharsets.ISO_8859_1);
        int len = Math.min(bytes.length, maxLength);
        System.arraycopy(bytes, 0, target, offset, len);
    }
}
