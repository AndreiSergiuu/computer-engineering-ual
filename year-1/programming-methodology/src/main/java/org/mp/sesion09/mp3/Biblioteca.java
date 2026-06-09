package org.mp.sesion09.mp3;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Artista> artistas;

    public Biblioteca() {
        this.artistas = new ArrayList<>();
    }

    public void anadirCancion(Cancion cancion) {
        Artista artista = null;
        for (int i = 0; i < artistas.size(); i++) {
            Artista a = artistas.get(i);
            if (a.getNombre().equals(cancion.getArtista())) {
                artista = a;
                break;
            }
        }

        if (artista == null) {
            artista = new Artista(cancion.getArtista());
            artistas.add(artista);
        }

        Album album = artista.obtenerOCrearAlbum(cancion.getAlbum());
        album.anadirCancion(cancion);
    }

    public List<Artista> getArtistas() { return artistas; }

    public int getNumeroCanciones() {
        int contador = 0;
        for (int i = 0; i < artistas.size(); i++) {
            Artista artista = artistas.get(i);
            List<Album> listaAlbums = artista.getAlbums();
            for (int j = 0; j < listaAlbums.size(); j++) {
                Album album = listaAlbums.get(j);
                contador += album.getCanciones().size();
            }
        }
        return contador;
    }
}
