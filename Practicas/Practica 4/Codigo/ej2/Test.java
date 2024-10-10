package practica4.ej2;

public class Test {

	public static void main(String[] args) {
//		Veterinaria <Animal> vet = new Veterinaria <Gato>();
//		Veterinaria <Gato> vet = new Veterinaria <Animal>();
//		Veterinaria <?> vet = new Veterinaria<Gato>();
//		vet.setAnimal(new Gato());
//		Veterinaria vet = new Veterinaria ();
//		vet.setAnimal(new Perro());
//		Veterinaria vet = new Veterinaria <?>();
		Veterinaria<? extends Animal> vet = new Veterinaria<Gato>();

	}

}
