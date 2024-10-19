package practica5.ej2;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.*;

public class MapToFileSystem {

	public static void beanToFS(Object object) {
		try {
			Class<?> testClass = object.getClass();
			Archivo annotation = testClass.getAnnotation(Archivo.class);
			if (annotation != null) {
				StringBuilder content = new StringBuilder();
				content.append("<nombreClase>" + testClass.getSimpleName() + "</nombreClase>\n");
				for (Field f : testClass.getDeclaredFields()) {
					if (f.isAnnotationPresent(AlmacenarAtributo.class)) {
						f.setAccessible(true);
						content.append("<nombreAtributo>" + f.getName() + "</nombreAtributo>\n");
						content.append("<nombreValor>" + f.get(object) + "</nombreValor>\n");
					}
				}
				String name = (annotation.nombre() != null && !annotation.nombre().isEmpty()) ? annotation.nombre()
						: testClass.getSimpleName() + ".txt";
				FileWriter fw = new FileWriter(name);
				fw.write(content.toString());
				fw.close();
			}else {
				System.out.println("La clase no tiene la anotacion @Archivo");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (IllegalAccessException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		Mapeado mapeado = new Mapeado();
		MapToFileSystem.beanToFS(mapeado);

	}
}
