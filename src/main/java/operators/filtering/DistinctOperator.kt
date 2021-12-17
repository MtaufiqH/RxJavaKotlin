package operators

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import observable.exampleOf

fun main() {
    val subs = CompositeDisposable()
    exampleOf("DistinctUntilChange") {

        subs.add(
            Observable.just(1, 2, 3, 4, 4, 4, 4, 5, 5, 6)
                .distinctUntilChanged()
                .subscribe {
                    // output: 1,2,3,4,5,6 --> no duplicates
                    println("Received $it")
                }
        )

    }

    subs.add(
        Observable.just("ABC", "CBD", "CDE", "FGH", "IJK","JKL", "LMN")
            .distinctUntilChanged {first, second ->
                second.toList().any { it in first.toList() }
            }
            .subscribe {
                println("Received $it")
            }
    )
}