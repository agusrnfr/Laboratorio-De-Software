package practica4.ej1;

import java.util.Comparator;

public class Alumno implements Comparable<Alumno> {
	// el legajo, apellido y nombre y DNI.
	private String legajo;
	private String apellido;
	private String nombre;
	private String DNI;
	public static final Comparator<Alumno> COMPARADORAPELLIDONOMBRE = new ComparadorApellidoNombre();
	public static final  Comparator<Alumno> COMPARADORDNI = new ComparadorDNI();

	public Alumno() {

	}

	public Alumno(String legajo, String apellido, String nombre, String dNI) {
		super();
		this.legajo = legajo;
		this.apellido = apellido;
		this.nombre = nombre;
		DNI = dNI;
	}

	public String getLegajo() {
		return legajo;
	}

	public String getApellido() {
		return apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDNI() {
		return DNI;
	}

	@Override
	public String toString() {
		return "Legajo:" + legajo + ", Apellido:" + apellido + ", Nombre:" + nombre + ", DNI:" + DNI + ".\n";
	}

	@Override
	public int compareTo(Alumno a) { // COMPARADOR POR DEFECTO EN TREESET.
		return this.getLegajo().compareTo(a.getLegajo());
	}

	private static class ComparadorApellidoNombre implements Comparator<Alumno> {

		@Override
		public int compare(Alumno a1, Alumno a2) {
			int cmpTmp = a1.getApellido().compareTo(a2.getApellido());
			if (cmpTmp != 0)
				return cmpTmp;
			return a1.getNombre().compareTo(a2.getNombre());
		}

	}
	
	private static class ComparadorDNI implements Comparator<Alumno>{

		@Override
		public int compare(Alumno a1, Alumno a2) {
			return a1.getDNI().compareTo(a2.getDNI());
		}
		
	}

}
