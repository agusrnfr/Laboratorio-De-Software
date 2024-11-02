import java.awt.FlowLayout
import java.awt.Font
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.concurrent.TimeUnit
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JFrame.EXIT_ON_CLOSE
import javax.swing.JLabel
import kotlin.concurrent.thread
import kotlin.system.exitProcess

fun main() {
/*
    val title = JLabel("Time")
    val label = JLabel("00:00:00")
    val info = JLabel("Start the clock!")
    val buttonStart = JButton("Start")
    val buttonStop = JButton("Stop")
 */
    val title = JLabel("Time").apply {
        font = Font("Arial", Font.BOLD, 24)
    }
    val label = JLabel("00:00:00").apply {
        font = Font("Arial", Font.BOLD, 46)
    }
    val info = JLabel("Start the clock!")
    val buttonStart = JButton("Start").apply {
        font = Font("Arial", Font.PLAIN, 16)
    }
    val buttonPause = JButton("Pause").apply {
        font = Font("Arial", Font.PLAIN, 16)
    }
    val buttonStop = JButton("Stop").apply {
        font = Font("Arial", Font.PLAIN, 16)
    }
    var pause = false
    val clock = thread(start = false){
        try {
            info.text ="Clock running..."
            val formatter = DateTimeFormatter.ofPattern("HH:mm:ss")
            while(true){
                if (!pause) {
                    label.text= LocalDateTime.now().format(formatter)
                }
                TimeUnit.SECONDS.sleep(1) // Se pone fuera del if asi el hilo principal
            // puede volver a tener el control para actualizar el pause cuando se pausa.
            }
        }catch (e: InterruptedException){
            info.text="Clock ended."
            TimeUnit.SECONDS.sleep(1)
            exitProcess(0)
        }
    }
    buttonStart.addActionListener {
        if (!clock.isAlive) clock.start() }
    buttonPause.addActionListener {
        if (!pause){
            pause = true
            info.text="Clock paused."
        } else {
            pause = false
            info.text="Clock running...."
        }
    }
    buttonStop.addActionListener {
        clock.interrupt()
    }
    val frame = JFrame("Clock")
    frame.defaultCloseOperation = EXIT_ON_CLOSE
    frame.setSize(250,200)
    frame.contentPane.layout=FlowLayout()
    frame.contentPane.add(title)
    frame.contentPane.add(label)
    frame.contentPane.add(buttonStart)
    frame.contentPane.add(buttonPause)
    frame.contentPane.add(buttonStop)
    frame.contentPane.add(info)
    frame.isVisible = true
}

