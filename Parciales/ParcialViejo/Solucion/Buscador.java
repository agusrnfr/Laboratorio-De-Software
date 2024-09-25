package repaso.parcial.primero;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Buscador {
	private List<Pelicula> peliculas;
	public static final Buscador INSTANCE = new Buscador();
	public static final Comparator<Pelicula> COMPARADOR_TITULO = new ComparadorTitulo();
	public static final Comparator<Pelicula> COMPARADOR_CLASIFICACION = new ComparadorClasificacion();
	public static final Comparator<Pelicula> COMPARADOR_VALORACION = new ComparadorValoracion();
	public static final Comparator<Pelicula> COMPARADOR_REPRODUCCIONES = new ComparadorReproducciones();
	public static final Comparator<Pelicula> COMPARADOR_ANIO = new ComparadorAnio();

	private Buscador() {
		peliculas = new ArrayList<>();
	}

	public void agregarPelicula(Pelicula pelicula) {
		this.peliculas.add(pelicula);
	}

	// SELECCIONAR CON COMPARADOR PERSONALIZADO
	public List<Pelicula> seleccionar(Genero g, ClasificacionEdad ce, Rango valoracion, Rango reproduccion,
			Comparator<Pelicula> comp) {
		return this.peliculas.stream()
				.filter(pelicula -> pelicula.getGenero().contains(g) && pelicula.getClasificacionEdad().equals(ce))
				.filter(pelicula -> valoracion.estaEnRango(pelicula.getPuntuacion()))
				.filter(pelicula -> reproduccion.estaEnRango(pelicula.getReproducciones()))
				.sorted(comp).collect(Collectors.toList());
	}

	// SELECCIONAR CON COMPARADOR POR DEFECTO
	public List<Pelicula> seleccionar(Genero g, ClasificacionEdad ce, Rango valoracion,
			Rango reproduccion) {
		return this.peliculas.stream()
				.filter(pelicula -> pelicula.getGenero().contains(g) && pelicula.getClasificacionEdad().equals(ce))
				.filter(pelicula -> valoracion.estaEnRango(pelicula.getPuntuacion()))
				.filter(pelicula -> reproduccion.estaEnRango(pelicula.getReproducciones()))
				.sorted(COMPARADOR_TITULO).collect(Collectors.toList());
	}

	// SELECCIONAR CON COMPARADOR POR DEFECTO Y SIN FILTRO
	public List<Pelicula> seleccionar() {
		return this.peliculas.stream().sorted(COMPARADOR_TITULO).collect(Collectors.toList());
	}

	// SELECCIONAR CON COMPARADOR PERSONALIZADO Y SIN FILTRO
	public List<Pelicula> seleccionar(Comparator<Pelicula> comp) {
		return this.peliculas.stream().sorted(comp).collect(Collectors.toList());
	}

	private static class ComparadorTitulo implements Comparator<Pelicula> {

		@Override
		public int compare(Pelicula p1, Pelicula p2) {
			return p1.getTitulo().compareTo(p2.getTitulo());
		}

	}

	private static class ComparadorClasificacion implements Comparator<Pelicula> {

		@Override
		public int compare(Pelicula p1, Pelicula p2) {
			return p1.getClasificacionEdad().getEdadMinima() - p2.getClasificacionEdad().getEdadMinima();
		}

	}

	private static class ComparadorValoracion implements Comparator<Pelicula> {

		@Override
		public int compare(Pelicula p1, Pelicula p2) {
			if (p1.getPuntuacion() < p2.getPuntuacion()) {
				return -1;
			} else if (p1.getPuntuacion() > p2.getPuntuacion()) {
				return 1;
			} else
				return 0;
		}
	}

	private static class ComparadorReproducciones implements Comparator<Pelicula> {

		@Override
		public int compare(Pelicula p1, Pelicula p2) {
			return p1.getReproducciones() - p2.getReproducciones();
		}
	}

	private static class ComparadorAnio implements Comparator<Pelicula> {

		@Override
		public int compare(Pelicula p1, Pelicula p2) {
			return p1.getAnio() - p2.getAnio();
		}
	}

	// podrian sacarse las variables de instancia de los comparadores y hacer a los
	// mismos un enum con INSTANCE, pero no me gusta mucho esa solucion
}
