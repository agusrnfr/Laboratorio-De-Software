package repaso.parcial.primero;

public class RangoDouble {
	private double limiteInferior;
	private double limiteSuperior;
	
	RangoDouble(double limiteInferior, double limiteSuperior) {
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

	@Override
	public String toString() {
		return "["+limiteInferior + " - " + limiteSuperior + "]\n";
	}
	
}
