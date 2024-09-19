package practica3.ej5;

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

		return new Iterator() {

			private int i;
			// private int i = 0;

			{ // Bloque de inicializacion para inicializar valores de la clase anónima
				// (cuando se crea una instancia de la misma)
				i = 0;
			}

			@Override
			public boolean hasNext() {
				return !(items.size() == i + 1);
			}

			@Override
			public Object next() {
				i++;
				return items.get(i);
			}
		};
	}
}
