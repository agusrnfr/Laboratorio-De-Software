package repaso.parcial.primero;

public class RangoInteger {
	private final int limiteInferior;
	private final int limiteSuperior;
	
	public RangoInteger(int limiteInferior, int limiteSuperior) {
		this.limiteInferior = limiteInferior;
		this.limiteSuperior = limiteSuperior;
	}
	

	public int getLimiteInferior() {
		return limiteInferior;
	}


	public int getLimiteSuperior() {
		return limiteSuperior;
	}

	public boolean estaEnRango(int value) {
		return value >= this.limiteInferior && value <= this.limiteSuperior;
	}

	@Override
	public String toString() {
		return "["+limiteInferior + " - " + limiteSuperior + "]\n";
	}
	
	
	
	
}
