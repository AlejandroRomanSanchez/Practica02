import java.util.Iterator;

/**
 * Implementación de una lista doblemente ligada
 * @author Alejandro Román Sánchez
 * Númeroo de cuenta: 408093413
 * @version 21/sep/2022
 * @since Estructuras de datos 2023-1
 */
public class DoubleLinkedList<T> implements TDAList<T> {
    /**
     * Esta clase anidada nos sirve para la creación de los nodos de una 
     * clase doblemente ligada
     */
    public class Node {
	public T element; // Elemento a almacenar
	public Node next; // Apuntador al nodo siguiente	
	public Node prev; // Apuntador al nodo anterior

	/**
	 * Constructor de un nodo en términos de su elemento
	 * @param elemento es el elemento que se almacena en el nodo
	 */
	public Node(T elemento) {
	    this.element = elemento;
	}
    }

    /**
     * Esta clase anidada nos sirve para la creación de los iteradores 
     *de una lista doblemente ligada. Esta clase implementa a Iterator.
     */
    private class IteradorListaDoble implements Iterator<T> {
	private Node iteradorListaDoble;

	public IteradorListaDoble(Node cabeza) {
	    iteradorListaDoble = new Node(null);
	    iteradorListaDoble.next = cabeza;
	}

	public boolean hasNext() {
	    return iteradorListaDoble.next != null;
	}

	public T next() {
	    iteradorListaDoble = iteradorListaDoble.next;
	    return iteradorListaDoble.element;
	}
    }
    
    public Node head; // Nodo inicial de la lista
    public Node tail; // Nodo último de la lista    
    private int contador; // Cantidad de elementos en la lista

    /** 
     * Dado un índice y un elemento, inserta dicho elemento en tal índice.
     * @param i Es el índice en el que se desea insertar el elemento
     * @param elemento Es el elemento que se desea insertar en dicho índice.
     * @throws IndexOutOfBoundsException si el índice está fuera del rango.
     */
    public void add(int i, T elemento) throws IndexOutOfBoundsException {
	// Si el índice está fuera del rango permitido.
	if (i < 0 || size() < i) {
	    throw new IndexOutOfBoundsException("El índice se encuentra fuera de los límites permitidos.");
	}

	// Creación del nodo que agregaremos en la lista
	Node nodoNuevo = new Node(elemento);

	// Si la lista es vacía
	if (size() == 0) {
	    head = nodoNuevo;
	    nodoNuevo.prev = null;
	    nodoNuevo.next = null;
	    tail = nodoNuevo;
	    contador++;
	    return;
	}

	// Si se desea ingresar un elemento en el nodo de índice 0
	if (i == 0) {
	    nodoNuevo.next = head;
	    nodoNuevo.prev = null;
	    head.prev = nodoNuevo;
	    head = nodoNuevo;
	    contador++;	    
	    return;
	}

	// Si se desea agregar el elemento al final de la lista
	if (i == size()) {
	    nodoNuevo.prev = tail;
	    nodoNuevo.next = null;
	    tail.next = nodoNuevo;
	    tail = nodoNuevo;
	    contador++;
	    return;
	}
	
	int medio = (size() + 1) / 2; // Este índice nos permite recorrer la lista eficientemente
	// Si el índice está por debajo del índice almacenado en la variable medio
	if (i < (size() + 1) / 2) {
	    Node iterador = head;
	    for (int j = 1; j < i; j++) {
		iterador = iterador.next;
	    }		          
	    nodoNuevo.prev = iterador;
	    nodoNuevo.next = iterador.next;
	    iterador.next.prev = nodoNuevo;
	    iterador.next = nodoNuevo;
	    contador++;
	} else { // Si el índice está por arriba del índice almacenado en la variable medio.
	    Node iterador = tail;
	    for (int j = 1; j < size() - i ; j++) {
		iterador = iterador.prev;
	    }
	    nodoNuevo.prev = iterador.prev;
	    nodoNuevo.next = iterador;
	    iterador.prev.next = nodoNuevo;
	    iterador.prev = nodoNuevo;
	    contador++;
	}
    }


    /**
     * Elimina el elemento del índice ingresado
     * @param i posición del elemento a eliminar
     * @return El elemento eliminado
     * @throws IndexOutOfBoundsException si el índice está fuera del rango
     */
    public T remove(int i) throws IndexOutOfBoundsException {
	// Si el índice ingresado está fuera del rango
	if (i < 0 || size() <= i) {
	    throw new IndexOutOfBoundsException("Índice fuera del dominio permitido.");
	}

	// Apuntador que al final almacenará el elemento a eliminar
	Node eliminado = null;

	// Si la lista es vacía
	if (size() == 0) {
	    tail = null;
	    return null;
	}

	// Si la lista solo tiene un elemento
	if (size() == 1) {
	    eliminado = head;
	    clear();
	    return eliminado.element;
	}

	// Si se desea eliminar el primer elemento.
	if (i == 0) {
	    eliminado = head;
	    head = head.next;
	    head.prev = null;
	    contador--;
	    return eliminado.element;
	}

	// Si se desea eliminar el último elemento
	if (i == size() - 1) {
	    eliminado = tail;
	    tail.prev.next = null;
	    contador--;
	    tail = tail.prev;
	    return eliminado.element;
	}
	
	Node iterador; //Variable que nos permite recorrer la lista

	// Si el elemento a eliminar está por debajo del índice medio
	if (i < (size() + 1) / 2) {
	    iterador = head;
	    for(int j = 1; j < i; j++) {
		iterador = iterador.next;
	    }
	    eliminado = iterador.next;
	    eliminado.next.prev = iterador;
	    iterador.next = eliminado.next;
	    contador--;
	    return eliminado.element;
	} else { // Si el elemento a eliminar está por arriba del índice medio
	    iterador = tail;
	    for(int j = 1; j < size() - i - 1; j++) {
		iterador = iterador.prev;
	    }
	    eliminado = iterador.prev;
	    eliminado.prev.next = iterador;
	    iterador.prev = eliminado.prev;
	    contador--;
	    return eliminado.element;
	}	    
    }

    /**
     * Elimina todos los elementos de la lista
     */
    public void clear() {
	contador = 0; // Hacemos que el contador de elementos sea cero
	head = null; // Hacemos que la cabeza de la lista apunte a null
	tail = null; // Hacemos que la cola de la lista apunte a null
    }

    /**
     * Devuelve el elemento que está en la posición del índice ingresado
     * @param i índice del elemento a devolver
     * @throws IndexOutOfBoundsException si el índice está fuera del rango
     */
    public T get(int i) throws IndexOutOfBoundsException {
	// Si el índice está fuera del rango permitido
	if (i < 0 || size() <= i){
	    throw new IndexOutOfBoundsException("Índice fuera del dominio permitido.");	    
	}

	// Si la lista es vacía
	if (head == null) {
	    return null;
	}
	
	Node iterador; // Esta variable nos permite recorrer la lista

	if (i < (size() + 1) / 2) { // Si el índice está por debajo del punto medio
	    iterador = head;
	    for (int j = 1; j <= i; j++) {
		iterador = iterador.next;
	    }
	    return iterador.element;
	} else { // Si el índice está por arriba del punto medio
	    iterador = tail;
	    for(int j = 1; j < size() - i; j++) {
		iterador = iterador.prev;
	    }
	    return iterador.element;
	}
    }

    /**
     * Verifica si un elemento está o no contanido en la lista
     * @param elemento El elemento a verificar si está o no en la lista
     * @return true si el elemento se encuentra, false en caso contrario
     */     
    public boolean contains(T elemento) {
	// Si la lista es vacía
	if (size() == 0) {
	    return false;
	}	
	Node iteradorInicio = head; // Nos permite recorrer la lista por debajo
	Node iteradorFinal = tail; // Nos permite recorrer la lista por arriba

	/*
	 * Buscamos el elemento ingresado recorriendo la lista tanto de arriba hacia el 
	 * el centro, como desde abajo hacia el centro
	 */
	for(int i = 0; i < (size() + 1) / 2; i++) {
	    if(iteradorInicio.element.equals(elemento) || iteradorFinal.element.equals(elemento)) {
		return true; // Si encontramos una coincidencia, devolvemos true de inmediato
	    }
	    iteradorInicio = iteradorInicio.next; // Para avanzar de abajo hacia el centro
	    iteradorFinal = iteradorFinal.prev; // Para avanzar de arriba hacia abajo
	}
	return false; // Si no existió ninguna coincidencia
    }

    /**
     * Verifica si la lista está vacía
     * @return si la lista está vacía, devuelve true; en caso contrario, devuelve fals
     */
    public boolean isEmpty() {
	// Si no tiene elementos, la conclusión es true
	if (contador == 0) {
	    return true;
	}
	return false; // Si se tiene al menos un elemento, devuelve true
    }

    /**
     * Devuelve la cantidad de elementos en la lista
     * @return la cantidad de elementos en la lista
     */
    public int size() {
	return contador; // Solo se devuelve el contador de elementos
    }

    /** 
     * Invierte el orden de los elementos dentro de la lista, este método modifica
     * a la lista
     */
    public void reverse() {
	/* Este nodo nos permite recorrero la lista de manera eficiente, pues
	 * en él almacenaremos los atributos de los nodos que recorremos en la
	 * lista
	 */
	Node nodoAuxiliar = new Node(null); 

	// Nos permite recorrer la lista de abajo hacia el centro
	Node iteradorInicial = head;

	// Nos permite recorrer la lista de arriba hacia el centro
	Node iteradorFinal = tail;

	// Si la lista es vacía
	if (head == null) {
	    return;
	}

	/* Si la lista no es vacía, la recorremos de arriba hacia el cento, y
	 * de abajo hacia el centro
	 */
	for(int i = 0; i <= (size() / 2) - 1; i++) {
	    nodoAuxiliar.element = iteradorFinal.element;
	    iteradorFinal.element = iteradorInicial.element;
	    iteradorInicial.element = nodoAuxiliar.element;
	    iteradorInicial = iteradorInicial.next;
	    iteradorFinal = iteradorFinal.prev;		
	}	
    }

    /**
     * El objeto lista al cual se le aplica este método y la lista del 
     * parámetro de esta lista se unen de tal manera que los elementos
     * aparecen de manera alternada. Si la lista del parámetro es vacía, 
     * entonces este parámetro solo devuelve la lista sobre la que se
     * aplicó este método. Si las dos lista tienen longiutd distintas y
     * no son vacías, entonces al final solo aparecerán los elementos de
     * la lista con mayor longitud. Todos estos elementos alternados se 
     * van a guardar en la lista sobre la que se aplicó este método; no 
     * sobre la lista del parámetro. Por ello, es importante tener en 
     * cuenta que sí modificará dicha lista.
     * @param listadoble La lista con la que se va a unir de manera 
     * alternada con la lista sobre la que se aplica el método
     */
    public void uneListas(DoubleLinkedList<T> listaDoble) {
	// Si la lista parámetro es null, no se hace nada
	if( listaDoble.head == null) {
	    return;
	}

	/* Esta variable nos permitirá definir la cola del nuevo estado
	 * de la lista a la que se el aplica el método. 
	 */
	Node iterador1; 
	
	// Nos permite recorrer desde abajo la lista parámetro
	Node iterador2 = listaDoble.head;	
	
	int n = size();
	int m = listaDoble.size();

	// Nos permite recorrer la lsita parámetro mediante el método get
	int contador = 0;
	
	// Vamos a recorrer a la lista parámetro mediante la variable contador
	for(int i = 1; i < n + m; i++) {
	    if(i % 2 == 1) {
		/* Si contador está en la posición que corresponde al tamaño
		 * de la lista sobre la que se aplica el método, pero aún falta
		 * recorrer elemento de la lista parámetro
		 */
		if (contador == n && contador < m) { 
		    iterador2.element = listaDoble.get(contador);
		    tail.next = iterador2;
		    iterador2.prev = tail;
		    tail = iterador2;
		    iterador2 = iterador2.next;
		    contador++;
		}

		/* Si contador aún no ha rebasado ninguno de los tamaños de
		 *las listas
		 */
		if (contador < m && contador < n) {
		    add(i, listaDoble.get(contador));
		    contador++;
		    iterador2 = iterador2.next;
		}

		/* Si contador ya recorrió todos los elementos de la lista sobre 		
		 * la que se aplica el método pero aún falta recorrer elementos de 
		 * la lista parámetro
		 */
		if (contador < m && contador > n) {
		    tail.next = iterador2;
		    iterador2.element = listaDoble.get(contador);
		    iterador2.prev = tail;
		    tail = iterador2;
		    contador++;
		    iterador2 = iterador2.next;
		}
	    }    
	}
	iterador1 = head; // Hacemos que esta variable apunte a head

	/* Hacemos que el iterador recorra el nuevo estado de la lista a la que 
	 * se le aplica el método. Lo recorrer todo, para definir la nueva cola.
	 */
	for(int i = 1; i < n + m; i++) {
	    iterador1 = iterador1.next; 
	}
	tail = iterador1; // Hacemos que la cola apunte al final del nuevo estado
	this.contador = n + m; // Modificamos el contador de elementos de la lista.
    }
    
    
    /**
     * Obtenemos el elemento que tiene el índice desde el centro ingresado
     * @param numeroEntero es el índice desde el centro. Si la lista tiene 
     * una cantidad impar de elementos, entonces el elemento que está en medio
     * tiene índice central 0. 
     * @return El elemento que está en el índice central; si el índice está fuera
     * del rango permitido, se devuelve null
     */
    public T obtenerPosicionDesdeCentro(int numeroEntero) {	

	// Si la lista tiene una cantidad par de elementos
	if( size() % 2 == 0) {
	    // Traducción del índice central en términos del índice estándar
	    int indiceSelecto1 = (size() / 2) - 1 - numeroEntero;
	    // Si el índice central se encuentra del rango permitido
	    if (indiceSelecto1 < 0) {
		return null;
	    }
	    return get(indiceSelecto1); // En caso contrario, se utiliza get
	}  else { // Si la lista tiene una cantidad impar de elementos
	    // Traducción del índice central en términos del índice estándar
	    int indiceSelecto2  = size()/2 - numeroEntero;
	    if(indiceSelecto2 < 0) { // Si el índice no está en el rango permitido
		return null;
	    }
	    return get(indiceSelecto2); // En caso contrario, solo utilizamos get
	}
    }

    /**
     * Imprime los elementos de la lista
     */
    public void print() {

	/* Recorre la lista y guarda temporalmente los elementos, para que en el
	 * recorrido no se pierdan datos.
	 */
	Node nodoRecorredor = new Node(null);

	// Si la lista es vacía
	if(head == null) {
	    System.out.println("Está vacía");
	} else { // Si la lista no es vacía
	    nodoRecorredor = head; // La variable apunta a head
	    System.out.print(nodoRecorredor.element + " ");
	    // Si el nodo siguiente no es null
	    while(nodoRecorredor.next != null) { 	
		nodoRecorredor = nodoRecorredor.next; // La variable apunta el siguiente
		System.out.print(nodoRecorredor.element + " "); 
	    }
	    System.out.println();
	}
    }
}
