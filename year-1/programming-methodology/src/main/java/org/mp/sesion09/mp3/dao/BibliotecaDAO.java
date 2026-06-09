package org.mp.sesion09.mp3.dao;

import org.mp.sesion09.mp3.Biblioteca;
import java.io.IOException;

public interface BibliotecaDAO {
    void guardar(Biblioteca biblioteca, String ruta) throws IOException;
    Biblioteca cargar(String ruta) throws IOException;
}
