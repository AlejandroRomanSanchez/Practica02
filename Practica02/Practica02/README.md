# Práctica 2: Listas
Nombre del alumno: Alejandro Román Sánchez
Número de cuenta: 408093413

# Descripción.
En esta práctica se consideran dos implementaciones personalizadas de listas; a saber, listas simplemente ligadas y
listas doblemente ligadas. Posteriormente se comparan sus tiempos de ejecución con la de la implementación
ArrayList de Java,

## Estructura del proyecto
La estructura del proteco es la siguiente:

1. Interfaz TDAList: Se consideran los métodos que deben tener las implementaciones de nuestras listas.

2. La clase SimpleLinkedList: En esta clase se tiene la implementación de las listas simplemente ligadas.

3. La clase DoubleLinked List: En esta clase se tiene la implementación de las listas doblemente ligadas.

4. La clase Prueba: En esta clase se muestran las pruebas comparativas que se muestran en el PDF

5. Un archivo PDF: En este archivo se tiene la tabla comparativa que se obtuvieron a partir de la clase Prueba

## Instrucciones de compilación y ejecución.

Las siguientes instrucciones deben de escribirse desde la dirección en el que se encuentran todos los archivos
de esta práctica.

Para compilar interfaz TDAList debemos escribir los siguiente:
javac TDAList.java

Si queremos hacer uso de la clase SimpleLinkedList, primero debemos compilar el archivo TDAList.java.
Posteriormente debemos escribir lo siguiente:
javac SimpleLinkedList.java

Si queremos hacer uso de la clase DoubleLinkedList, primero debemos de compilar el arhivo TDAList.java.
Posteriormente, debesmo escribir lo siguiente:
javac DoubleLinkedList.java

Finalmente, si queremos consultar las pruebas comparativa hechas para esta práctica, debemos primero compilar
los archivos TDAList.java, SimpleLinkedList.java y DoubleLinkedList.java. Posteriormente, debemos escribir lo
siguiente:
javac Prueba.java+
Y luego,
java Prueba