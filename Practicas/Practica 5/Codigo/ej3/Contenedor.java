package practica5.ej3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpExchange;

public class Contenedor {

	public static void procesar(Object object) throws AnnotationServerNotFoundException {
		Class<?> testClass = object.getClass();
		Servidor anotacion = testClass.getAnnotation(Servidor.class);
		if (anotacion != null) {
			String direccion = anotacion.direccion();
			int puerto = anotacion.puerto();
			String archivo = anotacion.archivo();
			List<Method> metodosAInvocar = obtenerMetodos(testClass);
			try {
				iniciarServidor(direccion, puerto, archivo, metodosAInvocar, object);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
			throw new AnnotationServerNotFoundException("La clase no tiene la anotación @Servidor.");
		}
	}

	private static List<Method> obtenerMetodos(Class<?> testClass) {
		List<Method> listaARetornar = new ArrayList<>();
		for (Method m : testClass.getDeclaredMethods()) {
			if (m.isAnnotationPresent(Invocar.class)) {
				listaARetornar.add(m);
			}
		}
		return listaARetornar;
	}

	private static void iniciarServidor(String direccion, int puerto, String archivo, List<Method> listaMetodos,
			Object o) throws IOException {

		HttpServer server = HttpServer.create(new InetSocketAddress(direccion, puerto), 0);
		server.createContext("/", new Manejador(archivo, listaMetodos, o));
		server.createContext("/favicon.ico", new HttpHandler() {
			@Override
			public void handle(HttpExchange exchange) throws IOException {
				exchange.sendResponseHeaders(204, -1);
				exchange.close();
			}
		});
		server.setExecutor(null);
		server.start();
		System.out.println("Servidor iniciado en http://" + direccion + ":" + puerto);
	}

	private static class Manejador implements HttpHandler {
		private String archivo;
		private List<Method> listaMetodos;
		private Object o;

		public Manejador(String archivo, List<Method> listaMetodos, Object o) {
			this.archivo = archivo;
			this.listaMetodos = listaMetodos;
			this.o = o;
		}

		@Override
		public void handle(HttpExchange request) throws IOException {
			System.out.println("Manejador recibido: " + request.getRequestURI());
			this.invocar();
			this.logear(request);
			this.enviarRespuesta(request);
		}

		private void invocar() {
			for (Method m : listaMetodos) {
				try {
					m.invoke(o);
				} catch (IllegalAccessException e) {
					e.getMessage();
				} catch (InvocationTargetException e) {
					e.getMessage();
				}
			}
		}

		private void logear(HttpExchange request) throws IOException {
			String IP = request.getRemoteAddress().getAddress().getHostAddress();
			String fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			try (FileWriter fw = new FileWriter(archivo)) {
				fw.write(fechaHora + " " + IP + "\n");
			}
		}

		private void enviarRespuesta(HttpExchange request) throws IOException {
//			String response = "Esta es la respuesta";
//			request.sendResponseHeaders(200, response.length());
//			OutputStream os = request.getResponseBody();
//			os.write(response.getBytes());
//			os.close();
			
			File imageFile = new File("./img.jpg");

			// Verificar si el archivo existe
			if (!imageFile.exists()) {
				String response = "Imagen no encontrada";
				request.sendResponseHeaders(404, response.length());
				OutputStream os = request.getResponseBody();
				os.write(response.getBytes());
				os.close();
				return;
			}

			// Enviar la imagen
			FileInputStream fis = new FileInputStream(imageFile);
			byte[] imageBytes = new byte[(int) imageFile.length()];
			fis.read(imageBytes);
			fis.close();

			// Configurar el encabezado de respuesta
			request.getResponseHeaders().set("Content-Type", "image/png");
			request.sendResponseHeaders(200, imageBytes.length);
			OutputStream os = request.getResponseBody();
			os.write(imageBytes);
			os.close();
		}
	}

	public static void main(String[] args) {
		ClaseCualquiera clase = new ClaseCualquiera();

		try {
			procesar(clase);
		} catch (AnnotationServerNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
