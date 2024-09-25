package repaso.parcial.primero;

import java.security.InvalidParameterException;
import java.util.List;

public class Pelicula {
	private String titulo,pais;
	private List<Genero> genero;
	private ClasificacionEdad clasificacionEdad;
	private double puntuacion;
	private int reproducciones;
	private int anio;
	
	public Pelicula(String titulo, String pais, List<Genero> genero, ClasificacionEdad clasificacionEdad, double puntuacion,
			int reproducciones, int anio) {
		this.titulo = titulo;
		this.pais = pais;
		this.genero = genero;
		this.clasificacionEdad = clasificacionEdad;
		this.anio = anio;
		
		if ( (puntuacion < 0.0) || (puntuacion > 10.0) ){
			throw new InvalidParameterException();
		}
		
		this.puntuacion = puntuacion;
		
		if (reproducciones < 0) {
			throw new InvalidParameterException();
		}
		
		this.reproducciones = reproducciones;
	}
	

	public String getTitulo() {
		return titulo;
	}

	public String getPais() {
		return pais;
	}


	public List<Genero> getGenero() {
		return genero;
	}



	public ClasificacionEdad getClasificacionEdad() {
		return clasificacionEdad;
	}



	public double getPuntuacion() {
		return puntuacion;
	}



	public int getReproducciones() {
		return reproducciones;
	}
	
	public int getAnio() {
		return this.anio;
	}


	@Override
	public String toString() {
		return "Titulo:" + titulo + ", pais:" + pais +  ", genero:" + genero + ", clasificacionEdad:" + clasificacionEdad
				+ ", puntuacion:" + puntuacion + ", reproducciones:" + reproducciones + ", anio:" + anio + ".\n";
	}
}
