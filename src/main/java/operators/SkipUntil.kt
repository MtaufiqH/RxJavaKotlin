package operators

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import observable.exampleOf

fun main() {
    val subscription = CompositeDisposable()

    val subject = PublishSubject.create<Int>()
    val trigger = PublishSubject.create<Int>()

    exampleOf("SkipUntil") {
        subscription.apply {
            add(
                subject.skipUntil(trigger)
                    .subscribe {
                        println("$it ")
                    }
            )
        }

        subject.onNext(1)
        subject.onNext(2)
        subject.onNext(3)
        //will be skipping until the trigger is emitted
        trigger.onNext(1)
        subject.onNext(4)


    }
}