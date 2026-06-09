package org.mp.sesion09.mp3;

public class Cancion {
    private String titulo;
    private String artista;
    private String album;
    private String anio;
    private String rutaArchivo;

    public Cancion(String titulo, String artista, String album, String anio, String rutaArchivo) {
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.anio = anio;
        this.rutaArchivo = rutaArchivo;
    }

    public String getTitulo() { return titulo; }
    public String getArtista() { return artista; }
    public String getAlbum() { return album; }
    public String getAnio() { return anio; }
    public String getRutaArchivo() { return rutaArchivo; }

    @Override
    public String toString() {
        return "Cancion{titulo='" + titulo + "', artista='" + artista + "'}";
    }
}
