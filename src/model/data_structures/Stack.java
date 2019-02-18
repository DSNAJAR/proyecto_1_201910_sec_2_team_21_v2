package model.data_structures;

import java.util.Iterator;

public class Stack<T extends Comparable<T>> implements IStack<T> {
	
	//-----------------------------------------------------------------------------
	// Atributos
	//-----------------------------------------------------------------------------
	
	/**
	 * Primer elemento de la pila
	 */
	private Nodo<T> first;
	
	/**
	 * Tamaño de la pila
	 */
	private int size;
	
	//--------------------------------------------------------------------------------------
	// Constructor
	//--------------------------------------------------------------------------------------
	
	/**
	 * Crea una nueva pila vacía.
	 */
	public Stack() {
		first = null;
		size = 0;
	}
	
	/**
	 * Crea un nuevo iterador para recorrer la pila
	 */
	public Iterator<T> iterator() {
		return new ListIterator();
	}
	
	//--------------------------------------------------------------------------------------
	// Métodos
	//--------------------------------------------------------------------------------------
	
	/**
	 * Clase que representa el iterador de la pila
	 */
	private class ListIterator implements Iterator<T> {
		
		private Nodo<T> current = first;
		
		/**
		 * Retorna true si el nodo tiene un nodo siguiente
		 * @return true si el nodo tiene un nodo siguiente, false de lo contrario
		 */
		public boolean hasNext() {
		 return current != null; 
		}
		
		/**
		 * Retorna el nodo siguiente
		 * @return Nodo siguiente al actual
		 */
		public T next() {
			 T item = current.item;
			 current = current.siguiente;
			 return item;
		}
	 }

	/**
	 * Retorna true si la Pila esta vacia
	 * @return true si la Pila esta vacia, false de lo contrario
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Retorna el numero de elementos contenidos
	 * @return el numero de elemntos contenidos
	 */
	public int size() {
		return size;
	}

	/**
	 * Inserta un nuevo elemento en la Pila
	 * @param t el nuevo elemento que se va ha agregar
	 */
	public void push(T t) {
		Nodo<T> nwNodo = new Nodo<T>(t);
		if(first == null) {
			first=nwNodo;
		}
		else {
			Nodo<T> oldFirst = first;
			nwNodo.siguiente = oldFirst;
			first = nwNodo;
		}
		size++;
	}

	/**
	 * Quita y retorna el elemento agregado mÃ¡s recientemente
	 * @return el elemento agregado mÃ¡s recientemente
	 */
	public T pop() {
		T rturn = first.item;
		if(first.siguiente != null) {
			first = first.siguiente;
			size--;
		}
		else
		{
			first = null;
			size--;
		}

		return rturn;
	}

}
