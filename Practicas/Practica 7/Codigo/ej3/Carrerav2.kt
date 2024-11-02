import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future
import kotlin.random.Random

fun main(){

    val metros = 100
    val corredores = 5
    val ejecutor = Executors.newFixedThreadPool(5)
    val listaFuture: MutableList<Future<String>> = mutableListOf()

    for (i in 1..corredores) {
        val futuro = ejecutor.submit(Callable{
            val id = i
            for (j in 1..metros){

                if (Random.nextInt(100) == 0){
                    return@Callable "El corredor $id abandono la carrera"
                }

                if (Random.nextInt(100000) == 0){
                    throw Exception ("El corredor $id murio")
                }

                println("El corredor $id avanzo $j metros")
            }
            return@Callable "El corredor $id finalizo la carrera"
        })
        listaFuture.add(futuro)
    }

    ejecutor.shutdown()

    for (futuro in listaFuture){
        try{
            println(futuro.get())
        }catch(e:Exception){
            println(e.message)
        }
    }
}