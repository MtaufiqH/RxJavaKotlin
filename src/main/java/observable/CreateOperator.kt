package observable

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy

fun main() {
    exampleOf("create") {
        val disposable = CompositeDisposable()

        Observable.create<String> { emitter ->
            emitter.apply {
                onNext("1")
//                onComplete()
                onNext("?")
//                onError(RuntimeException("Error"))
            }

        }.subscribeBy(
            onNext = { println("Received $it") },
//            onComplete = { println("Done!") },
//            onError = { println("Error") },
        )
    }
}