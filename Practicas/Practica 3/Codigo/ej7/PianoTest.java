package practica3.ej7;

public class PianoTest {
	
	public static void main(String[] args) {
		Piano piano = new Piano();
		
		piano.afinar(FrecuenciasDeLA._444HZ);
		piano.afinar(FrecuenciasDeLA._440HZ);
		
		piano.hacerSonar(Notas.DO,10);
		piano.hacerSonar(Notas.LA,5);
	}

}
