package practica4.ej1;

import java.util.SortedSet;
import java.util.TreeSet;

public class Materia {
	private String nombre;
	private SortedSet<Alumno> lista;
	
	public Materia(String nombre){
		this.nombre = nombre;
		//this.lista = new TreeSet<>();
		//this.lista = new TreeSet<>(Alumno.COMPARADORAPELLIDONOMBRE);
		this.lista = new TreeSet<>(Alumno.COMPARADORDNI);
	}
	
	public void agregarAlumno (Alumno a) {
		this.lista.add(a);
	}
	
	public SortedSet<Alumno> getAlumnos(){
		return this.lista;
	}

}
