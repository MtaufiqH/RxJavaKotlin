package operators

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import observable.exampleOf

fun main() {

    exampleOf("Skipping") {

        val subscription = CompositeDisposable()

        subscription.apply {
            /*add(
                Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9)
                    .skip(3)
                    .subscribe {
                        println(it)
                    }
            )*/

            add(
                Observable.just("A", "B", "C", "D", "E", "F", "G", "H", "I")
                    .skip(8)
                    .subscribe {
                        println(it)
                    }
            )
        }


    }
}