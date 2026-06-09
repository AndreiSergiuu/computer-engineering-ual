package org.mp.sesion09.audio.efectos;

import org.mp.sesion09.audio.ArchivoWav;
import org.mp.sesion09.audio.CanalAudio;

import java.util.List;

/**
 * Efecto de audio que invierte las muestras de todos los canales,
 * reproduciendo el sonido al revés.
 *
 * <p>El algoritmo es un <em>reverse in-place</em> con dos punteros
 * (inicio y fin que se acercan al centro), por lo que trabaja en
 * O(n/2) intercambios sin memoria adicional.</p>
 *
 * <p>Se aplica independientemente a cada canal, lo que preserva
 * la sincronía en archivos estéreo.</p>
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 09-06-2026
 * @see EfectoAudio
 * @see EfectoVolumen
 */
public class EfectoInverso implements EfectoAudio {

    /**
     * Invierte el orden de las muestras en todos los canales del archivo WAV.
     *
     * @param wav archivo de audio cuyos canales serán invertidos.
     *            Los datos se modifican en el propio objeto (in-place).
     */
    @Override
    public void aplicar(ArchivoWav wav) {
        for (int c = 0; c < wav.getCanales().size(); c++) {
            invertirCanal(wav.getCanal(c));
        }
    }

    /**
     * Invierte el orden de las muestras de un canal individual
     * usando el algoritmo de dos punteros.
     *
     * @param canal canal de audio cuyas muestras se reordenarán.
     */
    private void invertirCanal(CanalAudio canal) {
        List<Short> muestras = canal.getMuestras();
        int izquierda = 0;
        int derecha   = muestras.size() - 1;

        while (izquierda < derecha) {
            Short temp              = muestras.get(izquierda);
            muestras.set(izquierda, muestras.get(derecha));
            muestras.set(derecha,   temp);
            izquierda++;
            derecha--;
        }
    }
}