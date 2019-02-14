package model.data_structures;

import java.util.Iterator;

public class Queue<T extends Comparable<T>> implements IQueue<T> {

	private Nodo<T> first;
	
	private Nodo<T> last;
	
	private int size;
	
	public Queue() {
		first = null;
		last = null;
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
		return first == null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	public void enqueue(T t) {
		// TODO Auto-generated method stub
		Nodo<T> oldLast = last;
		last = new Nodo<T>(t);
		last.siguiente = null;
		
		if(isEmpty()){
			first = last;
		}
		else {
			oldLast.siguiente = last;
		}
		
		size++;
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		T item = first.item;
		first = first.siguiente;
		
		if(!isEmpty()) {
			last = null;
			size--;
		}		
		
		return item;
	}

}
