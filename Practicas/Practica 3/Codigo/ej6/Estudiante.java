package practica3.ej6;

public class Estudiante {
	private String apellido;
	private String nombre;
	private String legajo;
	private int edad;
	private int materiasAprobadas;
	
	public Estudiante(String apellido, String nombre, String legajo, int edad, int materiasAprobadas) {
		super();
		this.apellido = apellido;
		this.nombre = nombre;
		this.legajo = legajo;
		this.edad = edad;
		this.materiasAprobadas = materiasAprobadas;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLegajo() {
		return legajo;
	}

	public void setLegajo(String legajo) {
		this.legajo = legajo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getMateriasAprobadas() {
		return materiasAprobadas;
	}

	public void setMateriasAprobadas(int materiasAprobadas) {
		this.materiasAprobadas = materiasAprobadas;
	}

	@Override
	public String toString() {
		return "Estudiante [apellido=" + apellido + ", nombre=" + nombre + ", legajo=" + legajo + ", edad=" + edad
				+ ", materiasAprobadas=" + materiasAprobadas + "]";
	}
	
	
	
	

}
