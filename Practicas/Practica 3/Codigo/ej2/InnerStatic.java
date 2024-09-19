package practica3.ej2;

import java.util.Scanner;
import static java.lang.Math.pow;

class InnerStatic {

	static double PI = 3.1416;

	static class Circulo {
		static double radio;

		static void setRadio() {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Introduce el valor del radio: ");
			radio = scanner.nextDouble();
		}

		static double getArea() {
			double a = PI * pow(radio, 2);
			System.out.println("El área es: " + a);
			return a;
		}

		static double getLongitudCircunferencia() {
			double l = 2 * PI * radio;
			System.out.println("La longitud es: " + l);
			return l;
		}

	}
}
