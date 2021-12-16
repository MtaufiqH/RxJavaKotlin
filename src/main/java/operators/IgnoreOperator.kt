package operators

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.PublishSubject
import observable.exampleOf

fun main() {
    exampleOf("IgnoreElements") {
        val compositeDisposable = CompositeDisposable()

        val strikes = PublishSubject.create<String>()

        compositeDisposable.add(
            strikes.ignoreElements() // returns a completable, so onNext in subscribeBy will
                .subscribeBy {
                    println("You're out!")
                }
        )

        strikes.onNext("X")
        strikes.onNext("X")
        strikes.onNext("X")

        strikes.onComplete()
    }
}