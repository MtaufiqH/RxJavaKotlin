package operators.transforming

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import observable.exampleOf
import observable.romanNumeralIntValue

fun main() {

    exampleOf("Map") {
        val subscription = CompositeDisposable()

        subscription.add(
            // observable of letters and map into capitalize
            Observable.just("M", "C", "V", "I")
                .map {
                    // transform the letter into int roman numeral
                    it.romanNumeralIntValue()
                }
                .subscribe {
                    println("Received $it")
                }
        )

    }
}