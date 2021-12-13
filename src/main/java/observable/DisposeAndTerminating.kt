package observable

import io.reactivex.Observable
import observable.exampleOf

fun main() {
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