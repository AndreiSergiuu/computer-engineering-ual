package org.mp.sesion03.mezclalineal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MezclaLinealTest {

    @Test
    public void testMezclaLinealInt_CasoBase() {
        int[] arr1 = {1, 3, 5, 7, 9};
        int[] arr2 = {2, 4, 6, 8, 10};
        int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertArrayEquals(expected, MezclaLineal.mezclaLinealInt(arr1, arr2));
    }

    @Test
    public void testMezclaLinealInt_PrimerArrayVacio() {
        int[] arr1 = {};
        int[] arr2 = {2, 4, 6};
        int[] expected = {2, 4, 6};
        assertArrayEquals(expected, MezclaLineal.mezclaLinealInt(arr1, arr2));
    }

    @Test
    public void testMezclaLinealInt_SegundoArrayVacio() {
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {};
        int[] expected = {1, 3, 5};
        assertArrayEquals(expected, MezclaLineal.mezclaLinealInt(arr1, arr2));
    }

    @Test
    public void testMezclaLinealInt_AmbosArraysVacios() {
        int[] arr1 = {};
        int[] arr2 = {};
        int[] expected = {};
        assertArrayEquals(expected, MezclaLineal.mezclaLinealInt(arr1, arr2));
    }

    @Test
    public void testMezclaLinealInt_DiferentesLongitudes() {
        int[] arr1 = {1, 8, 15};
        int[] arr2 = {2, 3, 5, 10, 20};
        int[] expected = {1, 2, 3, 5, 8, 10, 15, 20};
        assertArrayEquals(expected, MezclaLineal.mezclaLinealInt(arr1, arr2));
    }

    @Test
    public void testMezclaLinealInt_ConDuplicados() {
        int[] arr1 = {1, 5, 5, 10};
        int[] arr2 = {2, 5, 12};
        int[] expected = {1, 2, 5, 5, 5, 10, 12};
        assertArrayEquals(expected, MezclaLineal.mezclaLinealInt(arr1, arr2));
    }

    @Test
    public void testMezclaLinealInt_ConNegativos() {
        int[] arr1 = {-10, -5, 0, 5};
        int[] arr2 = {-8, 0, 6, 12};
        int[] expected = {-10, -8, -5, 0, 0, 5, 6, 12};
        assertArrayEquals(expected, MezclaLineal.mezclaLinealInt(arr1, arr2));
    }

    @Test
    public void testMezclaLinealGenericos_CasoBase() {
        String[] arr1 = {"antonio", "carlos", "elena", "gema", "ivan"};
        String[] arr2 = {"belen", "david", "fernando", "hector", "julia"};
        String[] expected = {"antonio", "belen", "carlos", "david", "elena", "fernando", "gema", "hector", "ivan", "julia"};
        assertArrayEquals(expected, MezclaLineal.mezclaLinealGenericos(arr1, arr2));
    }

    @Test
    public void testMezclaLinealGenericos_PrimerArrayVacio() {
        String[] arr1 = {};
        String[] arr2 = {"belen", "david", "fernando"};
        String[] expected = {"belen", "david", "fernando"};
        assertArrayEquals(expected, MezclaLineal.mezclaLinealGenericos(arr1, arr2));
    }

    @Test
    public void testMezclaLinealGenericos_SegundoArrayVacio() {
        String[] arr1 = {"antonio", "carlos", "elena"};
        String[] arr2 = {};
        String[] expected = {"antonio", "carlos", "elena"};
        assertArrayEquals(expected, MezclaLineal.mezclaLinealGenericos(arr1, arr2));
    }

    @Test
    public void testMezclaLinealGenericos_AmbosArraysVacios() {
        String[] arr1 = {};
        String[] arr2 = {};
        String[] expected = {};
        assertArrayEquals(expected, MezclaLineal.mezclaLinealGenericos(arr1, arr2));
    }

    @Test
    public void testMezclaLinealGenericos_DiferentesLongitudes() {
        String[] arr1 = {"a", "d", "z"};
        String[] arr2 = {"b", "c", "x", "y"};
        String[] expected = {"a", "b", "c", "d", "x", "y", "z"};
        assertArrayEquals(expected, MezclaLineal.mezclaLinealGenericos(arr1, arr2));
    }

    @Test
    public void testMezclaLinealGenericos_ConEnteros() {
        Integer[] arr1 = {1, 8, 15};
        Integer[] arr2 = {2, 3, 5, 10, 20};
        Integer[] expected = {1, 2, 3, 5, 8, 10, 15, 20};
        assertArrayEquals(expected, MezclaLineal.mezclaLinealGenericos(arr1, arr2));
    }

}