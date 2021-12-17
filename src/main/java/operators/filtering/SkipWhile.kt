package operators

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import observable.exampleOf

fun main() {

    val subscription = CompositeDisposable()

    exampleOf("SkipWhile") {
        subscription.apply {
            add(
                Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9)
                    // expect output (5, 6, 7, 8, 9)
                    .skipWhile { it < 5 }
                    .subscribe {
                        println(it)
                    }
            )
        }

    }
}