package practica2.ej4;

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
		;

	}

}
