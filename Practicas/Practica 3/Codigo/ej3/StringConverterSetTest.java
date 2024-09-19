package practica3.ej3;

import java.util.Iterator;

public class StringConverterSetTest {

	public static void main(String[] args) {
		StringConverterSet scs = new StringConverterSet();
		scs.add(1);
		scs.add(2);
		scs.add(3);
		scs.add("hola");
		
        Iterator i = scs.iterator();

        while (i.hasNext()) System.out.println(i.next());
        for (Object s: scs) System.out.println(s);
	}

}