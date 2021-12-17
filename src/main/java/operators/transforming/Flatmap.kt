package operators.transforming

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import observable.Student
import observable.exampleOf

fun main() {
    exampleOf("Flatmap") {
        // create composite disposable
        val compositeDisposable = CompositeDisposable()
        // 1. create two student instances
        val ichsan = Student(BehaviorSubject.createDefault(90))
        val aldi = Student(BehaviorSubject.createDefault(80))
        // 2. create source subject of type Student.
        val student = PublishSubject.create<Student>()
        student
            // 3. use flatmap to reach into student subject score.
            .flatMap { it.score }
            .subscribe {
                println(it)
            }
            .addTo(compositeDisposable)


        // trigger student subject
        student.onNext(ichsan)
        student.onNext(aldi)

        // change the score of students
        ichsan.score.onNext(100)
        aldi.score.onNext(90)

        /*
        * Flatmap keeps up with each and every observable it creates.
        * one for each element added onto the source observable.
        *
        * Flatmap keep projecting changes from each and every observable
        *
        * */

    }
}