package practica2.ej3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class HashSetAgregadosTest {
	
	public static void main(String[] args) {
		List<String> lista = new ArrayList<>();
		
		lista.add("1");
		lista.add("2");
		lista.add("3");
		
		
		HashSetAgregados<String> hashAgregados = new HashSetAgregados<String>();
		
		hashAgregados.addAll(lista);
		
		System.out.println(hashAgregados.getCantidadAgregados());
		
	}

}
