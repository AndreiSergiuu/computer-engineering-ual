<div align="center">
  <h2>📂 Sesión 02 / Session 02 ✅</h2>
  <a href="#español">Español</a> &nbsp; &middot; &nbsp; <a href="#english">English</a>
</div>

---

<h2 id="español">Español</h2>

# Sesión 02: Documentación (Javadoc) y Gestión de Proyectos (Maven)

Esta sesión se centra en la profesionalización del desarrollo mediante la generación de documentación automática y el
uso de herramientas de gestión de ciclo de vida de proyectos Java.

## 📝 Enunciados y Requisitos de la Práctica

### 1. Documentación con Javadoc

El objetivo es estandarizar la documentación del código fuente para mejorar la mantenibilidad y legibilidad del
software.

* **Uso de Tags**: Aplicación de etiquetas como `@param`, `@return`, `@throws` y `@see` para describir detalladamente
  cada método y clase.
* **Automatización**: Uso de herramientas como **JAutodoc** para agilizar la creación de comentarios y exportación de la
  documentación a la carpeta `doc`.
* **Documentación Retroactiva**: Documentar los ejercicios de la primera práctica (Mayor, FahrenheitACelsius y Gestión
  de álbumes).

### 2. Gestión de Proyectos con Maven

Introducción a **Maven** para automatizar la construcción, gestión de dependencias y generación de informes del
proyecto.

* **Configuración (pom.xml)**: Definición de la estructura, dependencias de JUnit 5 y configuración del compilador para
  Java 21.
* **Ciclo de Vida**: Uso de las fases estándar de Maven para garantizar la reproducibilidad de las construcciones en
  cualquier entorno.
* **Generación de API**: Uso del plugin `maven-javadoc-plugin` para generar la documentación técnica en la ruta
  `target/site/apidocs`.

### 3. Gestión de Álbumes Musicales

Implementación de un sistema para procesar información de música basándose en un diagrama de clases estructurado.

* **Modelo `Album`**: Implementación de la interfaz `Comparable` para ordenar por año (ascendente) y título (
  alfabéticamente).
* **Excepciones**: Creación de la clase `MiParseadoException` para gestionar errores específicos durante la lectura de
  datos.
* **Utilidad `AlbumParser`**: Método estático para procesar cadenas complejas con formato
  `"ALBUM;titulo;artista;año;CANCION;..."`.

<br>

---

<h2 id="english">English</h2>

# Session 02: Documentation (Javadoc) and Project Management (Maven)

This session focuses on development professionalization through automatic documentation generation and the use of Java
project lifecycle management tools.

## 📝 Assignment Prompts and Requirements

### 1. Documentation with Javadoc

The goal is to standardize source code documentation to improve software maintainability and readability.

* **Tag Usage**: Application of tags such as `@param`, `@return`, `@throws`, and `@see` to provide detailed descriptions
  for each method and class.
* **Automation**: Use of tools like **JAutodoc** to streamline comment creation and exporting documentation to the `doc`
  folder.
* **Retroactive Documentation**: Documenting exercises from the first practical session (Mayor, FahrenheitACelsius, and
  Album Management).

### 2. Project Management with Maven

Introduction to **Maven** to automate construction, dependency management, and project report generation.

* **Configuration (pom.xml)**: Defining structure, JUnit 5 dependencies, and compiler settings for Java 21.
* **Lifecycle**: Use of standard Maven phases to ensure build reproducibility across any environment.
* **API Generation**: Using the `maven-javadoc-plugin` to generate technical documentation in the `target/site/apidocs`
  path.

### 3. Musical Album Management

Implementation of a system to process music information based on a structured class diagram.

* **`Album` Model**: Implementation of the `Comparable` interface to sort by year (ascending) and title (
  alphabetically).
* **Exceptions**: Creation of the `MiParseadoException` class to manage specific errors during the data reading process.
* **`AlbumParser` Utility**: Static method to process complex strings formatted as
  `"ALBUM;title;artist;year;CANCION;..."`.