package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by zhaoyuanchao on 2019-10-18.
 * 指定被观察者的线程，要注意的是，如果多次调用方法，只有第一次有效
 */
@SuppressLint("CheckResult")
class SubscribeOnExa {
    init {
        Observable.create(ObservableOnSubscribe<Int> {
            println("currentThread Name:${Thread.currentThread()}")
            it.onNext(1)
            it.onNext(2)
            it.onComplete()
        })
            .subscribeOn(Schedulers.newThread())
            .subscribeOn(Schedulers.io())
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

//
//    2019-10-18 18:23:53.854 19772-19772/? I/System.out: onSubscribe
//    2019-10-18 18:23:53.865 19772-19815/? I/System.out: currentThread Name:Thread[RxNewThreadScheduler-1,5,main]
//    2019-10-18 18:23:53.867 19772-19815/? I/System.out: 1
//    2019-10-18 18:23:53.867 19772-19815/? I/System.out: 2
//    2019-10-18 18:23:53.867 19772-19815/? I/System.out: onComplete

}