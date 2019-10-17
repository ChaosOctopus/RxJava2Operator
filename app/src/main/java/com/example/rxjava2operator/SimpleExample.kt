package com.example.rxjava2operator

import android.util.Log
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by zhaoyuanchao on 2019-10-17.
 */
class SimpleExample {
    val tag = "SimpleExample"
    init {
        Observable.create(ObservableOnSubscribe<Int> {
            it.onNext(1)
            it.onNext(2)
            it.onNext(3)
            it.onComplete()
        }).subscribe(object : Observer<Int> {
            override fun onComplete() {
                Log.e(tag,"onComplete")
            }

            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: Int) {
                Log.e(tag,"$t")
            }

            override fun onError(e: Throwable) {

            }

        })
    }
}