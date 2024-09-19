package practica2.ej2;

public class Paint {
	private FiguraGeometrica paleta[];

	public Paint() {
	};

	public FiguraGeometrica[] getPaleta() {
		return paleta;
	}

	public void setPaleta(FiguraGeometrica[] paleta) {
		this.paleta = paleta;
	}

	public void init() {
		Rectangulo rectangulo1 = new Rectangulo(2, 3);
		rectangulo1.setColor("verde");
		Rectangulo rectangulo2 = new Rectangulo(4, 10);
		rectangulo2.setColor("rojo");
		Circulo circulo1 = new Circulo();
		circulo1.setRadio(2);
		circulo1.setColor("azul");
		Circulo circulo2 = new Circulo();
		circulo2.setRadio(3);
		circulo2.setColor("amarillo");

		paleta = new FiguraGeometrica[4];
		paleta[0] = rectangulo1;
		paleta[1] = rectangulo2;
		paleta[2] = circulo1;
		paleta[3] = circulo2;

	}
}
