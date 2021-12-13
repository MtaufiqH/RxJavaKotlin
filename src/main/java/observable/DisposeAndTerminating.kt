package observable

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable

fun main() {
    exampleOf("dispose") {
        // 1. Create an Observable of Strings
        val mostPopular = Observable.just("A", "B", "C")
        // 2. Create an observable and disposable
        val subscription = mostPopular.subscribe {
            // 3. subscribe to the Observable and print out the emitted items
            println(it)
        }
        // 4. Dispose the disposable
        subscription.dispose()
    }


    /** COMPOSITE DISPOSABLE
     * CompositeDisposable is a container for disposables that are disposed together.
     * It is a good way to manage a group of disposables that should be disposed together.
     * typically, you would use this class when you have a lot of disposables that you want to dispose together.
     * using the CompositeDisposable class, you can add and remove disposables from the container.
     * When you add a disposable to the container, it will be disposed when the container is disposed.
     * with call add() and remove() methods.
     * */

    exampleOf("composite Disposable") {
        //1 Create composite disposable
        val subscription = CompositeDisposable()
        //2 create an observable and disposable
        val disposable = Observable.just("A", "B", "C")
            .subscribe {
                // 3. subscribe to the Observable and print out the emitted items
                println(it)
            }
        // 4 add the disposable to the composite disposable
        subscription.add(disposable)
    }
}