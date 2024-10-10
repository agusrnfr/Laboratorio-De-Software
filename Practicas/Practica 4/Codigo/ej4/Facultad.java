package practica4.ej4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Facultad {
	private List<Alumno> listaAlumnos;
	
	public Facultad() {
		this.listaAlumnos = new ArrayList<>();
	}
	
	public void agregarAlumno(Alumno a) {
		this.listaAlumnos.add(a);
	}
	
	public List<Alumno> getAlumnos(){
		return this.listaAlumnos;
	}
	
	public Alumno obtenerAlumnoMayorNota() {
        //return Collections.max(listaAlumnos,Comparator.comparingDouble(Alumno::getNotaAprobacion));
		
		return this.listaAlumnos.stream().max(Comparator.comparingDouble(Alumno::getNotaAprobacion)).orElse(null);
    }
	
	public void imprimirDos(){
		this.listaAlumnos.stream().limit(2).forEach(System.out::println);
		
		//this.listaAlumnos.subList(0, Math.min(2, this.listaAlumnos.size())).forEach(System.out::println);
		
	}
	
	public Alumno obtenerLaboratorio(){
		return this.listaAlumnos.stream().filter((alumno)-> alumno.getMateriaAprobada().equals("Laboratorio de Software")).findFirst().orElse(null);
	}
	
	public List<Alumno> obtenerMatching(){
		return this.listaAlumnos.stream().filter((alumno)-> alumno.getNombre().toLowerCase().charAt(0) == 'p').filter((alumno)->alumno.getNombre().length() <= 6).collect(Collectors.toList());
	}
	
	public void ordenarPorNota() {
//		this.listaAlumnos.sort(new Comparator<Alumno>(){
//			
//			@Override
//			public int compare(Alumno o1, Alumno o2) {
//				if (o1.getNotaAprobacion() < o2.getNotaAprobacion())
//					return 1;
//				else if (o1.getNotaAprobacion() > o2.getNotaAprobacion())
//					return -1;
//				else 
//					return 0;
//			}
//		});
//		
//		listaAlumnos.sort((a1,a2) -> Double.compare(a2.getNotaAprobacion(), a1.getNotaAprobacion()));
//		
//		listaAlumnos.sort(Comparator.comparingDouble((Alumno a)->a.getNotaAprobacion()).reversed());
//		
		listaAlumnos.sort(Comparator.comparingDouble(Alumno::getNotaAprobacion));
		
	}
}
