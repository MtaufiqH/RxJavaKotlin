package observable

import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy

fun main() {
    // The `Never` operator is an observable that never emits any item.
    // this observable is useful when you want to create a subscription that never ends.
    // it's useful for testing purposes.
    exampleOf("never") {
        val observable = Observable.never<Unit>()
        observable.subscribeBy(
            onNext = { println(it) },
            onComplete = { println("onComplete") }
        )
    }
}