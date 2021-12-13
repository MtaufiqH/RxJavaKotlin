import io.reactivex.Observable
import kotlin.math.pow
import kotlin.math.roundToInt

fun main() {
    exampleOf("range") {
        val observable = Observable.range(1, 10)
        observable.subscribe {
            val n = it.toDouble()
            val fibonacci = ((1.61803.pow(n) - 0.61803.pow(n)) / 2.23606).roundToInt()
            println("$n: $fibonacci")

        }

    }
}