package practica2.ej3;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class HashSetAgregados<E> extends ForwardingSet<E> {
	private int cantidadAgregados = 0;

	public HashSetAgregados() {
		super(new HashSet<>());
	}

	@Override
	public boolean add(E e) {
		cantidadAgregados++;
		return super.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		cantidadAgregados += c.size();
		return super.addAll(c);
	}

	public int getCantidadAgregados() {
		return cantidadAgregados;
	}
}
