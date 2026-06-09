package org.mp.sesion09.audio;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa un canal de audio (Mono, Izquierdo o Derecho).
 * Utiliza una lista de muestras de 16 bits (short).
 */
public class CanalAudio {

    private List<Short> muestras;

    public CanalAudio() {
        this.muestras = new ArrayList<>();
    }

    public CanalAudio(int initialCapacity) {
        this.muestras = new ArrayList<>(initialCapacity);
    }

    public List<Short> getMuestras() {
        return muestras;
    }

    public void addMuestra(short muestra) {
        muestras.add(muestra);
    }

    public int size() {
        return muestras.size();
    }
}
