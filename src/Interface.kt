interface Movable{
    var speed: Int
    val model: String
    val number: String
    fun move()
    fun stop() {
        println("Останавливаемся...")
    }
}
class Car (
    override val model: String,
    override val number: String
) : Movable{
    override var speed = 60
    override fun move() {
        println("Едем на машине со скоростью $speed км/ч")
    }
}
class Aircraft (
    override val model: String,
    override val number: String
) : Movable{
    override var speed = 600
    override fun move() {
        println("Летим на самолете со скоростью $speed км/ч")
    }
    override fun stop() = println("Приземляемся...")
}
interface Worker{
    fun work()
}
interface Student{
    fun study()
}
class WorkingStudent(val name: String) : Worker, Student {
    override fun study() = println("$name учится")
    override fun work() = println("$name работает")
}
fun travel(obj: Movable) = obj.move()
interface VideoPlayable {
    fun play() = println("Play video")
}
interface AudioPlayable {
    fun play() = println("Play audio")
}
class MediaPlayer : VideoPlayable, AudioPlayable {
    override fun play() {
        println("Start playing")
        super<VideoPlayable>.play()
        super<AudioPlayable>.play()
    }
}
fun main() {
    val car: Movable = Car("LADA", "134LAD")
    val aircraft: Movable = Aircraft("Boeing", "737")
    travel(car)
    travel(aircraft)

    val pavel = WorkingStudent("Pavel")
    pavel.work()
    pavel.study()

    aircraft.move()
    aircraft.stop()

    val player = MediaPlayer()
    player.play()
}