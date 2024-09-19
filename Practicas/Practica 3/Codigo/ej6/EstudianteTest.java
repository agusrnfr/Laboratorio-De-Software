package practica3.ej6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class EstudianteTest {

	public static void main(String[] args) {
		Estudiante e1 = new Estudiante("Rojas", "Agustina", "1234", 21, 27);
		Estudiante e2 = new Estudiante("Del Rey", "Lana", "4321", 39, 34);
		Estudiante e3 = new Estudiante("Swift", "Taylor", "1111", 34, 22);
		Estudiante e4 = new Estudiante("Amos", "Tori", "2222", 63, 28);
		Estudiante e5 = new Estudiante("Lee", "Amy", "3333", 43, 14);
		Estudiante e6 = new Estudiante("Cooke", "Olivia", "9999", 30, 29);
		Estudiante e7 = new Estudiante("Purnell", "Ella", "1212", 28, 3);
		Estudiante e8 = new Estudiante("Raz", "Agustina", "5555", 17, 0);
		
		
		Estudiante[] l = {e1,e2,e3,e4,e5,e6,e7,e8};
	
		
		//Ordenar por materias de forma ascendente
		
		Arrays.sort(l, new Comparator<Estudiante>() {
			@Override
			public int compare(Estudiante o1, Estudiante o2) {
				return o1.getMateriasAprobadas() - o2.getMateriasAprobadas();
			}
		});
		
		System.out.println("Materias Aprobadas:");
		
		for (Estudiante e: l) {
			System.out.println(e);
		}
		
		//Ordenar por edad en forma descendente
		
		Arrays.sort(l, new Comparator<Estudiante>() {
			@Override
			public int compare(Estudiante o1, Estudiante o2) {
				return o2.getEdad() - o1.getEdad();
			}
		});
		
		System.out.println("Edad:");
		
		for (Estudiante e: l) {
			System.out.println(e);
		}
		
		//Ordenar por legajo en forma ascendente
		
		Arrays.sort(l, new Comparator<Estudiante>() {
			@Override
			public int compare(Estudiante o1, Estudiante o2) {
				return o1.getLegajo().compareTo(o2.getLegajo());
			}
		});
		
		System.out.println("Legajo:");
		
		for (Estudiante e: l) {
			System.out.println(e);
		}
		
		//Ordenar por nombre y apellido en forma descendente
		
		Arrays.sort(l, new Comparator<Estudiante>() {
			@Override
			public int compare(Estudiante o1, Estudiante o2) {
				int aux = o2.getNombre().compareTo(o1.getNombre());
				return aux != 0? aux : o2.getApellido().compareTo(o1.getApellido());
			}
		});
		
		System.out.println("Nombre y apellido:");
		
		for (Estudiante e: l) {
			System.out.println(e);
		}	

	}

}
