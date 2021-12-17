package operators

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subjects.PublishSubject
import observable.exampleOf

fun main() {
    // composite disposable initialization
    val compositeDisposable = CompositeDisposable()

    exampleOf("Take") {


        // observable creation
        compositeDisposable.add(
            Observable.just(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .take(2)
                .subscribe {
                    println("Received $it")
                }
        )

    }


    exampleOf("TakeWhile") {
        compositeDisposable.add(
            Observable.fromIterable(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
                .takeWhile {
                    // take a value that less than 5
                    it < 5
                }
                .subscribe {
                    println("Received $it")
                }
        )
    }

    exampleOf("TakeUntil") {
        val subject = PublishSubject.create<Int>()
        val trigger = PublishSubject.create<Int>()

        compositeDisposable.add(
            subject.takeUntil(trigger)
                .subscribe{
                    println(it)
                }
        )

        subject.onNext(1)
        subject.onNext(2)
        subject.onNext(3)
        // will take until trigger is called
        trigger.onNext(1)
        // this will not be printed, because trigger is called
        subject.onNext(4)
    }
}