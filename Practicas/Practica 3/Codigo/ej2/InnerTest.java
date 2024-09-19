package practica3.ej2;

import practica3.ej2.InnerStatic.Circulo;

public class InnerTest {

	public static void main(String[] args) {
		
		for (int i = 0; i < 5; i++) {
			Circulo.setRadio();
			Circulo.getArea();
			Circulo.getLongitudCircunferencia();
		}
	}

}
