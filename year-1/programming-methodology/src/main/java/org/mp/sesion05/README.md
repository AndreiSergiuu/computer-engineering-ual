<div align="center">
  <h2>📂 Sesión 05 / Session 05 </h2>
  <a href="#español">Español</a> &nbsp; &middot; &nbsp; <a href="#english">English</a>
</div>

---

<h2 id="español">Español</h2>

# Sesión 05: Pilas y Colas

Este repositorio contiene la implementación de la quinta sesión práctica, centrada en el estudio, diseño y evaluación de
rendimiento de las estructuras de datos **Pilas (Stacks)** y **Colas (Queues)**.

## 📝 Enunciados y Requisitos de la Práctica

### 1. Implementación de Pilas (Stack)

A partir de una interfaz genérica `Stack<E>`, se han desarrollado tres implementaciones basadas en distintas estructuras
subyacentes:

* **ArrayStack**: Basada en un array de tipo genérico y un entero para gestionar la cima de la pila.
* **NodeStack**: Utiliza una estructura de nodos enlazados donde un nodo cima apunta al elemento superior.
* **LinkedListStack**: Implementada mediante el **Patrón Adaptador**, utilizando una `LinkedList` propia para gestionar
  los elementos.

### 2. Implementación de Colas (Queue)

Desarrollo de la interfaz `Queue<E>` y sus respectivas variantes para la gestión de elementos bajo la filosofía FIFO (
First-In, First-Out):

* **ArrayQueue**: Implementación basada en dos enteros y un array circular dinámico para optimizar el espacio.
* **NodeQueue**: Basada en una estructura de nodos que mantiene referencias tanto a la cabeza (`head`) como a la cola (
  `tail`).
* **LinkedListQueue**: Adaptación de la clase `java.util.LinkedList` de Java para funcionar como una cola eficiente.

### 3. Evaluación de Rendimiento

Pruebas experimentales para medir el tiempo de ejecución de las operaciones básicas.

<br>

---

<h2 id="english">English</h2>

# Session 05: Stacks and Queues

This repository contains the implementation of the fifth practical session, focused on the study, design, and
performance evaluation of **Stacks** and **Queues** as data structures.

## 📝 Assignment Prompts and Requirements

### 1. Stack Implementation

Based on a generic `Stack<E>` interface, three different implementations have been developed using various underlying
structures:

* **ArrayStack**: Based on a generic array and an integer to manage the top of the stack.
* **NodeStack**: Uses a linked node structure with a specific top node pointing to the upper element.
* **LinkedListStack**: Implemented using the **Adapter Pattern**, utilizing a custom `LinkedList` to manage elements.

### 2. Queue Implementation

Development of the `Queue<E>` interface and its respective variants for element management under the FIFO (First-In,
First-Out) philosophy:

* **ArrayQueue**: Implementation based on two integers and a dynamic circular array to optimize space.
* **NodeQueue**: Based on a node structure maintaining references to both the head and the tail.
* **LinkedListQueue**: Adaptation of the `java.util.LinkedList` class from Java to function as an efficient queue.

### 3. Performance Evaluation

Experimental testing to measure the execution time of basic operations.