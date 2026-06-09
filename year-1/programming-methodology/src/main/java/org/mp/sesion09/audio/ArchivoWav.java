package org.mp.sesion09.audio;

import java.util.ArrayList;
import java.util.List;

public class ArchivoWav {

    private CabeceraWav cabecera;
    private List<CanalAudio> canales;

    public ArchivoWav(CabeceraWav cabecera) {
        this.cabecera = cabecera;
        this.canales = new ArrayList<>();
        for (int i = 0; i < cabecera.numeroCanales; i++) {
            canales.add(new CanalAudio());
        }
    }

    public CabeceraWav getCabecera() {
        return cabecera;
    }

    public List<CanalAudio> getCanales() {
        return canales;
    }

    public CanalAudio getCanal(int index) {
        return canales.get(index);
    }

    /**
     * Actualiza el tamaño en la cabecera basándose en los datos actuales de los canales.
     */
    public void updateHeader() {
        int numSamples = canales.get(0).size();
        cabecera.subchunk2Size = numSamples * canales.size() * (cabecera.bitsPorMuestra / 8);
        cabecera.chunkSize = 36 + cabecera.subchunk2Size;
        cabecera.byteRate = cabecera.frecuenciaMuestreo * canales.size() * (cabecera.bitsPorMuestra / 8);
        cabecera.blockAlign = (short) (canales.size() * (cabecera.bitsPorMuestra / 8));
    }
}
