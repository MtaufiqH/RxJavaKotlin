package operators.transforming

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import observable.Student
import observable.exampleOf

fun main() {
    exampleOf("SwitchMap") {
        // create composite disposable
        val compositeDisposable = CompositeDisposable()
        // 1. create two student instances
        val ichsan = Student(BehaviorSubject.createDefault(90))
        val aldi = Student(BehaviorSubject.createDefault(80))
        // 2. create source subject of type Student.
        val student = PublishSubject.create<Student>()

        student
            // 3. use flatmap to reach into student subject score.
            .switchMap { it.score }
            .subscribe {
                println(it)
            }
            .addTo(compositeDisposable)

        // trigger student subject
        student.onNext(ichsan)
        student.onNext(aldi)

        // change the score of students
        // this will be not printed because switchMap will not be triggered
        // because the second student has been triggered before
        // and just emit the last value of the student.
        ichsan.score.onNext(100)

        aldi.score.onNext(90)
    }

}