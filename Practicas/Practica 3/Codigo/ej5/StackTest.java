package practica3.ej5;

import java.util.Iterator;

// import practica3.ej1.Stack.StackIterator;

public class StackTest {

	public static void main(String[] args) {
		
		Stack stack = new Stack();
		stack.push("Hola");
		stack.push("soy");
		stack.push("Antonio");
		stack.push(":3c");
		
		for (Object str: stack) {
			System.out.println((String) str);
		}
		
		for (Object str: stack) {
			System.out.println((String) str);
		}
		
//		Iterator s = stack.new StackIterator();
	}

}
