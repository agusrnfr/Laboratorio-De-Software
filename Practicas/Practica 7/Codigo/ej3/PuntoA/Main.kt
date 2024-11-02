import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

fun main() {

    val ejecutor = Executors.newFixedThreadPool(5)
    val cant = 100
    val anyLock = Any()
    var alguienGano = false
    var ganador = -1

    println("Con ejecutor")
    print("Ingrese la cantidad de participantes: ")
    val participantes = readln().toInt()

    for (i in 1..participantes){
        ejecutor.execute{
            for (j in 1..cant){
                println("El hilo $i avanzó $j metros")
                if (j == cant) {
                    synchronized(anyLock){
                        if (!alguienGano) {
                            alguienGano = true
                            ganador = i
                        }
                    }
                }
            }
        }
    }

    ejecutor.shutdown()

    try{
        ejecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS)
    } catch (_: InterruptedException){
    }finally {
        println("El ganador es $ganador")
    }
}