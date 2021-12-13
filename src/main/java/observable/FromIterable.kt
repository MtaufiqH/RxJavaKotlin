import io.reactivex.Observable

fun main() {
    /** Create Observable
     * We can create an Observable by using the Observable.fromIterable method.
     * The fromIterable method create an observable of individual objects from a regular
     * list of element.
     * */
    exampleOf("fromIterable") {
        val observable = Observable.fromIterable(listOf(1,2,3))
        observable.subscribe { value ->
            println(value)
        }
    }
}