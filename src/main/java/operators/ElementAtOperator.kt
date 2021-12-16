package operators

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.PublishSubject
import observable.exampleOf

fun main() {
    exampleOf("ElementAt") {

        val subscription = CompositeDisposable()

        val strikes = PublishSubject.create<String>()

        subscription.add(
            strikes.elementAt(4) // return maybe, subscribe with onSuccess instead of onNext.
                .subscribeBy(
                    onSuccess = {
                        println("You're Out! $it")
                    }

                )
        )

        strikes.onNext("#1")
        strikes.onNext("#2")
        strikes.onNext("#3")

    }
}