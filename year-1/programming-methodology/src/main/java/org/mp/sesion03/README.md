<div align="center">
  <h2>📂 Sesión 03 / Session 03</h2>
  <a href="#español">Español</a> &nbsp; &middot; &nbsp; <a href="#english">English</a>
</div>

---

<h2 id="español">Español</h2>

# Sesión 03: Programación con Genéricos

Este repositorio contiene la implementación de la tercera sesión práctica de **Metodología de la Programación**,
centrada en el uso de parámetros de tipo para crear código flexible, reutilizable y seguro.

## 📝 Enunciados y Requisitos de la Práctica

### 1. La Clase Par y Gestión de Notas

Uso de genéricos para agrupar datos relacionados lógicamente sin recurrir a soluciones propensas a errores como el
casting explícito.

* **Clase Par<K, V>**: Implementación de una clase genérica con múltiples parámetros de tipo (K y V) para agrupar
  valores arbitrarios.
* **Sistema de Notas**: Aplicación práctica que gestiona un array de objetos Par<String, Double> para asociar IDs de
  alumnos con sus calificaciones.
* **Funcionalidades**: Métodos para agregar notas (evitando duplicados), obtener calificaciones individuales, calcular
  la media aritmética y listar el registro completo.

### 2. Implementación de Matrices Genéricas

Creación de una jerarquía de clases para realizar operaciones matemáticas con diferentes tipos numéricos.

* **Clase MatrizGenerica<T extends Number>**: Clase abstracta que define algoritmos de suma, multiplicación y
  transposición utilizando tipos delimitados.
* **Especialización**: Implementación de MatrizEntera y MatrizDouble para concretar operaciones sobre elementos
  específicos.
* **Lógica Aritmética**: Uso de métodos abstractos (sumarElementos, multiplicarElementos, ceroElemento) para delegar la
  computación básica a las clases hijas.

### 3. Mezcla Lineal de Arrays Ordenados

Desarrollo de métodos estáticos para combinar colecciones de datos manteniendo el orden.

* **Mezcla Genérica**: Implementación del método <T extends Comparable<T>> T[] mezclaLinealComparables para trabajar con
  cualquier objeto que implemente un criterio de ordenación.
* **Algoritmo**: Combinación eficiente de dos arrays de entrada en un único array de salida ordenado.

### 4. Evolución del Array Dinámico

Estudio comparativo de la gestión de colecciones antes y después de la introducción de los genéricos en Java 5.

* **Versión Object**: Implementación de ArrayDinamicoObjects utilizando la clase raíz Object, limitándose a
  características previas a Java 5.
* **Versión Genérica**: Creación de ArrayDinamico<T>, una estructura equivalente que garantiza la seguridad de tipos en
  tiempo de compilación y elimina la necesidad de conversiones de tipo manuales.

<br>

---

<h2 id="english">English</h2>

# Session 03: Generic Programming

This repository contains the implementation of the third practical session of Programming Methodology, focusing on using
type parameters to create flexible, reusable, and safe code.

## 📝 Assignment Prompts and Requirements

### 1. Par Class and Grade Management

Utilizing generics to group logically related data without resorting to error-prone solutions like explicit casting.

* **Par Class**: Implementation of a generic class with multiple type parameters (K and V) to group arbitrary values.
* **Notas System**: Practical application managing an array of Par<String, Double> objects to associate student IDs with
  their grades.
* **Features**: Methods to add grades (avoiding duplicates), retrieve individual grades, calculate the arithmetic mean,
  and list the complete record.

### 2. Generic Matrix Implementation

Creation of a class hierarchy to perform mathematical operations with different numerical types.

* **MatrizGenerica Class**: Abstract class defining algorithms for matrix addition, multiplication, and transposition
  using bounded types.
* **Specialization**: Implementation of MatrizEntera and MatrizDouble to specify operations on specific elements.
* **Arithmetic Logic**: Use of abstract methods (sumarElementos, multiplicarElementos, ceroElemento) to delegate basic
  computation to child classes.

### 3. Linear Merge of Sorted Arrays

Development of static methods to combine data collections while maintaining order.

* **Generic Merge**: Implementation of the <T extends Comparable<T>> T[] mezclaLinealComparables method to work with any
  object implementing a sorting criterion.
* **Algorithm**: Efficient combination of two input arrays into a single sorted output array.

### 4. Dynamic Array Evolution

Comparative study of collection management before and after the introduction of generics in Java 5.

* **Object Version**: Implementation of ArrayDinamicoObjects using the Object root class, limited to pre-Java 5
  features.
* **Generic Version**: Creation of ArrayDinamico<T>, an equivalent structure ensuring compile-time type safety and
  eliminating the need for manual type conversions.