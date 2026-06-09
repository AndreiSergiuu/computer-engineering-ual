package org.mp.sesion09.mp3;

import java.util.ArrayList;
import java.util.List;

public class Album {
    private String titulo;
    private List<Cancion> canciones;

    public Album(String titulo) {
        this.titulo = titulo;
        this.canciones = new ArrayList<>();
    }

    public void anadirCancion(Cancion cancion) {
        canciones.add(cancion);
    }

    public String getTitulo() { return titulo; }
    public List<Cancion> getCanciones() { return canciones; }
}
