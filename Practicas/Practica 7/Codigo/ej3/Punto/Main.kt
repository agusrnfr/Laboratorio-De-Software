import kotlin.concurrent.thread

fun main() {
    var alguienGano : Boolean = false
    var ganador : Int = -1
    val anyLock = Any()
    val cant = 100
    val listaDeParticipantes = mutableListOf<Thread>()

    println("Sin ejecutor")
    print("Ingrese la cantidad de participantes: ")
    val participantes = readln().toInt()

    for (i in 1..participantes){
        val t = thread {
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
        listaDeParticipantes.add(t)
    }

    listaDeParticipantes.forEach { t -> t.join() }

    println("El ganador es $ganador")
}