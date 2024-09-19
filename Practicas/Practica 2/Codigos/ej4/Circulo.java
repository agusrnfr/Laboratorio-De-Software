package practica2.ej4;

public class Circulo extends FiguraGeometrica {
	private int radio;

	public Circulo() {
	};

	@Override
	public void dibujar() {
		StringBuffer str = new StringBuffer("Se dibuja un circulo con radio ");
		str.append(this.radio);
		str.append(" y tiene un color ");
		str.append(this.getColor());
		str.append(".");
		System.out.println(str.toString());
	}

	@Override
	public int area() {
		return (int) (Math.PI * Math.pow(this.radio, 2));
	}

	public int getRadio() {
		return radio;
	}

	public void setRadio(int radio) {
		this.radio = radio;
	}

}
