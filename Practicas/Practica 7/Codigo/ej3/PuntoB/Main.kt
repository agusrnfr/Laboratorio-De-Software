import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import kotlin.random.Random

class Corredor(val name: String): Callable<String>{
    val cant = 100

    override fun call(): String {
        for (i in 1..cant){
            if (Random.nextInt(100) == 0) {
                return "El corredor ${this.name} abandono la carrera"
            }
            if (Random.nextInt(1000) == 0) {
                throw RuntimeException("EL CORREDOR ${this.name} PALMO")
            }
            println("El hilo ${this.name} avanzó $i metros")
        }
        return "El corredor ${this.name} completo la carrera"
    }
}

fun main() {

    val ejecutor: ExecutorService = Executors.newFixedThreadPool(5)

    println("Con calleable")
    print("Ingrese la cantidad de participantes: ")
    val participantes = readln().toInt()

    val lista = mutableListOf<Corredor>()
    for (i in 1..participantes) {
        lista.add(Corredor("$i"))
    }

    val futuros = lista.map { ejecutor.submit(it) } //submit recibe una subclase de callable (puede recibir un runnable).
                                        // y retorna un futuro que wrappea el resultado real que puede que todavia no exista todavía

    ejecutor.shutdown()

    for (futuro in futuros) {
        try {
            println(futuro.get()) // esto bloquea al hilo main y espera por el resultado.
        }catch (e: Exception) {
            println("ERROR: ${e.message}")
        }
    }
}