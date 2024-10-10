package practica4.ej1;

import java.util.SortedSet;

public class Test {

	public static void main(String[] args) {
		
		Materia materia = new Materia("DBD");
		
        materia.agregarAlumno(new Alumno("003", "Pérez", "Juan", "12345678"));
        materia.agregarAlumno(new Alumno("004", "Gómez", "Ana", "23456789"));
        materia.agregarAlumno(new Alumno("001", "Rodríguez", "Carlos", "34567890"));
        materia.agregarAlumno(new Alumno("006", "Fernández", "Lucía", "45678901"));
        materia.agregarAlumno(new Alumno("005", "López", "María", "56789012"));
        materia.agregarAlumno(new Alumno("002", "Martínez", "Jorge", "67890123"));
        materia.agregarAlumno(new Alumno("008", "Sánchez", "Paula", "78901234"));
        materia.agregarAlumno(new Alumno("007", "González", "Pedro", "89012345"));
        materia.agregarAlumno(new Alumno("010", "Ramírez", "Carla", "90123456"));
        materia.agregarAlumno(new Alumno("009", "Gutiérrez", "Sofía", "01234567"));
        
        SortedSet<Alumno> listaAlumnos = materia.getAlumnos();
        
        for (Alumno alumno: listaAlumnos) {
        	System.out.println(alumno.toString());
        }

	}

}
