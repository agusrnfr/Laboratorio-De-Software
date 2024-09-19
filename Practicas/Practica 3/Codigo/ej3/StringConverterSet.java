package practica3.ej3;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class StringConverterSet extends AbstractSet{
	private ArrayList set;
	
	public StringConverterSet() {
		set = new ArrayList();
	}
	
	@Override
	public boolean add (Object elem) {
		return set.add(elem);
		
	}
	
	@Override
	public boolean addAll(Collection c) {
		return set.addAll(c);

	}
	
	
	@Override
	public void clear() {
		set.clear();
	}
	
	@Override
	public boolean contains(Object o) {
		return set.contains(o);
	}
	
	@Override
	public boolean containsAll (Collection c) {
		return set.containsAll(c);
	}
	
	@Override
	public boolean equals(Object o) {
		return set.equals(o);
	}
	
	@Override
	public int hashCode() {
		return set.hashCode();
	}
	
	@Override
	public boolean isEmpty() {
		return set.isEmpty();
	}
	
	@Override
	public boolean remove(Object o) {
		return set.remove(o);
	}
	
	@Override
	public boolean removeAll(Collection c) {
		return set.remove(c);
	}
	
	@Override
	public boolean retainAll(Collection c) {
		return set.retainAll(c);
	}
	
	
	@Override
	public int size() {
		return set.size();
	}

	@Override
	public Iterator iterator() {
		return new IteratorStringAdapter();
	}
	
	private class IteratorStringAdapter implements Iterator{
		
		private int i = 0;

		@Override
		public boolean hasNext() {
			return i < size();
		}

		@Override
		public String next() {
			String str = set.get(i).toString();
			i++;
			return str;
		}
		
	}
	
	
	
}
