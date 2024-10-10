package practica4.ej4;

public class Test {
	
	public static void main (String[] args) {
		
		 Facultad facultad = new Facultad();

	        facultad.agregarAlumno(new Alumno("1", "Pablo", "Gomez", 20, "Laboratorio de Software", 8.5));
	        facultad.agregarAlumno(new Alumno("2", "Pedro", "Martinez", 22, "Algoritmos", 9.0));
	        facultad.agregarAlumno(new Alumno("3", "Maria", "Perez", 21, "Matemáticas", 7.5));
	        facultad.agregarAlumno(new Alumno("4", "Patricia", "Rodriguez", 19, "Laboratorio de Software", 9.8));

	        System.out.println("Estudiante con mayor nota: " + facultad.obtenerAlumnoMayorNota());

	        System.out.println("Dos estudiantes de la lista:"); facultad.imprimirDos();

	        System.out.println("Estudiante que tomó el curso 'Laboratorio de Software':" + facultad.obtenerLaboratorio());

	        System.out.println("Alumnos cuyo nombre empieza con 'P' y longitud menor o igual a 6:");
	        
	        facultad.obtenerMatching().forEach(System.out::println);
	        
	        System.out.println("Ordenar por nota:");
	        
	        facultad.ordenarPorNota();
	        
	        facultad.getAlumnos().forEach(System.out::println);
		
	}

}
