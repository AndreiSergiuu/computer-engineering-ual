<div align="center">
  <h2>📂 Sesión 04 / Session 04</h2>
  <a href="#español">Español</a> &nbsp; &middot; &nbsp; <a href="#english">English</a>
</div>

---

<h2 id="español">Español</h2>

# Sesión 04: Lista. Iterador. ArrayList. LinkedList.

Este repositorio contiene la implementación de la cuarta sesión práctica de Metodología de la Programación, centrada en
la interfaz List, las colecciones dinámicas y el patrón de diseño Iterador.

## 📝 Enunciados y Requisitos de la Práctica

### 1. Completar la clase ArrayList

Implementación de una lista dinámica genérica basada en arrays que extiende la clase AbstractList.

* **Gestión de Capacidad**: Desarrollo del método privado ensureCapacity() para asegurar que la capacidad de la lista
  crezca adecuadamente al agregar nuevos elementos.
* **Operaciones Básicas**: Implementación de métodos fundamentales como agregar elementos al final o en un índice (add),
  buscar ocurrencias (indexOf, lastIndexOf) y verificar contención (contains).
* **Eliminación Segura**: Implementación de la eliminación de la primera aparición de un objeto específico mediante
  remove(Object o).

### 2. Completar la clase LinkedList

Desarrollo de una estructura de lista enlazada asegurando la compatibilidad completa con los métodos de la interfaz
List.

* **Acceso y Modificación**: Programación de métodos para obtener (get), buscar (indexOf, lastIndexOf) y sustituir (set)
  nodos específicos de la lista.
* **Representación Textual**: Implementación del método toString() para imprimir adecuadamente la lista.
* **Patrón de Diseño**: Aplicación del patrón Iterator para acceder de forma segura y secuencial a los elementos de la
  colección sin exponer su representación interna.

### 3. Evaluación de Rendimiento

Análisis comparativo de la eficiencia temporal entre ArrayList y LinkedList frente a distintos tipos de operaciones.

* **Escenarios de Prueba**: Ejecución de 100 operaciones de inserción, acceso aleatorio y eliminación (tanto en extremos
  como en posiciones aleatorias) sobre colecciones de 10.000, 20.000 y 40.000 elementos.
* **Medición Precisa**: Uso del método System.nanoTime() para obtener mediciones precisas en nanosegundos.
* **Resultados Analíticos**: Impresión en consola de una tabla comparativa que muestra los tiempos de ejecución para
  contrastar el rendimiento de ambas estructuras de datos.

<br>

---

<h2 id="english">English</h2>

# Session 04: List. Iterator. ArrayList. LinkedList.

This repository contains the implementation of the fourth practical session of Programming Methodology, focusing on the
List interface, dynamic collections, and the Iterator design pattern.

## 📝 Assignment Prompts and Requirements

### 1. Completing the ArrayList Class

Implementation of an array-based generic dynamic list that extends the AbstractList class.

* **Capacity Management**: Development of the private ensureCapacity() method to ensure the list capacity grows
  appropriately when adding new elements.
* **Basic Operations**: Implementation of fundamental methods such as adding elements at the end or at an index (add),
  finding occurrences (indexOf, lastIndexOf), and verifying containment (contains).
* **Safe Removal**: Implementation of the deletion of the first appearance of a specific object via remove(Object o).

### 2. Completing the LinkedList Class

Development of a linked list structure ensuring full compatibility with the methods of the List interface.

* **Access and Modification**: Programming methods to retrieve (get), search (indexOf, lastIndexOf), and replace (set)
  specific nodes in the list.
* **Textual Representation**: Implementation of the toString() method to properly print the list.
* **Design Pattern**: Application of the Iterator pattern to safely and sequentially access the elements of the
  collection without exposing its internal representation.

### 3. Performance Evaluation

Comparative analysis of time efficiency between ArrayList and LinkedList across various types of operations.

* **Test Scenarios**: Execution of 100 operations of insertion, random access, and deletion (both at the ends and random
  positions) on collections of 10,000, 20,000, and 40,000 elements.
* **Precise Measurement**: Use of the System.nanoTime() method to obtain precise measurements in nanoseconds.
* **Analytical Results**: Console printing of a comparative table showing execution times to contrast the performance of
  both data structures.