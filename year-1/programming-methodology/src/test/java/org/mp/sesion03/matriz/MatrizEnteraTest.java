package org.mp.sesion03.matriz;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MatrizEnteraTest {

    private MatrizEntera m1, m2, m3;

    @BeforeEach
    public void setUp() {
        m1 = new MatrizEntera(2, 3);
        m1.setValor(0, 0, 1);
        m1.setValor(0, 1, 2);
        m1.setValor(0, 2, 3);
        m1.setValor(1, 0, 4);
        m1.setValor(1, 1, 5);
        m1.setValor(1, 2, 6);

        m2 = new MatrizEntera(3, 2);
        m2.setValor(0, 0, 7);
        m2.setValor(0, 1, 8);
        m2.setValor(1, 0, 10);
        m2.setValor(1, 1, 11);
        m2.setValor(2, 0, 8);
        m2.setValor(2, 1, 12);

        m3 = new MatrizEntera(2, 3);
        m3.setValor(0, 0, 1);
        m3.setValor(0, 1, 2);
        m3.setValor(0, 2, 3);
        m3.setValor(1, 0, 4);
        m3.setValor(1, 1, 5);
        m3.setValor(1, 2, 6);
    }

    @Test
    public void testSumar() {
        MatrizEntera sumado = (MatrizEntera) m1.sumar(m3);
        Integer[][] esperadoSuma = {{2, 4, 6}, {8, 10, 12}};
        assertArrayEquals(esperadoSuma, sumado.getMatriz());
    }

    @Test
    public void testMultiplicar() {
        MatrizEntera multiplicado = (MatrizEntera) m1.multiplicar(m2);
        Integer[][] esperadoMultiplicacion = {{51, 66}, {126, 159}};
        assertArrayEquals(esperadoMultiplicacion, multiplicado.getMatriz());
    }

    @Test
    public void testTransponer() {
        MatrizEntera transpuesta = (MatrizEntera) m1.transponer();
        Integer[][] esperadoTranspuesta = {{1, 4}, {2, 5}, {3, 6}};
        assertArrayEquals(esperadoTranspuesta, transpuesta.getMatriz());
    }

    @Test
    public void testSumarMatricesConTamanosDiferentes() {
        MatrizEntera matrizA = new MatrizEntera(2, 3);
        MatrizEntera matrizB = new MatrizEntera(3, 2);

        try {
            matrizA.sumar(matrizB);
            fail("Se esperaba una IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // Excepción esperada
        }
    }

    @Test
    public void testMultiplicarMatricesConTamanosIncompatibles() {
        MatrizEntera matrizA = new MatrizEntera(2, 3);
        MatrizEntera matrizB = new MatrizEntera(2, 4);

        try {
            matrizA.multiplicar(matrizB);
            fail("Se esperaba una IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // Excepción esperada
        }
    }

}