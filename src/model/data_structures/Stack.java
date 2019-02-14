package model.data_structures;

import java.util.Iterator;

public class Stack<T extends Comparable<T>> implements IStack<T> {
	
	private Nodo<T> first;
	
	private int size;
	
	public Stack() {
		first = null;
		size = 0;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<T> {
		
		private Nodo<T> current = first;
		
		public boolean hasNext() {
		 return current != null; 
		}
		
		public T next() {
			 T item = current.item;
			 current = current.siguiente;
			 return item;
		}
	 }

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public void push(T t) {
		// TODO Auto-generated method stub
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

	@Override
	public T pop() {
		// TODO Auto-generated method stub
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
