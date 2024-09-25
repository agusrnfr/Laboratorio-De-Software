package repaso.parcial.primero;

import java.util.List;

public class BuscadorTest {

	public static void main(String[] args) {
		Buscador buscador = Buscador.INSTANCE;

		ClasificacionEdad clasificacionATP = ClasificacionEdad.ATP;
		ClasificacionEdad clasificacionMAS13 = ClasificacionEdad.MAS13;
		ClasificacionEdad clasificacionMAS16 = ClasificacionEdad.MAS16;
		ClasificacionEdad clasificacionMAS18 = ClasificacionEdad.MAS18;

		buscador.agregarPelicula(
				new Pelicula("Evil Dead", "EEUU", List.of(Genero.FICCION), clasificacionMAS18, 7.5, 300, 1981));
		buscador.agregarPelicula(new Pelicula("Mulholland Drive", "EEUU", List.of(Genero.DRAMA, Genero.SUSPENSO),
				clasificacionMAS16, 8.5, 200, 2001));
		buscador.agregarPelicula(new Pelicula("The Others", "España", List.of(Genero.FICCION, Genero.SUSPENSO),
				clasificacionMAS13, 7.0, 150, 2001));
		buscador.agregarPelicula(new Pelicula("Moulin Rouge!", "Australia", List.of(Genero.MUSICAL, Genero.ROMANCE),
				clasificacionMAS13, 7.6, 180, 2001));
		buscador.agregarPelicula(
				new Pelicula("Dogville", "Dinamarca", List.of(Genero.DRAMA), clasificacionMAS16, 8.0, 120, 2003));
		buscador.agregarPelicula(
				new Pelicula("The Hours", "EEUU", List.of(Genero.DRAMA), clasificacionMAS13, 7.5, 150, 2002));
		buscador.agregarPelicula(
				new Pelicula("The Goldfinch", "EEUU", List.of(Genero.DRAMA), clasificacionMAS16, 6.3, 100, 2019));
		buscador.agregarPelicula(new Pelicula("Australia", "Australia", List.of(Genero.DRAMA, Genero.ROMANCE),
				clasificacionMAS13, 6.7, 140, 2008));
		buscador.agregarPelicula(new Pelicula("Imagine Me & You", "Reino Unido", List.of(Genero.ROMANCE, Genero.DRAMA),
				clasificacionMAS13, 7.0, 90, 2005));
		buscador.agregarPelicula(
				new Pelicula("Bottoms", "EEUU", List.of(Genero.DRAMA), clasificacionMAS16, 6.5, 60, 2023));
		buscador.agregarPelicula(new Pelicula("Shrek", "EEUU", List.of(Genero.ROMANCE, Genero.FANTASIA),
				clasificacionATP, 7.9, 500, 2001));
		buscador.agregarPelicula(new Pelicula("Tár", "EEUU", List.of(Genero.DRAMA), clasificacionMAS16, 8.1, 75, 2022));
		buscador.agregarPelicula(new Pelicula("Carol", "EEUU", List.of(Genero.DRAMA, Genero.ROMANCE),
				clasificacionMAS16, 8.0, 110, 2015));
		buscador.agregarPelicula(
				new Pelicula("Halloween", "EEUU", List.of(Genero.FICCION), clasificacionMAS18, 7.8, 400, 1978));
		buscador.agregarPelicula(new Pelicula("Lake Mungo", "Australia", List.of(Genero.SUSPENSO, Genero.FICCION),
				clasificacionMAS16, 6.3, 80, 2008));
		buscador.agregarPelicula(new Pelicula("Psicosis", "EEUU", List.of(Genero.SUSPENSO, Genero.FICCION),
				clasificacionMAS18, 8.5, 600, 1960));

		Rango rangoValoracion = new Rango(7.5, 10.0);
		Rango rangoReproducciones = new Rango(0, 300);

		System.out.println("Ordenando por valoracion...\n");

		 List<Pelicula> peliculasFiltradas = buscador.seleccionar(Genero.FICCION,
		 clasificacionMAS18, rangoValoracion, rangoReproducciones,
		 Buscador.COMPARADOR_VALORACION);

//		List<Pelicula> peliculasFiltradas = buscador.seleccionar(Buscador.COMPARADOR_VALORACION);

		for (Pelicula pelicula : peliculasFiltradas) {
			System.out.println(pelicula);
		}

		System.out.println("Ordenando por titulo...\n");

		// peliculasFiltradas = buscador.seleccionar(Genero.DRAMA, clasificacionMAS13,
		// rangoValoracion, rangoReproducciones);

		peliculasFiltradas = buscador.seleccionar();

		for (Pelicula pelicula : peliculasFiltradas) {
			System.out.println(pelicula);
		}

		System.out.println("Ordenando por anio...\n");

		// peliculasFiltradas = buscador.seleccionar(Genero.DRAMA, clasificacionMAS13,
		// rangoValoracion, rangoReproducciones, Buscador.COMPARADOR_ANIO);

		peliculasFiltradas = buscador.seleccionar(Buscador.COMPARADOR_ANIO);
		for (Pelicula pelicula : peliculasFiltradas) {
			System.out.println(pelicula);
		}

		System.out.println("Ordenando por reproduccion...\n");

		// peliculasFiltradas = buscador.seleccionar(Genero.DRAMA, clasificacionMAS13,
		// rangoValoracion, rangoReproducciones, Buscador.COMPARADOR_REPRODUCCIONES);

		peliculasFiltradas = buscador.seleccionar(Buscador.COMPARADOR_REPRODUCCIONES);

		for (Pelicula pelicula : peliculasFiltradas) {
			System.out.println(pelicula);
		}

		System.out.println("Ordenando por clasificacion...\n");

		// peliculasFiltradas = buscador.seleccionar(Genero.DRAMA, clasificacionMAS13,
		// rangoValoracion, rangoReproducciones, Buscador.COMPARADOR_CLASIFICACION);

		peliculasFiltradas = buscador.seleccionar(Buscador.COMPARADOR_CLASIFICACION);
		for (Pelicula pelicula : peliculasFiltradas) {
			System.out.println(pelicula);
		}
	}

}
