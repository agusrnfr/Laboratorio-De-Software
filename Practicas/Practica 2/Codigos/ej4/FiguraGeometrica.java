package practica2.ej4;

import java.io.Serializable;

public abstract class FiguraGeometrica implements Serializable {
	private String color;

	public FiguraGeometrica() {
	};

	public abstract void dibujar();

	public abstract int area();

	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}
}
