import io.reactivex.Observable

fun main() {
//         example of sequence
    val sequence = sequenceOf(1, 2, 3)
    val iterator = sequence.iterator()
    while (iterator.hasNext()) {
        println(iterator.next())
    }

    /** Create Observable
     * We can create an Observable by using the Observable.just method.
     * */
    exampleOf("just") {
        val observable = Observable.just(listOf(1))
        observable.subscribe { value ->
            println(value)
        }
    }
}