package practica3.ej1;

import java.util.ArrayList;
import java.util.Iterator;

public class Stack implements Iterable {

	private ArrayList items;
	
	public Stack() {
		items = new ArrayList();
	};

	public void push(Object item) {
		items.add(item);
	};
	
	public Object pop() {
		Object last = items.getLast();
		items.removeLast();
		return last;
	};
	
	public boolean isEmpty() {
		return items.isEmpty();
	};
	
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new StackIterator();
	}
	
//	public class StackIterator implements Iterator {
	private class StackIterator implements Iterator {

		private int i = 0;
		
		@Override
		public boolean hasNext() {
			return i < items.size();
		}

		@Override
		public Object next() {
			if (!hasNext()) {
				throw new java.util.NoSuchElementException();
			}
			return items.get(i++);
		}
		
	}
}
