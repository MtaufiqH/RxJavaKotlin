package subject

import com.jakewharton.rxrelay3.PublishRelay
import io.reactivex.rxjava3.disposables.CompositeDisposable
import observable.exampleOf

fun main() {
    exampleOf("RxRelay") {
        val subscriptions = CompositeDisposable()

        val publishRelay = PublishRelay.create<Int>()

//        subscriptions.add(publishRelay.subscribeBy(
//            onNext = { printWithLabel("1)", it) }
//        ))

        publishRelay.accept(1)
        publishRelay.accept(2)
        publishRelay.accept(3)
    }

}