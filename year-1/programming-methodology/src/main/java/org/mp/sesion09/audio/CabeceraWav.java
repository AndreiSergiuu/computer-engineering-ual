package org.mp.sesion09.audio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Representa la cabecera de 44 bytes de un archivo WAV (RIFF).
 */
public class CabeceraWav {

    public String chunkID = "RIFF";
    public int chunkSize;
    public String format = "WAVE";
    public String subchunk1ID = "fmt ";
    public int subchunk1Size = 16;
    public short audioFormat = 1; // PCM
    public short numeroCanales;
    public int frecuenciaMuestreo;
    public int byteRate;
    public short blockAlign;
    public short bitsPorMuestra;
    public String subchunk2ID = "data";
    public int subchunk2Size;

    public void leer(InputStream is) throws IOException {
        byte[] header = new byte[44];
        if (is.read(header) != 44) throw new IOException("Cabecera WAV incompleta");

        ByteBuffer bb = ByteBuffer.wrap(header).order(ByteOrder.LITTLE_ENDIAN);

        byte[] b4 = new byte[4];
        bb.get(b4); chunkID = new String(b4);
        chunkSize = bb.getInt();
        bb.get(b4); format = new String(b4);
        bb.get(b4); subchunk1ID = new String(b4);
        subchunk1Size = bb.getInt();
        audioFormat = bb.getShort();
        numeroCanales = bb.getShort();
        frecuenciaMuestreo = bb.getInt();
        byteRate = bb.getInt();
        blockAlign = bb.getShort();
        bitsPorMuestra = bb.getShort();
        bb.get(b4); subchunk2ID = new String(b4);
        subchunk2Size = bb.getInt();
    }

    public void escribir(OutputStream os) throws IOException {
        ByteBuffer bb = ByteBuffer.allocate(44).order(ByteOrder.LITTLE_ENDIAN);

        bb.put(chunkID.getBytes());
        bb.putInt(chunkSize);
        bb.put(format.getBytes());
        bb.put(subchunk1ID.getBytes());
        bb.putInt(subchunk1Size);
        bb.putShort(audioFormat);
        bb.putShort(numeroCanales);
        bb.putInt(frecuenciaMuestreo);
        bb.putInt(byteRate);
        bb.putShort(blockAlign);
        bb.putShort(bitsPorMuestra);
        bb.put(subchunk2ID.getBytes());
        bb.putInt(subchunk2Size);

        os.write(bb.array());
    }
}
