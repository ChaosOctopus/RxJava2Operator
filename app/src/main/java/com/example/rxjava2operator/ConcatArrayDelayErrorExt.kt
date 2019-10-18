package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.lang.NumberFormatException

/**
 * Created by zhaoyuanchao on 2019-10-18.
 * 在concatArray()和mergeArray()两个方法中，如果其中有一个被观察者发送了一个Error事件，
 * 那么就会停止发送事件，如果你想onError()事件延迟到所有被观察者都发送完事件后在执行的话，
 * 就可以使用concatArrayDelayError()和mergeArrayDelayError()
 */
@SuppressLint("CheckResult")
class ConcatArrayDelayErrorExt {
    init {
        Observable.concatArrayDelayError(
            Observable.create<Int> {
                it.onNext(1)
                it.onError(NumberFormatException())
            },
            Observable.just(1,2,3)
        ).subscribe(object :Observer<Int>{
            override fun onComplete() {

            }

            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: Int) {

            }

            override fun onError(e: Throwable) {

            }

        })

    }
}