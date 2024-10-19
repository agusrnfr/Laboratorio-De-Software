package practica5.ej3;

@Servidor(direccion="localhost",puerto=5050,archivo="prueba.txt")
public class ClaseCualquiera {
	
	@Invocar
	public void metodoInvocado1() {
		System.out.println("Me invocaron 1");
	}
	
	public void metodoNoInvocado1() {
		System.out.println("No Me invocaron 1");
	}
	
	@Invocar
	public void metodoInvocado2() {
		System.out.println("Me invocaron 2");
	}
	
	public void metodoNoInvocado2() {
		System.out.println("No Me invocaron 2");
	}
}
