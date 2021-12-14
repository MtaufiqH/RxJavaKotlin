package subject

import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.PublishSubject
import observable.exampleOf

fun main() {
    exampleOf("PublishSubject") {
        /** PublishSubject
         * it will receive information and then turn around and publish it
         * to subscribers, posibbly after modifying that information
         * in some way first.
         *
         * The subject here is type INT, so it can only receive and publish integers.
         *
         * after being instantiated it's ready to receive data.
         *
         * */
        val publishSubject = PublishSubject.create<Int>()
        publishSubject.onNext(1)

        val subscriptionOne = publishSubject.subscribe {
            /**
             *
             * PublishSubject only emit to current subscribers.
             *
             * if you weren't subject when something was added to it,
             * you don't get it when you do subscribed.
             *
             * */


            println("Received $it")
        }

        publishSubject.onNext(1)
        publishSubject.onNext(2)
        publishSubject.onNext(3)


        val subscriptionTwo = publishSubject.subscribe {
            printWithLabel("2)", it)
        }

        publishSubject.onNext(4)

        subscriptionOne.dispose()
        publishSubject.onNext(5)

        publishSubject.onComplete()
        publishSubject.onNext(6)
        subscriptionTwo.dispose()


        /**
         *
         * PublishSubject is a hot observable, meaning that it will
         * emit to all subscribers, even if they are not subscribed
         * when the data is emitted.
         *
         * */

        val subscriptionThree = publishSubject.subscribeBy(
            onNext = {
                printWithLabel("3)", it)
            },
            onComplete = {
                printWithLabel("3)", "Completed")
            }
        )

        publishSubject.onNext(7)

    }


}

fun <T> printWithLabel(description: String, value: T) {
    println("$description: $value")
}
