import io.reactivex.Observable
import kotlin.math.pow
import kotlin.math.roundToInt

fun main() {
    // example of sequence
//    val sequence = sequenceOf(1, 2, 3)
//    val iterator = sequence.iterator()
//    while(iterator.hasNext()) {
//        println(iterator.next())
//    }

    /** Create Observable
     * We can create an Observable by using the Observable.just method.
     * */
//    exampleOf("just") {
//        val observable = Observable.just(listOf(1))
//        observable.subscribe { value ->
//            println(value)
//        }
//    }

    /** Create Observable
     * We can create an Observable by using the Observable.fromIterable method.
     * The fromIterable method create an observable of individual objects from a regular
     * list of element.
     * */
//    exampleOf("fromIterable") {
//        val observable = Observable.fromIterable(listOf(1,2,3))
//        observable.subscribe { value ->
//            println(value)
//        }
//    }


    /**
     * Subscribtion
     * */

//    exampleOf("subscribe") {
//        val observable = Observable.just(1, 2, 3)
//        observable.subscribe { value ->
//            println(value)
//        }
//    }

    // We use SubscribeBy extension function to simplify the subscription process.
//    exampleOf("empty" ) {
//        val observable = Observable.empty<Unit>()
//        observable.subscribeBy(
//            onNext = { println(it) },
//            onError = { it.printStackTrace() },
//            onComplete = { println("onComplete" ) }
//        )
//    }


    // The `Never` operator is an observable that never emits any item.
    // this observable is useful when you want to create a subscription that never ends.
    // it's useful for testing purposes.
//    exampleOf("never") {
//        val observable = Observable.never<Unit>()
//        observable.subscribeBy(
//            onNext = { println(it) },
//            onComplete = { println("onComplete" ) }
//        )
//    }

    exampleOf("range") {
        val observable = Observable.range(1, 10)
        observable.subscribe {
            val n = it.toDouble()
            val fibonacci = ((1.61803.pow(n) - 0.61803.pow(n)) / 2.23606).roundToInt()
            println("$n: $fibonacci")

        }

    }

    exampleOf("dispose") {
        // 1. Create an Observable of Strings
        val mostPopular = Observable.just("A", "B", "C")
        // 2. Create an observable and disposable
        val subscription = mostPopular.subscribe {
            // 3. subscribe to the Observable and print out the emitted items
            println(it)
        }

        // 4. add the disposable to a CompositeDisposable
        subscription.dispose()
    }
}

fun exampleOf(description: String, action: () -> Unit) {
    println("\n--- Example of: $description ---")
    action()
}



