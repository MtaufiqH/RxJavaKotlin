package operators

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import observable.exampleOf

fun main() {
    exampleOf("Filter") {
        val subscription = CompositeDisposable()

        subscription.add(
            Observable.fromIterable(listOf(1,2,3,4,5,6,7,8,9,10))
                .filter {
                    it % 2 == 0
                }.subscribe{
                    println("Genap")
                    println(it)
                }
        )

        subscription.add(
            Observable.fromIterable(listOf(1,2,3,4,5,6,7,8,9,10))
                .filter {
                    it % 2 == 1
                }.subscribe{
                    println("Ganjil")
                    println(it)
                }
        )
    }
}

