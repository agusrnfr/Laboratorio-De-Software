package repaso.parcial.primero;

public class Rango {
	private double limiteInferior;
	private double limiteSuperior;
	
	Rango(double limiteInferior, double limiteSuperior) {
		this.limiteInferior = limiteInferior;
		this.limiteSuperior = limiteSuperior;
	}
	

	public double getLimiteInferior() {
		return limiteInferior;
	}


	public double getLimiteSuperior() {
		return limiteSuperior;
	}

	public boolean estaEnRango(double value) {
		return value >= this.limiteInferior && value <= this.limiteSuperior;
	}
	
	public boolean estaEnRango(int value) {
		return value >= (int) this.limiteInferior && value <= (int) this.limiteSuperior;
	}

	@Override
	public String toString() {
		return "["+limiteInferior + " - " + limiteSuperior + "]\n";
	}
	
}
