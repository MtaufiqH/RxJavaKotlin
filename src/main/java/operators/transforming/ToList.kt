package operators.transforming

import io.reactivex.Observable.just
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import observable.exampleOf

fun main() {

    exampleOf("ToList") {
        val subscription = CompositeDisposable()

        // 1. create an Observable of letters
        val item = just("A", "B", "C")

        subscription.add(
            // 2. convert the Observable to a List
            item.toList()
                .subscribeBy {
                    println(it)
                }
        )

    }
}