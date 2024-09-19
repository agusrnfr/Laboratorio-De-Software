package practica2.ej2;

import java.util.Arrays;

public class PaintTest {

	public static void main(String[] args) {
		Paint paint = new Paint();
		paint.init();
		FiguraGeometrica paleta[] = paint.getPaleta();
		for (int i = 0; i < paleta.length; i++) {
			FiguraGeometrica figura = paleta[i];
			System.out.println("Area: " + figura.area());

			if (figura instanceof Circulo) {
				Circulo circulo = (Circulo) figura;
				System.out.println("Radio: " + circulo.getRadio());
			}
			
		}
		
		Arrays.sort(paleta);
		
		for (int i = 0; i < paleta.length; i++) {
			FiguraGeometrica figura = paleta[i];
			System.out.println("Area: " + figura.area());
		}
	}

}
