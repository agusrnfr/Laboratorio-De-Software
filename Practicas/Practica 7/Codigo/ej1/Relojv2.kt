import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.concurrent.TimeUnit
import kotlin.concurrent.thread

// En consola

fun main(){

    var fin: Boolean = false

    val reloj = thread(start = false){
        while (!fin){
            print("\r" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")))
            TimeUnit.SECONDS.sleep(1)
        }
    }

    reloj.start()
    println("\u001B[4mRELOJ\u001B[0m")
    println("\u001B[3mSi desea finalizar el reloj, presione 'enter'\u001B[0m")
    readln()
    fin = true

}