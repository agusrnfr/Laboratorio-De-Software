package practica1.ej1;
import java.util.Scanner;

public class TestVacuna {

	public static void main(String[] args) {
		Vacuna arregloVacunas[] = new Vacuna[5];
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner (System.in);
		
		for (int i=0; i<arregloVacunas.length; i++) {
			Vacuna vacuna = new Vacuna();
			
			System.out.println("Nueva Vacuna \n");
			System.out.println("Ingrese la marca: \n");
			vacuna.setMarca(entrada.next());
			
			System.out.println("Ingrese el pais de origen: \n");
			vacuna.setPaisDeOrigen(entrada.next());

			System.out.println("Ingrese la enfermedad que previene: \n");
			vacuna.setEnfermedadPreviene(entrada.next());

			System.out.println("Ingrese la cantidad de dosis: \n");
			vacuna.setCantidadDosis(entrada.nextInt());
			
			arregloVacunas[i] = vacuna;

		}
			  
		for (int i=0; i<arregloVacunas.length; i++) { 
			System.out.println(arregloVacunas[i].toString());
		}
		
		Vacuna vacuna1 = new Vacuna("a", "a", "a", 1);
		Vacuna vacuna2 = new Vacuna("a", "a", "a", 1);
		
		System.out.println(vacuna1.equals(vacuna2));
		System.out.println(vacuna1 == vacuna2);
	}

}
