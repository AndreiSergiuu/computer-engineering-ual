package org.mp.sesion09.mp3;

import java.util.ArrayList;
import java.util.List;

public class Artista {
    private String nombre;
    private List<Album> albums;

    public Artista(String nombre) {
        this.nombre = nombre;
        this.albums = new ArrayList<>();
    }

    public String getNombre() { return nombre; }

    public void anadirAlbum(Album album) {
        albums.add(album);
    }

    public Album obtenerOCrearAlbum(String titulo) {
        for (int i = 0; i < albums.size(); i++) {
            Album album = albums.get(i);
            if (album.getTitulo().equals(titulo)) {
                return album;
            }
        }
        Album nuevoAlbum = new Album(titulo);
        albums.add(nuevoAlbum);
        return nuevoAlbum;
    }

    public List<Album> getAlbums() { return albums; }
}
