package subject

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
//        publishSubject.onNext(1)

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
    }
}