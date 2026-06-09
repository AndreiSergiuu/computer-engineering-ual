package org.mp.sesion09.audio.efectos;

import org.mp.sesion09.audio.ArchivoWav;
import org.mp.sesion09.audio.CanalAudio;

import java.util.List;

/**
 * Efecto de audio que escala la amplitud de todas las muestras por un
 * factor multiplicativo, modificando así el volumen percibido.
 *
 *
 * @author Andrei Sergiu Creata
 * @version 1.0
 * @since 09-06-2026
 * @see EfectoAudio
 * @see EfectoInverso
 */
public class EfectoVolumen implements EfectoAudio {

    /** Factor de escala de amplitud. */
    private final double factor;

    /**
     * Construye un efecto de volumen con el factor indicado.
     *
     * @param factor multiplicador de amplitud (0.0 = silencio, 1.0 = sin cambio).
     */
    public EfectoVolumen(double factor) {
        this.factor = factor;
    }

    /**
     * Aplica el ajuste de volumen a todos los canales del archivo WAV.
     * Cada muestra se escala y se recorta al rango PCM de 16 bits.
     *
     * @param wav archivo de audio cuyos canales serán modificados in-place.
     */
    @Override
    public void aplicar(ArchivoWav wav) {
        for (int c = 0; c < wav.getCanales().size(); c++) {
            escalarCanal(wav.getCanal(c));
        }
    }

    /**
     * Escala todas las muestras de un canal y las recorta para que
     * permanezcan en el rango válido de un {@code short} PCM de 16 bits.
     *
     * @param canal canal de audio cuyas muestras se escalarán.
     */
    private void escalarCanal(CanalAudio canal) {
        List<Short> muestras = canal.getMuestras();
        for (int i = 0; i < muestras.size(); i++) {
            long escalada = Math.round(muestras.get(i) * factor);
            // Recortar al rango [-32768, 32767] para evitar clipping
            if (escalada >  Short.MAX_VALUE) escalada =  Short.MAX_VALUE;
            if (escalada <  Short.MIN_VALUE) escalada =  Short.MIN_VALUE;
            muestras.set(i, (short) escalada);
        }
    }
}