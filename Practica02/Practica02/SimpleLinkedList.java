import java.util.Iterator;

/**
 * Implementación de una lista simplemente ligada
 * @author Alejandro Román Sánchez
 * Número de cuenta: 408093413
 * @version 21/sep/2022
 * @since Estrucutras de datos 2023-1
 */
public class SimpleLinkedList<T> implements TDAList<T>{

    /**
     * Esta clase anidada nos permite utilizar nodos para la lista simplemente ligas
     */
    private class Nodo{
        /* Elemento a almacenar */
        public T elemento;
	
        /* Apuntador al nodo siguiente */
        public Nodo siguiente;
	
        /* Crea un nodo a partir de un elemento <i>elemento</i> de tipo <i>T</i> */
        public Nodo(T elemento){
            this.elemento = elemento;
        }
    }
    
    /**
     * Iterador de la lista simplemente ligada
     */
    private class IteradorListaSimple implements Iterator<T> {

	private Nodo iteradorLista;
        
	// Constructor de la clase IteradorListaSimple
	public IteradorListaSimple(Nodo cabeza) {
            iteradorLista = new Nodo(null);
            iteradorLista.siguiente = cabeza;
        }
	
        public boolean hasNext(){
            return iteradorLista.siguiente != null;
        }
	
        public T next(){
            iteradorLista = iteradorLista.siguiente;
            return iteradorLista.elemento;
        }
    }
    
    /** Nodo inicial de la lista */
    private Nodo cabeza;
    
    /** Nodo ultimo de la lista */
    private Nodo cola;
    
    /** Cantidad de elementos en la lista */
    private int longitud;
    
    /**
     * Inserta un nuevo elemento <i>e</i> en la posicion <i>i</i>
     * @param i la posicion donde agregar el elemento
     * @param e el elemento que vamos a agregar
     * @throws IndexOutOfBoundsException si el indice esta fuera de rango.
     */
    public void add(int i, T e) throws IndexOutOfBoundsException{
        if (i < 0 || i > longitud) {
            throw new IndexOutOfBoundsException("El indice no esta en el rango de 0 y el tamanio de la lista. ");
        }
	
        Nodo nuevo = new Nodo(e);
	
        // Caso para la lista vacia
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            longitud ++;
            return;
        }
	
        // Agregar en la posicion 0.
        if(i == 0){
            nuevo.siguiente = cabeza;
            cabeza = nuevo;
            longitud ++;
            return;
        }
        // agrega al final
        else if(i == longitud){
            cola.siguiente = nuevo;
            cola = nuevo;
            
            longitud ++;
            return;
        }
	
        // agrega en otra posicion
	
        // Creando un iterador en la cabeza. 
        Nodo iterador = cabeza;
        
        for (int j = 0; j < i-1; j++) {
            iterador = iterador.siguiente;
        }
        nuevo.siguiente = iterador.siguiente;
        iterador.siguiente = nuevo;
        longitud ++;
	
	
    }
    
    /**
     * Elimina el elemento en la posicion <i>i</i>
     * @param i la posicion del elemento a eliminar
     * @return el elemento eliminado.
     * @throws IndexOutOfBoundsException si el indice esta fuera de rango.
     */
    public T remove(int i) throws IndexOutOfBoundsException{
        if (i < 0 || i >= longitud) {
            throw new IndexOutOfBoundsException("El indice no esta en el rango de 0 y el tamanio de la lista. ");
        }
        T eliminado = null; // Terminará almacenando el elemento a elimiminar
        
        // eliminar el unico elemento
        if(longitud == 1){
            eliminado = cabeza.elemento;
            clear();
            return eliminado;
        }
	
        // elimina el primer elemento
        if (i == 0) {
            eliminado = cabeza.elemento;
            cabeza = cabeza.siguiente;
            longitud --;
            return eliminado;
        }
        else if (i == longitud-1) {
            eliminado = cola.elemento;
            Nodo iterador = cabeza;
            for (int j = 0; j < longitud-2; j++) {
                iterador =  iterador.siguiente;
            }
            cola = iterador;
            cola.siguiente = null;
            longitud --;
            return eliminado;
        }
	
        Nodo iterador = cabeza;
        for (int j = 0; j < i-1; j++) {
            iterador = iterador.siguiente;
        }
        eliminado = iterador.siguiente.elemento;
        iterador.siguiente = iterador.siguiente.siguiente; 
        longitud --;
        return eliminado;
    }
    
    /**
     * Vacia la lista. Elimina todos los elementos.
     */
    public void clear(){
        cabeza = null;
        cola = null;
        longitud = 0;
    }
    
    /**
     * Obtiene el elemento en la posicion <i>i</i>
     * @param i el indice del elemento a obtener
     * @throws IndexOutOfBoundsException si el indice esta fuera de rango.
     */
    public T get(int i) throws IndexOutOfBoundsException{
        if (i < 0 || i >= longitud) {
            throw new IndexOutOfBoundsException("El indice no esta en el rango de 0 y el tamanio de la lista. ");
        }
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("La lista esta vacia");
        }
        if (i == 0){
            return cabeza.elemento;
        }
        Nodo iterador = cabeza;
        // entonces i = [1,longitud]
        for (int j = 0; j < i ; j++) {
            iterador = iterador.siguiente;
        }
	
        return iterador.elemento;
    }
    
    /**
     * Verifica si un elemento esta contenido en la lista
     * @param e el elemento a verificar si esta contenido
     * @return true si el elemento si eta contenido, false en otro caso.
     */
    public boolean contains(T e){
        if (isEmpty()) {
            return false;
        }
        if (longitud == 1) {
            return e.equals(cabeza.elemento);
        }
        Nodo iterador = cabeza;
        for(int j = 0; j<longitud;j++){
            if (e.equals(iterador.elemento)) {
                return true;
            }
            iterador = iterador.siguiente;
        }
        return false;
    }
    
    /**
     * Verifica si la lista esta vacia.
     * @return true si la lista no contiene elementos, false en otro caso.
     */
    public boolean isEmpty(){
        return longitud == 0; 
    }
    
    /**
     * Regresa la cantidad de elementos contenidos en la lista. 
     * @return la cantidad de elementos contenidos.
     */
    public int size(){       
        return longitud; 	
    }    

    /**
     * Invierte el orden de los elementos que aparecen en la lista. El resultado se
     * almacena en la lista al que se le aplica el método
     */
    public void reverse() {
	// Si la lista es vacía
	if (cabeza == null) {
	    return;
	}
	// Si la lista es no vacía
	Nodo nodoNuevo = new Nodo(null);
	Nodo nodoRecorredor1 = cabeza;
	Nodo nodoRecorredor2 = cabeza;
	for(int i = 0; i < (size() / 2) ; i++) {
	    for(int j = 0; j < i; j++) {
		nodoRecorredor1 = nodoRecorredor1.siguiente;
	    }	    	    
	    for(int j = 0; j < size() - i - 1; j++) {	       
		nodoRecorredor2 = nodoRecorredor2.siguiente;		
	    }
	    nodoNuevo.elemento = nodoRecorredor1.elemento;
	    nodoRecorredor1.elemento = nodoRecorredor2.elemento;
	    nodoRecorredor2.elemento = nodoNuevo.elemento;	
	    
	    nodoRecorredor1 = cabeza;
	    nodoRecorredor2 = cabeza;	    
	}		
    }
    
    /**
     * Crea un iterador
     * @return iterador de la lista simple que apunta a cabeza
     */
    public Iterator iterador(){
        return new IteradorListaSimple(this.cabeza);
    }

    /**
     * Método que imprime el elemento siguiente de cada elemento de la lista
     */
    public void imprimeSiguientes() {
	Nodo iterador = cabeza;	
	for(int i = 0; i < size() - 1; i++) {
	    System.out.print("(" + i + ", " + iterador.siguiente.elemento + ")  ");
	    iterador = iterador.siguiente;
	}
	System.out.println();
    }

    /**
     * Imprime el objeto que está apuntando el último nodo de la lista
     */
    public void imprimeUltimoSiguiente() {
	Nodo iterador = cabeza;
	for(int i = 1; i < size(); i++) {
	    iterador = iterador.siguiente;
	}
	System.out.println(iterador.siguiente);
    }

    /**
     * Muestra el elemento que se encuentra en cierto índice central. Si la lista tiene un 
     * número impar de elementos, entonces el elemento de en medio tiene índice central igual
     * a cero. Si el índice está fuera del rango permitido, devuelve null.
     * @param i El índice central.
     * @return el elemento que se encuentra en el índice central ingresado. Si el índice está 
     * fuera del rango, entonces devolverá null
     */
    public T obtenerPosicionDesdeCentro(int i) {
	int medio = size() / 2;
	if (size() % 2 == 0) {		
	    if (medio - 1 - i < 0) {
		return null;
	    }
	    return get(medio - 1 - i);
	} else {
	    if(((int) medio) - i < 0) {
		return null;
	    }
	    return get(((int)medio) - i);
	}	
    }
}
