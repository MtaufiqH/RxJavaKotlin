package observable

import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import java.io.File
import java.io.FileNotFoundException

fun main() {
    exampleOf("Single") {
        val subs = CompositeDisposable()

        fun loadText(fileName: String): Single<String>{
            return Single.create create@{ emitter ->

                val file = File(fileName)
                if (!file.exists()) {
                    emitter.onError(FileNotFoundException("File $fileName not found"))
                    return@create
                }

                val content = file.readText(Charsets.UTF_8)
                emitter.onSuccess(content)
            }
        }

        val observer = loadText("Mynote.txt")
            .subscribeBy(
                onSuccess = { println(it) },
                onError = { println("Error, $it") }
            )

        subs.add(observer)
    }


}