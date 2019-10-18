package com.example.rxjava2operator

import android.annotation.SuppressLint
import android.util.Log
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by zhaoyuanchao on 2019-10-18.
 * doOnTerminate():是在onComplete()或者onError()发送之前回调
 * doAfterTerminate()：是在之后回调
 */
@SuppressLint("CheckResult")
class DoOnTerminate {
    init {
        Observable.create(ObservableOnSubscribe<Int> {
            it.onNext(1)
            it.onNext(2)
            it.onComplete()
        })
            .doOnTerminate {
                println("doOnTerminate")
            }
            .subscribe(object :Observer<Int>{
                override fun onComplete() {
                    println("onComplete")
                }

                override fun onSubscribe(d: Disposable) {
                    println("onSubscribe")
                }

                override fun onNext(t: Int) {
                    println(t)
                }

                override fun onError(e: Throwable) {
                    println("onError")
                }

            })
    }

//    2019-10-18 16:47:57.135 14278-14278/com.example.rxjava2operator I/System.out: onSubscribe
//    2019-10-18 16:47:57.135 14278-14278/com.example.rxjava2operator I/System.out: 1
//    2019-10-18 16:47:57.136 14278-14278/com.example.rxjava2operator I/System.out: 2
//    2019-10-18 16:47:57.136 14278-14278/com.example.rxjava2operator I/System.out: doOnTerminate
//    2019-10-18 16:47:57.136 14278-14278/com.example.rxjava2operator I/System.out: onComplete
}