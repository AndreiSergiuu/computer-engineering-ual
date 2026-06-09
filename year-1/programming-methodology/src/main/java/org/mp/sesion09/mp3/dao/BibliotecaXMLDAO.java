package org.mp.sesion09.mp3.dao;

import org.mp.sesion09.mp3.Album;
import org.mp.sesion09.mp3.Artista;
import org.mp.sesion09.mp3.Biblioteca;
import org.mp.sesion09.mp3.Cancion;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * Implementación de {@link BibliotecaDAO} que persiste la biblioteca
 * en formato XML usando la API DOM incluida en el JDK estándar.
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 09-06-2026
 * @see BibliotecaDAO
 * @see BibliotecaJSONDAO
 */
public class BibliotecaXMLDAO implements BibliotecaDAO {

    // -------------------------------------------------------------------------
    // ESCRITURA
    // -------------------------------------------------------------------------

    /**
     * Serializa la {@link Biblioteca} como un archivo XML con
     * indentación de 2 espacios.
     *
     * @param biblioteca objeto a persistir.
     * @param ruta       ruta del archivo de destino.
     * @throws IOException si no puede crearse el árbol DOM o escribirse
     *                     el archivo de salida.
     */
    @Override
    public void guardar(Biblioteca biblioteca, String ruta) throws IOException {
        try {
            // 1. Construir árbol DOM
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            Element raiz = doc.createElement("biblioteca");
            doc.appendChild(raiz);

            for (Artista artista : biblioteca.getArtistas()) {
                Element elArtista = doc.createElement("artista");
                elArtista.setAttribute("nombre", artista.getNombre());

                for (Album album : artista.getAlbums()) {
                    Element elAlbum = doc.createElement("album");
                    elAlbum.setAttribute("titulo", album.getTitulo());

                    for (Cancion c : album.getCanciones()) {
                        Element elCancion = doc.createElement("cancion");
                        elCancion.setAttribute("titulo",      c.getTitulo());
                        elCancion.setAttribute("artista",     c.getArtista());
                        elCancion.setAttribute("album",       c.getAlbum());
                        elCancion.setAttribute("anio",        c.getAnio());
                        elCancion.setAttribute("rutaArchivo", c.getRutaArchivo());
                        elAlbum.appendChild(elCancion);
                    }
                    elArtista.appendChild(elAlbum);
                }
                raiz.appendChild(elArtista);
            }

            // 2. Transformar DOM a bytes con indentación
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            try (FileOutputStream fos = new FileOutputStream(ruta)) {
                transformer.transform(new DOMSource(doc), new StreamResult(fos));
            }

        } catch (ParserConfigurationException | TransformerException e) {
            throw new IOException("Error al generar el XML: " + e.getMessage(), e);
        }
    }

    // -------------------------------------------------------------------------
    // LECTURA
    // -------------------------------------------------------------------------

    /**
     * Deserializa una {@link Biblioteca} desde un archivo XML generado
     * por {@link #guardar}.
     *
     * @param ruta ruta del archivo XML a leer.
     * @return biblioteca reconstruida.
     * @throws IOException si el archivo no existe, no es XML válido
     *                     o no puede parsearse.
     */
    @Override
    public Biblioteca cargar(String ruta) throws IOException {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(ruta);
            doc.getDocumentElement().normalize();

            Biblioteca biblioteca = new Biblioteca();

            NodeList artistas = doc.getElementsByTagName("artista");
            for (int a = 0; a < artistas.getLength(); a++) {
                Element elArtista = (Element) artistas.item(a);

                NodeList albums = elArtista.getElementsByTagName("album");
                for (int al = 0; al < albums.getLength(); al++) {
                    Element elAlbum = (Element) albums.item(al);

                    NodeList canciones = elAlbum.getElementsByTagName("cancion");
                    for (int s = 0; s < canciones.getLength(); s++) {
                        Element el = (Element) canciones.item(s);

                        Cancion cancion = new Cancion(
                                el.getAttribute("titulo"),
                                el.getAttribute("artista"),
                                el.getAttribute("album"),
                                el.getAttribute("anio"),
                                el.getAttribute("rutaArchivo")
                        );
                        biblioteca.anadirCancion(cancion);
                    }
                }
            }

            return biblioteca;

        } catch (ParserConfigurationException | SAXException e) {
            throw new IOException("Error al parsear el XML: " + e.getMessage(), e);
        }
    }
}