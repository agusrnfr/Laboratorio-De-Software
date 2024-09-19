package practica3.ej7;

public class FitoPaezTest {

	public static void main(String[] args) {

		Notas[] notas = { Notas.DO, Notas.FA, Notas.SOL, Notas.DO, Notas.FA, Notas.SOL, Notas.DO, Notas.FA, Notas.SOL,
				Notas.DO, Notas.FA, Notas.SOL, Notas.DO, Notas.FA, Notas.SOL, Notas.DO, Notas.FA, Notas.SOL, Notas.DO,
				Notas.FA, Notas.SOL, Notas.DO, Notas.FA, Notas.SOL };

		int[] tiempos = new int[24];

		for (int i = 0; i < tiempos.length; i++) {
			tiempos[i] = 2;
		}

		FitoPaez.INSTANCE.tocarCancion(notas, tiempos);
	}

}
