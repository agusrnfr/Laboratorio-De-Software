package practica2.ej4;

public class Rectangulo extends FiguraGeometrica {
	private int alto;
	private int ancho;

	public Rectangulo() {
	};

	public Rectangulo(int alto, int ancho) {
		this.alto = alto;
		this.ancho = ancho;
	};

	@Override
	public void dibujar() {
		StringBuffer str = new StringBuffer("Se dibuja un rectangulo de ");
		str.append(this.alto);
		str.append(" alto, ");
		str.append(this.ancho);
		str.append(" ancho y tiene un color ");
		str.append(this.getColor());
		str.append(".");
		System.out.println(str.toString());
	}

	@Override
	public int area() {
		return this.alto * this.ancho;
	}

}
