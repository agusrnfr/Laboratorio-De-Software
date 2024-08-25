package practica1.ej5;

public class PoolConexiones {
	private PoolConexiones() {
	}

	private static class instancePool {
		private static final PoolConexiones INSTANCE = new PoolConexiones();
	}

	public static PoolConexiones getPoolConexiones() {
		return instancePool.INSTANCE;
	}
}
