package practica4.ej4;

public class Alumno {
	private String legajo;
	private String nombre;
	private String apellido;
	private int edad;
	private String materiaAprobada;
	private double notaAprobacion;
	
	public Alumno(String legajo, String nombre, String apellido, int edad, String materiaAprobada,
			double notaAprobacion) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.materiaAprobada = materiaAprobada;
		this.notaAprobacion = notaAprobacion;
	}
	public String getLegajo() {
		return legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public int getEdad() {
		return edad;
	}

	public String getMateriaAprobada() {
		return materiaAprobada;
	}

	public double getNotaAprobacion() {
		return notaAprobacion;
	}
	@Override
	public String toString() {
		return "Legajo:" + legajo + ", nombre:" + nombre + ", apellido:" + apellido + ", edad:" + edad
				+ ", materiaAprobada:" + materiaAprobada + ", notaAprobacion:" + notaAprobacion + ".\n";
	}
	
	
}
