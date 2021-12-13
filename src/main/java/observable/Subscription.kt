package observable

import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy

fun main() {

    /**
     * Subscribtion
     * */

    exampleOf("subscribe") {
        val observable = Observable.just(1, 2, 3)
        observable.subscribe { value ->
            println(value)
        }
    }

    // We use SubscribeBy extension function to simplify the subscription process.
    exampleOf("empty") {
        val observable = Observable.empty<Unit>()
        observable.subscribeBy(
            onNext = { println(it) },
            onError = { it.printStackTrace() },
            onComplete = { println("onComplete") }
        )
    }

}