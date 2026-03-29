<div align="center">
  <h2>📂 Sesión 01 / Session 01</h2>
  <a href="#español">Español</a> &nbsp; &middot; &nbsp; <a href="#english">English</a>
</div>

---

<h2 id="español">Español</h2>

# Sesión 01: Programación Guiada por Pruebas (JUnit 5)

Este repositorio contiene la implementación de la primera sesión práctica de **Metodología de la Programación**,
enfocada en el desarrollo mediante **TDD** (Test-Driven Development).

## 📝 Enunciados y Requisitos de la Práctica

### 1. Corrección de la Clase `Mayor`

El reto consiste en identificar y subsanar errores de lógica en un método diseñado para encontrar el valor máximo de un
array de enteros.

* **Depuración**: Corregir fallos en la inicialización de variables (evitando el uso erróneo de `Integer.MAX_VALUE`) y
  en los límites de iteración del bucle.
* **Objetivo**: Asegurar que el método `elEnteroMayor` devuelva el entero más grande del array, superando los tests
  unitarios proporcionados.

### 2. Conversor de Temperatura (Fahrenheit a Celsius)

Desarrollo de una utilidad de conversión térmica que maneje con precisión escalas científicas y casos especiales.

* **Cálculo**: Implementar la fórmula $C = (F - 32) \times 5/9$ con un redondeo obligatorio a 2 decimales.
* **Validación de seguridad**: El sistema debe impedir conversiones por debajo del cero absoluto ($-459.67^\circ F$).
* **Excepción Personalizada**: Creación de `TemperaturaBajoCeroKelvinException` con el mensaje específico: *"¡La
  temperatura no puede estar por debajo de 0 K!"*.

### 3. Gestión de Listas de Reproducción

Implementación de un sistema para procesar y gestionar colecciones musicales siguiendo un diagrama de clases
estructurado.

* **Modelo `Cancion`**: Implementación de la interfaz `Comparable` para establecer un criterio de ordenación por
  duración (ascendente) y, en caso de empate, por título (alfabético).
* **Utilidad `CancionParser`**: Método estático para procesar cadenas CSV en formato
  `"CANCION;título;artista;duracion;genero"`, gestionando errores mediante `ParseException`.
* **Lógica de Lista**: Desarrollo de la clase `ListaDeReproduccion` con capacidad fija y ordenación de elementos
  mediante el algoritmo de la **Burbuja** (Bubble Sort).

<br>

---

<h2 id="english">English</h2>

# Session 01: Test-Driven Development (JUnit 5)

This repository contains the implementation of the first practical session of **Programming Methodology**, focusing on
development through **TDD** (Test-Driven Development).

## 📝 Assignment Prompts and Requirements

### 1. Correction of the `Mayor` Class

The challenge consists of identifying and correcting logic errors in a method designed to find the maximum value in an
integer array.

* **Debugging**: Fix variable initialization errors (avoiding the incorrect use of `Integer.MAX_VALUE`) and loop
  iteration boundaries.
* **Objective**: Ensure that the `elEnteroMayor` method returns the largest integer in the array, passing the provided
  unit tests.

### 2. Temperature Converter (Fahrenheit to Celsius)

Development of a thermal conversion utility that accurately handles scientific scales and special cases.

* **Calculation**: Implement the formula $C = (F - 32) \times 5/9$ with a mandatory rounding to 2 decimal places.
* **Safety Validation**: The system must prevent conversions below absolute zero ($-459.67^\circ F$).
* **Custom Exception**: Creation of `TemperaturaBajoCeroKelvinException` with the specific message: *"¡La temperatura no
  puede estar por debajo de 0 K!"*.

### 3. Playlist Management

Implementation of a system to process and manage musical collections following a structured class diagram.

* **`Cancion` Model**: Implementation of the `Comparable` interface to establish a sorting criterion by duration (
  ascending) and, in case of a tie, by title (alphabetical).
* **`CancionParser` Utility**: Static method to process CSV strings in the format
  `"CANCION;title;artist;duration;genre"`, managing errors via `ParseException`.
* **List Logic**: Development of the `ListaDeReproduccion` class with fixed capacity and sorting of elements using the *
  *Bubble Sort** algorithm.