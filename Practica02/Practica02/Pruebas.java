import java.util.ArrayList;
import java.util.Collections;

/**
 * En esta clase se tienen las pruebas para la creación de la tabla comparativa  de las 
 * implementaciones personalizada de SimpleLinkedList, DoubleLinkedList junto con la 
 * implementación ArrayList de Java
 * @author Alejandro Román Sánchez
 * Número de cuenta: 408093413
 * @since 21/sep/2022
 * @since Estrucutras de datos 2023-1
 */
public class Pruebas<T> {

    /**
     * Nos permite comparar el contenido de un ArrayList de Java con el contenido
     * de la lista doble.
     * @param arrayList el ArrayList cuyo contenido compararemos
     * @param listaDoble la lista doble cuyo contenido compararemos
     * @return Si tanto el ArrayList como la lista doble tienen los mismos elementos
     * en los mismos índices, devuelve true; en caso contrario, devuelve false
     */
    public boolean compara(ArrayList<T> arrayList, DoubleLinkedList<T> listaDoble) {
	int longitudArrayList = arrayList.size();
	int longitudListaDoble = listaDoble.size();
	boolean verificador = true;
	T elementoDeListaDoble;

	// Si la longitud de ambos es igual
	if (longitudArrayList == longitudListaDoble) {
	    for (int i = 0; i < arrayList.size(); i++) {
		elementoDeListaDoble = listaDoble.get(i);
		if (arrayList.get(i).equals(elementoDeListaDoble)) {
		} else {
		    // Si existe algún índice con contenidos distintos, paramos
		    verificador = false; 
		    break;
		}
	    }
	} else { // Si la longitud ambos es distinto, automáticamente se devuelve false
	    return false;
	}
	return verificador;
    }

    /**
     * Nos permite comparar el contenido de un ArrayList de Java con el contenido de una
     * lista simple.
     * @param arrayList El ArrayList a comparar
     * @param listaSimple La lista simple a comparar
     * @return Si tienen los mismos elementos en cada índice, devuelve true; en caso contrario, 
     * false
     */
    public boolean compara2(ArrayList<T> arrayList, SimpleLinkedList<T> listaSimple) {
	int longitudArrayList = arrayList.size();
	int longitudListaSimple = listaSimple.size();
	boolean verificador = true;
	T elementoDeListaSimple;
	
	if (longitudArrayList == longitudListaSimple) { // Si tiene longitudes distintas
	    for (int i = 0; i < arrayList.size(); i++) { // Comparamos cada índice
		elementoDeListaSimple = listaSimple.get(i);
		if (arrayList.get(i).equals(elementoDeListaSimple)) {
		} else { // Si existe un índice donde no haya coincidencia, paramos
		    verificador = false;
		    break;
		}
	    }
	} else { // Si ambos tienen longitudes distintas, paramos.
	    return false;
	}
	return verificador;
    }

    /**
     * Se imprimen los elemento de una lista simple
     * @param listaSimple La lista simple cuyo contenido queremos imprimir
     */
    public void imprimeListaSimple(SimpleLinkedList<T> listaSimple) {
	// Recorremos a la lista simple
	for(int i = 0; i < listaSimple.size(); i++) {
	    System.out.print(listaSimple.get(i) + " ");
	}
	System.out.println();
    }

    /**
     * Devuelve el elemento que está en un índice central.
     * @param i El índice central del elemento a devolver. Si se tiene una cantidad impar
     * de elementos, entonces el elemento que está en el centro tomará el índice central 0
     * @param arrayList El ArrayList de Java del cual buscar el elemento con el índice central
     * @return El elemento que se encuentra en el índice central ingresado
     */
    public T obtenerPosicionDesdeCentro(int i, ArrayList<T> arrayList) {
	int medio = arrayList.size() / 2; // La posición central
	if (arrayList.size() % 2 == 0) { // Si el tamaño del ArrayList es par
	    if (medio - 1 - i < 0) { // Si el índice central está fuera del rango
		return null;
	    }
	    return arrayList.get(medio - 1 - i); // Si dicho índice está en el rango
	} else { // Si el tamaño del ArrayList es impar
	    if(((int) medio) - i < 0) { // Si el índice central no está en el rango
		return null;
	    }
	    return arrayList.get(((int)medio) - i); // si dicho índice está en el rango
	}	
    }	    
    
    public static void main(String[] args) {
	long inicio; // En esta variable almacenamos el inicio de la prueba
	long fin; // en esta variable almacenamos el fin de la prueba
	int[] arregloEnteros = {78, 90, 34, -6, 79}; // Sirve para obtener listas no vacías
	Pruebas objetoPrueba = new Pruebas(); 
	
	// 1. Realiza la inserción al final de 1000 elementos
	System.out.println("\n1. Realiza la inserción al final de 1000 elementos: ");
	ArrayList<Integer> arrayListEnteros = new ArrayList<>(); 

	// Ingresamos los elementos de arregloEnteros en arrayListEnteros
	for(int i = 0; i < arregloEnteros.length; i++) {
	    arrayListEnteros.add(i, arregloEnteros[i]);
	}
		
	SimpleLinkedList<Integer> listaSimpleEnteros = new SimpleLinkedList<>();

	// Ingresamos los elementos de arregloEnteros en listaSimpleEnteros
	for (int i = 0; i < arregloEnteros.length; i++) {
	    listaSimpleEnteros.add(i, arregloEnteros[i]);
	}
	
	DoubleLinkedList<Integer> listaDobleEnteros = new DoubleLinkedList<>();

	// Ingresamos los elementos de arregloEnteros en listaDobleEnteros
	for (int i = 0; i < arregloEnteros.length; i++) {
	    listaDobleEnteros.add(i, arregloEnteros[i]);
	}

	// Inserción 1000 elementos al final de arrayListEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	for(int i = 5; i < 1005; i++) {
	    arrayListEnteros.add(i, i);	
	}
	fin = System.currentTimeMillis(); // Final de la prueba
	System.out.println("El tiempo de inserción para arrayListEnteros es: " + (fin - inicio));

	// Inserción de 1000 elementos al final de listaSimpleEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	for(int i = 5; i < 1005; i++) {
	    listaSimpleEnteros.add(i, i);	
	}
	fin = System.currentTimeMillis(); // Final de la prueba
	System.out.println("El tiempo de inserción para listaSimpleEnteros es: " + (fin - inicio));

	// Inserción de 1000 elementos al final de listaDobleEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	for(int i = 5; i < 1005; i++) {
	    listaDobleEnteros.add(i, i);
	}
	fin = System.currentTimeMillis(); // Final de la prueba
	System.out.println("El tiempo de inserción para listaDobleEnteros es: " + (fin - inicio));


	System.out.println("¿arrayListEnteros y listaSimpleEnteros tienen los mismos elementos en los "
			   + "mismos índices? " + objetoPrueba.compara2(arrayListEnteros, listaSimpleEnteros));

	System.out.println("¿arrayListEnteros y listaDobleEnteros tienen los mismos elementos en los "
			   + "mismos índices? " + objetoPrueba.compara(arrayListEnteros, listaDobleEnteros));
	
	// Realiza la inserción al final de 100000 elementos
	System.out.println("\n2. Realiza la inserción al final de 100000 elementos: ");
	arrayListEnteros.clear(); // Borramos el contenido de arrayListEnteros

	// Volvemos a ingresar los elementos de arregloEnteros en arrayListEnteros
	for(int i = 0; i < arregloEnteros.length; i++) { 
	    arrayListEnteros.add(i, arregloEnteros[i]);
	}

	listaSimpleEnteros.clear(); // Borramos el contenido de listaSimpleEnteros

	// Volvemos a ingresar los elementos de arregloEnteros en arrayListEnteros
	for(int i = 0; i < arregloEnteros.length; i++) {
	    listaSimpleEnteros.add(i, arregloEnteros[i]);
	}

	listaDobleEnteros.clear(); // Borramos el contenido de listaDobleEnteros

	// Volvemos a ingresar los elementos de arregloEnteros en listaDobleEnteros
	for (int i = 0; i < arregloEnteros.length; i++) {
	    listaDobleEnteros.add(i, arregloEnteros[i]);
	}

	// Inserción al final de 100000 elementos para arrayListEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	for(int i = 5; i < 100005; i++) {
	    arrayListEnteros.add(i, i);
	}
	fin = System.currentTimeMillis(); // Final de la prueba 
	System.out.println("El tiempo de inserción para arrayListEnteros: " + (fin - inicio));

	// Inserción al final de 100000 elementos para listaSimpleEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	for(int i = 5; i < 100005; i++) {
	    listaSimpleEnteros.add(i, i);
	}
	fin = System.currentTimeMillis(); // final de la prueba
	System.out.println("El tiempo de inserción para listaSimpleEnteros es: " + (fin - inicio));

	// Inserción al final de 100000 elementos para listaDobleEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	for(int i = 5; i < 100005; i++) {
	    listaDobleEnteros.add(i, i);
	}
	fin = System.currentTimeMillis(); // Final de la prueba
	System.out.println("El tiempo de inserción para listaDobleEnteros es: " + (fin - inicio));

	System.out.println("¿arrayListEnteros y listaSimpleEnteros tienen los mismos elementos en los "
			   + "mismos índices? " + objetoPrueba.compara2(arrayListEnteros, listaSimpleEnteros));

	System.out.println("¿arrayListEnteros y listaDobleEnteros tienen los mismos elementos en los "
			   + "mismos índices? " + objetoPrueba.compara(arrayListEnteros, listaDobleEnteros));

	// Realiza la inserción al principio de 1000 elementos
	System.out.println("\n3. La inserción de 1000 elementos al principio.");
	
	arrayListEnteros.clear(); // Borramos el contenido de arrayListEnteros

	// Volvemos a ingresar los elementos de arregloEnteros
	for(int i = 0; i < arregloEnteros.length; i++) { 
	    arrayListEnteros.add(i, arregloEnteros[i]);
	}

	listaSimpleEnteros.clear(); // Borramos los elementos de listaSimpleEnteros

	// Volvemos a ingresar los elementos de arregloEnteros
	for(int i = 0; i < arregloEnteros.length; i++) {
	    listaSimpleEnteros.add(i, arregloEnteros[i]);
	}

	
	listaDobleEnteros.clear(); // Borramos el contenido de listaDobleEnteros

	// Volvemos a ingresar los elementos de arregloEnteros
       	for (int i = 0; i < arregloEnteros.length; i++) {
	    listaDobleEnteros.add(i, arregloEnteros[i]);
	}

	// Inserción al principio de 1000 elementos para arrayListEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	for(int i = 0; i < 1000 ; i++) {
	    arrayListEnteros.add(0, i);
	}
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejeución para arrayListEnteros es: " + (fin - inicio));

	// Inserción al principio de 1000 elementos para listaSimpleEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	for(int i = 0; i < 1000; i++) {
	    listaSimpleEnteros.add(0, i);
	}
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para listaSimpleEnteros es: " + (fin - inicio));

	// Inserción al principio de 1000 elementos para listaDobleEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	for(int i = 0; i < 1000; i++) {
	    listaDobleEnteros.add(0, i);
	}
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para lsitaDobleEnteros es: " + (fin - inicio));

	System.out.println("¿arrayListEnteros y listaSimpleEnteros tienen los mismos elementos? " +
			   objetoPrueba.compara2(arrayListEnteros, listaSimpleEnteros));

	System.out.println("¿arrayListEnteros y listaDobleEnteros tienen los mismos elementos? " +
			   objetoPrueba.compara(arrayListEnteros, listaDobleEnteros));

	// Realiza la inserción al principio de 100000 elementos
	System.out.println("\n4. La inserción de 100000 elementos al principio.");

	arrayListEnteros.clear(); // Borramos el contenido de arrayListEnteros

	// vovlemos a ingresar los elementos de arregloEnteros
	for(int i = 0; i < arregloEnteros.length; i++) {
	    arrayListEnteros.add(i, arregloEnteros[i]);
	}

	listaSimpleEnteros.clear(); // Borramos el contenido de listaSimpleEnteros

	// Volvemos a ingresa los elementos de arregloEnteros
	for(int i = 0; i < arregloEnteros.length; i++) {
	    listaSimpleEnteros.add(i, arregloEnteros[i]);
	}
	
	listaDobleEnteros.clear(); // Borramos el contenido de listaDobleEnteros

	// Volvemos a ingresar los elementos de arregloEnteros
	for (int i = 0; i < arregloEnteros.length; i++) {
	    listaDobleEnteros.add(i, arregloEnteros[i]);
	}

	// Inserción al principio de 100000 elementos para arrayListEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	for(int i = 0; i < 100000 ; i++) {
	    arrayListEnteros.add(0, i);
	}
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejeución para arrayListEnteros es: " + (fin - inicio));

	// Inserción de 100000 elementos para listaSimpleEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	for(int i = 0; i < 100000; i++) {
	    listaSimpleEnteros.add(0, i);
	}
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para listaSimpleEnteros es: " + (fin - inicio));

	// Inserción de 100000 elementos para listaDobleEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	for(int i = 0; i < 100000; i++) {
	    listaDobleEnteros.add(0, i);
	}
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para listaDobleEnteros es: " + (fin - inicio));

	System.out.println("¿arrayListEnteros y listaSimpleEnteros tienen los mismos elementos? " +
			   objetoPrueba.compara2(arrayListEnteros, listaSimpleEnteros));

	System.out.println("¿arrayListEnteros y listaDobleEnteros tienen los mismos elementos? " +
			   objetoPrueba.compara(arrayListEnteros, listaDobleEnteros));

	//Realiza la inserción en una posición aleatoria de 1000 elementos
	System.out.println("\n5. Realiza la inserción en una posición aleatoria de 1000 elementos.");

	arrayListEnteros.clear(); // Borramos el contenido de arrayListEnteros
	// Volvemos a ingresar los elemento de arregloEnteros
	for(int i = 0; i < arregloEnteros.length; i++) {
	    arrayListEnteros.add(i, arregloEnteros[i]);
	}

	listaSimpleEnteros.clear(); // Borramos el contenido de listaSimpleEnteros
	// Volvemos a ingresar los elementos de arregloEnteros
	for(int i = 0; i < arregloEnteros.length; i++) {
	    listaSimpleEnteros.add(i, arregloEnteros[i]);
	}
	
	listaDobleEnteros.clear(); // Borramos el contenido de listaDobleEnteros
	//Volvemos a ingresar los elementos de arregloEnteros
	for (int i = 0; i < arregloEnteros.length; i++) {
	    listaDobleEnteros.add(i, arregloEnteros[i]);
	}

	// Arreglo donde tendremos los índices aleatorios
	ArrayList<Integer> indicesAleatorios = new ArrayList<>();
	int indiceAleatorio; // Variable que almacena los índices aleatorios por cada iterada
	int indiceRandom; // Variable que facilita la legibilidad
	int numeroDeElementos = 5; // Comenzamos con el número de elementos de cada lista

	/* Conforme aumente el número de elementos de la lista, iremos ingresando números 
	 * que van del cero al número de elementos en ese instante
	 */
	for(int i = 0; i < 1000; i++) {
	    indiceRandom = (int) (Math.random()*(numeroDeElementos + 1));
	    indicesAleatorios.add(i, indiceRandom);
	    numeroDeElementos++;
	}

	int indiceRecorredor; // Variable que facilita la legibilidad

	// Realiza la inserción en una posición aleatoria de 1000 elementos para arrayLisEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	for(int i = 0; i < 1000 ; i++) {
	    indiceRecorredor = indicesAleatorios.get(i);
	    arrayListEnteros.add(indiceRecorredor, i);
	}
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para arrayListEnteros es: " + (fin - inicio));

	// Realiza la inserción en una posición aleatoria de 1000 elementos para listaSimpleEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	for(int i = 0; i < 1000; i++) {
	    indiceRecorredor = indicesAleatorios.get(i);
	    listaSimpleEnteros.add(indiceRecorredor, i);
	}
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para listaSimpleEnteros es: " + (fin - inicio));

	// Realiza la inserción en una posición aleatoria de 1000 elementos para listaDobleEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	for(int i = 0; i < 1000; i++) {
	    indiceRecorredor = indicesAleatorios.get(i);
	    listaDobleEnteros.add(indiceRecorredor, i);
	}
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para lsitaDobleEnteros es: " + (fin - inicio));

	System.out.println("¿arrayListEnteros y listaSimpleEnteros tienen los mismos elementos? " +
			   objetoPrueba.compara2(arrayListEnteros, listaSimpleEnteros));

	System.out.println("¿arrayListEnteros y listaDobleEnteros tienen los mismos elementos? " +
			   objetoPrueba.compara(arrayListEnteros, listaDobleEnteros));

	// Realiza la inserción en una posición aleatoria de 100000 elementos
	System.out.println("\n6.Realiza la inserción en una posición aleatoria de 100000 elementos.");

	arrayListEnteros.clear(); // Borramos el contenido de arrayListEnteros
	// Volvemos a ingresar los elementos de arregloEnteros
	for(int i = 0; i < arregloEnteros.length; i++) {
	    arrayListEnteros.add(i, arregloEnteros[i]);
	}

	listaSimpleEnteros.clear(); // Borramos el contenido de listaSimpleEnteros
	// Volvemos a ingresar los elementos de arregloEnteros
	for(int i = 0; i < arregloEnteros.length; i++) {
	    listaSimpleEnteros.add(i, arregloEnteros[i]);
	}
	
	listaDobleEnteros.clear(); // Borramos el contenido de listaDobleEnteros
	// Volvemos a ingresar los elementos de arregloEnteros
	for (int i = 0; i < arregloEnteros.length; i++) {
	    listaDobleEnteros.add(i, arregloEnteros[i]);
	}

	numeroDeElementos = 5; // Actualmente se tienen 5 elementos en cada lista
	/* Generamos los índices aleatorios, el rango va cambiando conforme aumenta el
	 * número de elementos
	 */
	for(int i = 0; i < 100000; i++) {
	    indiceRandom = (int) (Math.random()*(numeroDeElementos + 1));
	    indicesAleatorios.add(i, indiceRandom);
	    numeroDeElementos++;
	}

	// Realiza la inserción en una posición aleatoria de 100000 elementos apra arrayLisEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	for(int i = 0; i < 100000 ; i++) {
	    indiceRecorredor = indicesAleatorios.get(i);
	    arrayListEnteros.add(indiceRecorredor, i);
	}
	fin = System.currentTimeMillis(); // fin de la prueba
	System.out.println("El tiempo de ejecución para arrayListEnteros es: " + (fin - inicio));

	// Realiza la inserción en una posición aleatoria de 100000 elementos para lsitaSimpleEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	for(int i = 0; i < 100000; i++) {
	    indiceRecorredor = indicesAleatorios.get(i);
	    listaSimpleEnteros.add(indiceRecorredor, i);
	}
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para listaSimpleEnteros es: " + (fin - inicio));

	// Realiza la inserción en una posición aleatoria de 100000 elementos para listaDobleEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	for(int i = 0; i < 100000; i++) {
	    indiceRecorredor = indicesAleatorios.get(i);
	    listaDobleEnteros.add(indiceRecorredor, i);
	}
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para lsitaDobleEnteros es: " + (fin - inicio));

	System.out.println("¿arrayListEnteros y listaSimpleEnteros tienen los mismos elementos? " +
			   objetoPrueba.compara2(arrayListEnteros, listaSimpleEnteros));	
	System.out.println("¿arrayLisEnteros y listaDobleEnteros tienen los mismos elementos? " +
			   objetoPrueba.compara(arrayListEnteros, listaDobleEnteros));
	
	// Realiza el reverse de 1000 elementos.
	System.out.println("\n7. Realiza el reverse de 1000 elementos.");

	// Limpiamos el contenido de las tres listas
	arrayListEnteros.clear();
	listaSimpleEnteros.clear();
	listaDobleEnteros.clear();

	// Insertamos 1000 elementos en cada lista
	for(int i = 0; i < 1000; i++) {
	    arrayListEnteros.add(i, i);
	    listaSimpleEnteros.add(i, i);
	    listaDobleEnteros.add(i, i);
	}

	// Aplicando el reverse a arrayListEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
        Collections.reverse(arrayListEnteros);
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para arrayListEnteros es: " + (fin - inicio));

	// Aplicnado reverse a listaSimpleEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	listaSimpleEnteros.reverse();
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para listaSimpleEnteros es: " + (fin - inicio));

	// aplicando reverse a listaDobleEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	listaDobleEnteros.reverse();
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para listaDobleEnteros es: " + (fin - inicio));

	System.out.println("¿arrayListEnteros y listaSimpleEnteros son iguales? "
			   + objetoPrueba.compara2(arrayListEnteros, listaSimpleEnteros));
	System.out.println("¿arrayListEnteros y lsitaDobleEnteros son iguales? "
			   + objetoPrueba.compara(arrayListEnteros, listaDobleEnteros));

	// Realiza el reverse de 100000 elementos
	System.out.println("\n8.Realiza el reverse de 100000 elementos.");

	// Borramos el contenidos de las listas
	arrayListEnteros.clear();
	listaSimpleEnteros.clear();
	listaDobleEnteros.clear();

	// Ingresamos 100000 elementos a cada lista
	for(int i = 0; i < 100000; i++) {
	    arrayListEnteros.add(i, i);
	    listaSimpleEnteros.add(i, i);
	    listaDobleEnteros.add(i, i);
	}

	// Aplicamos reverse de 100000 para arrayListEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
        Collections.reverse(arrayListEnteros);
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para arrayListEnteros es: " + (fin - inicio));

	// Aplicamos reverse de 100000 elementos para listaSimpleEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	listaSimpleEnteros.reverse();
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para listaSimpleEnteros es: " + (fin - inicio));

	// Aplicamos reverse de 100000 elementos para listaDobleEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	listaDobleEnteros.reverse();
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para listaDobleEnteros es: " + (fin - inicio));

	System.out.println("¿arrayListEnteros y listaSimpleEnteros son iguales? "
			   + objetoPrueba.compara2(arrayListEnteros, listaSimpleEnteros));
	System.out.println("¿arrayList y listaDobleEnteros son iguales? "
			   + objetoPrueba.compara(arrayListEnteros, listaDobleEnteros));

	// Realiza el clear de 1000 elementos
	System.out.println("\n9. Realizar el clear de 10000 elementos");

	// Borrar el contenido de las listas
	arrayListEnteros.clear();
	listaSimpleEnteros.clear();
	listaDobleEnteros.clear();

	// Insertar 1000 elementos a cada lista
	for(int i = 0; i < 1000; i++) {
	    arrayListEnteros.add(i, i);
	    listaSimpleEnteros.add(i, i);
	    listaDobleEnteros.add(i, i);
	}

	// Realiza el clear de 1000 elementos para arrayListEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	arrayListEnteros.clear();
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejercución para arrayListEnteros: " + (fin - inicio));

	// Realiza el clear de 1000 elementos para listaSimpleEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	listaSimpleEnteros.clear();
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejercución para listaSimpleEnteros: " + (fin - inicio));

	// Realiza el clear de 1000 elementos para listaDobleEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	listaDobleEnteros.clear();
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para listaDobleEnteros: " + (fin - inicio));

	// Realiza el clear de 100000 elementos
	System.out.println("\n10. Realizar el clear de 100000 elementos");

	// Ingresar 100000 elementos en cada lista
	for(int i = 0; i < 100000; i++) {
	    arrayListEnteros.add(i, i);
	    listaSimpleEnteros.add(i, i);
	    listaDobleEnteros.add(i, i);
	}

	// Realiza el clear de 100000 elementos para arrayListEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	arrayListEnteros.clear();
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para arrayListEnteros: " + (fin - inicio));

	// Realiza el clear de 100000 elementos para listaSimpleEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	listaSimpleEnteros.clear();
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para listaSimpleEnteros: " + (fin - inicio));

	// Realiza el clear de 100000
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	listaDobleEnteros.clear();
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para listaDobleEnteros: " + (fin - inicio));

	// Realiza el get de 100 elementos en posición aleatoria teniendo 1000 elementos
	System.out.println("\n11. Realiza el get de 100 elementos en posición aleatoria teniendo "+
			   "1000 elementos");

	// Ingresamos 1000 elementos a cada lista
	for(int i = 0; i < 1000; i++) {
	    arrayListEnteros.add(i, i);
	    listaSimpleEnteros.add(i, i);
	    listaDobleEnteros.add(i, i);
	}
	
	numeroDeElementos = 1000; // Es el número de elementos de cada lista
	indicesAleatorios.clear(); // Borramos el contanido del ArrayList indicesAleatorios

	// Ingresamos los 100 índices aleatorios de los que aplicaremos el get
	for(int i = 0; i < 100; i++) {
	    indiceRandom = (int) (Math.random()*(numeroDeElementos + 1));
	    indicesAleatorios.add(i, indiceRandom);
	}

	// Compararemos el resultado de los 100 get aplicados a las tres listas
	boolean comprobador = true; // Variable que nos dirá si las 100 aplicaciones de get coinciden

	/* Si encontramos alguna no coincidencia entre las tres listas en la aplicación de get,
	 *obtendremos false
	 */
	for(int i = 0; i < 100; i++) {
	    indiceAleatorio = indicesAleatorios.get(i);
	    if(arrayListEnteros.get(indiceAleatorio).equals(listaSimpleEnteros.get(indiceAleatorio))  &&
	       arrayListEnteros.get(indiceAleatorio).equals(listaDobleEnteros.get(indiceAleatorio))) {
	    } else {
		comprobador = false; // Si encontramos alguna no coincidencia
	    }
	}
	System.out.println("¿ Las 100 aplicaciones de get son iguales? " + comprobador); 

	//Realiza el get de 100 elemento en posición aleatoria para arrayListEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	for(int i = 0; i < 100; i++) {
	    arrayListEnteros.get(indicesAleatorios.get(i));
	}
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para arrayListEnteros: " + (fin - inicio));

	// Realiza el get de 100 elementos en posición aleatoria para listaSimpleEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	for(int i = 0; i < 100; i++) {
	    listaSimpleEnteros.get(indicesAleatorios.get(i));
	}
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para listaSimpleEnteros: " + (fin - inicio));

	// Realiza el get de 100 elementos en posición aleatoria para listaDobleEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	for(int i = 0; i < 100; i++) {
	    listaDobleEnteros.get(indicesAleatorios.get(i));
	}
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para listaDobleEnteros: " + (fin - inicio));

	// Realiza el get de 100 elementos en posición aleatoria teniendo 100000 elementos
	System.out.println("\n12. Realiza el get de 100 elementos en posición aleatoria teniendo "+
			   "10000 elementos");

	// Borramos el contenido de las listas
	arrayListEnteros.clear();
	listaSimpleEnteros.clear();
	listaDobleEnteros.clear();

	// Ingresamos 100000 elementos en cada lista
	for(int i = 0; i < 100000; i++) {
	    arrayListEnteros.add(i, i);
	    listaSimpleEnteros.add(i, i);
	    listaDobleEnteros.add(i, i);
	}
	
	numeroDeElementos = 100000; // Es el número de elementos de cada lista
	indicesAleatorios.clear(); // Borramos los índices aleatorios de la prueba anterior
	// Obtenemos 100 nuevos números aleatorios
	for(int i = 0; i < 100; i++) {
	    indiceRandom = (int) (Math.random()*(numeroDeElementos + 1));
	    indicesAleatorios.add(i, indiceRandom);
	}

	// Comparamos si las 100 aplicaciones de get coinciden.
	comprobador = true; // Variable que nos dará el resultado de si o no coinciden las aplicaciones de get
	for(int i = 0; i < 100; i++) {
	    indiceAleatorio = indicesAleatorios.get(i);
	    if(arrayListEnteros.get(indiceAleatorio).equals(listaSimpleEnteros.get(indiceAleatorio))  &&
	       arrayListEnteros.get(indiceAleatorio).equals(listaDobleEnteros.get(indiceAleatorio))) {
	    } else { // Si exite al menos alguna no coincidencia
		comprobador = false;
	    }
	}
	System.out.println("¿Las 100 aplicaciones de get coinciden? " + comprobador);

	// Realiza el get de 100 elementos en posición aleatoria para arrayLisEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	for(int i = 0; i < 100; i++) {
	    arrayListEnteros.get(indicesAleatorios.get(i));
	}
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para arrayListEnteros: " + (fin - inicio));

	// Realiza el get de 100 elemento en posición aleatoria para listaSimpleEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueva
	for(int i = 0; i < 100; i++) {
	    listaSimpleEnteros.get(indicesAleatorios.get(i));
	}
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para listaSimpleEnteros: " + (fin - inicio));

	// Realiza el get de 100 elementos en posición aleatoria para listaDobleEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	for(int i = 0; i < 100; i++) {
	    listaDobleEnteros.get(indicesAleatorios.get(i));
	}
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para listaDobleEnteros: " + (fin - inicio));

	// Realiza el K nodo desde el centro con K = 25 teniendo 1000 elementos
	System.out.println("\n13. Realiza el K nodo desde el centro con K = 25 teniendo 1000 elementos.");

	// Borramos el contenido de las listas
	arrayListEnteros.clear();
	listaSimpleEnteros.clear();
	listaDobleEnteros.clear();

	// Ingresamos 1000 elementos en cada lista
	for (int i = 0; i < 1000; i++) {
	    arrayListEnteros.add(i, i);
	    listaSimpleEnteros.add(i, i);
	    listaDobleEnteros.add(i, i);
	}

	// Realiza el K nodo desde el centro con K = 25 para arrayListEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	objetoPrueba.obtenerPosicionDesdeCentro(25, arrayListEnteros);
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para arrayListEnteros: " + (fin - inicio));
	System.out.print("El K nodo para arrayListEnteros es: ");
	System.out.println(objetoPrueba.obtenerPosicionDesdeCentro(25, arrayListEnteros));

	// Realiza el K nodo desde el centro con K = 25 para listaSimpleEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	listaSimpleEnteros.obtenerPosicionDesdeCentro(25);
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para listaSimpleEnteros: " + (fin - inicio));
	System.out.print("El K nodo para listaSimpleEnteros es: ");
	System.out.println(listaSimpleEnteros.obtenerPosicionDesdeCentro(25));

	// Realiza el K nodo desde el centro con K = 25 para listaDobleEnteros 
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	listaDobleEnteros.obtenerPosicionDesdeCentro(25);
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para listaDobleEnteros: " + (fin - inicio));
	System.out.print("El K nodo para listaDobleEnteros es: ");
	System.out.println(listaDobleEnteros.obtenerPosicionDesdeCentro(25));

	// Realiza el K nodo desde el centro con K = 250 teniendo 100000 elementos
	System.out.println("\n14. Realiza el K nodo desde el centro con K = 250 teniendo 100000 elementos.");

	// Borramos el contenido de cada lista
	arrayListEnteros.clear();
	listaSimpleEnteros.clear();
	listaDobleEnteros.clear();

	// Ingresamos 100000 elementos en cada lista
	for (int i = 0; i < 100000; i++) {
	    arrayListEnteros.add(i, i);
	    listaSimpleEnteros.add(i, i);
	    listaDobleEnteros.add(i, i);
	}

	// Realiza el K nodo desde el cento para arrayListEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	objetoPrueba.obtenerPosicionDesdeCentro(250, arrayListEnteros);
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para arrayListEnteros: " + (fin - inicio));
	System.out.print(" El K nodo desde el centro para arrayListEnteros es: ");
	System.out.println(objetoPrueba.obtenerPosicionDesdeCentro(250, arrayListEnteros));

	// Realiza el K nodo desde el centro para listaSimpleEnteros
	inicio = System.currentTimeMillis(); // Incio de la prueba
	listaSimpleEnteros.obtenerPosicionDesdeCentro(250);
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para listaSimpleEnteros: " + (fin - inicio));
	System.out.print("El K nodo desde el centro para listaSimpleEnteros es: ");
	System.out.println(listaSimpleEnteros.obtenerPosicionDesdeCentro(250));

	// Realiza el K nodo desde el centro para listaDobleEnteros 
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	listaDobleEnteros.obtenerPosicionDesdeCentro(250);
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para listaDobleEnteros: " + (fin - inicio));
	System.out.print("El K nodo desde el centro para listaDobleEnteros es: ");
	System.out.println(listaDobleEnteros.obtenerPosicionDesdeCentro(250));

	// Realiza el K nodo desde el centro con K = 200 teniendo 1000 elementos
	System.out.println("\n15. Realiza el K nodo desde el centro con K = 200 teniendo 1000 elementos.");

	// Borramos el contenido de cada lista
	arrayListEnteros.clear();
	listaSimpleEnteros.clear();
	listaDobleEnteros.clear();

	// Ingresamos 1000 elementos a cada lista
	for (int i = 0; i < 1000; i++) {
	    arrayListEnteros.add(i, i);
	    listaSimpleEnteros.add(i, i);
	    listaDobleEnteros.add(i, i);
	}

	// Realiza el K nodo desde el centro para arrayListEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	objetoPrueba.obtenerPosicionDesdeCentro(200, arrayListEnteros);
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para arrayListEnteros: " + (fin - inicio));
	System.out.print("El K nodo para arrayListEnteros es: ");
	System.out.println(objetoPrueba.obtenerPosicionDesdeCentro(200, arrayListEnteros));

	// Realiza el K nodo desde el centro para listaSimpleEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	listaSimpleEnteros.obtenerPosicionDesdeCentro(200);
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para listaSimpleEnteros: " + (fin - inicio));
	System.out.print("El K nodo de ejecución para listaSimpleEnteros es: ");
	System.out.println(listaSimpleEnteros.obtenerPosicionDesdeCentro(200));
	
	// Realiza el K nodo desde el centro para listaDobleEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	listaDobleEnteros.obtenerPosicionDesdeCentro(200);
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para listaDobleEnteros: " + (fin - inicio));
	System.out.print("El K nodo para listaDobleEnteros es: ");
	System.out.println(listaDobleEnteros.obtenerPosicionDesdeCentro(200));

	// Realiza el K nodo desde el centro con K = 5000 teniendo 100000 elementos
	System.out.println("\n13. Realiza el K nodo desde el centro con K = 5000 teniendo 100000 elementos.");

	// Borramos el contenido de las listas
	arrayListEnteros.clear();
	listaSimpleEnteros.clear();
	listaDobleEnteros.clear();

	// Ingresamos 100000 elementos en cada lista
	for (int i = 0; i < 100000; i++) {
	    arrayListEnteros.add(i, i);
	    listaSimpleEnteros.add(i, i);
	    listaDobleEnteros.add(i, i);
	}

	// Realiza el K nodo para arrayLisEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	objetoPrueba.obtenerPosicionDesdeCentro(5000, arrayListEnteros);
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para arrayListEnteros: " + (fin - inicio));
	System.out.print("El K nodo para arrayListEnteros es: ");
	System.out.println(objetoPrueba.obtenerPosicionDesdeCentro(5000, arrayListEnteros));

	// Realiza el K nodo para listaSimpleEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	listaSimpleEnteros.obtenerPosicionDesdeCentro(5000);
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para listaSimpleEnteros: " + (fin - inicio));
	System.out.print("El K nodo para listaSimpleEnteros es: ");
	System.out.println(listaSimpleEnteros.obtenerPosicionDesdeCentro(5000));

	// Realiza el K nodo para listaDobleEnteros
	inicio = System.currentTimeMillis(); // Inicio de la prueba
	listaDobleEnteros.obtenerPosicionDesdeCentro(5000);
	fin = System.currentTimeMillis(); // Fin de la prueba
	System.out.println("El tiempo de ejecución para listaDobleEnteros: " + (fin - inicio));
	System.out.print("El K nodo para listaSimpleEnteros es: ");
	System.out.println(listaDobleEnteros.obtenerPosicionDesdeCentro(5000));

	
    }
}
    
