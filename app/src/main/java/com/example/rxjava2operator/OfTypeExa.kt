package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by zhaoyuanchao on 2019-10-19.
 */
@SuppressLint("CheckResult")
class OfTypeExa {
    init {
        Observable.just(1,2,3,"zyc","ys")
            .ofType(String::class.java)
            .subscribe(object :Observer<String>{
                override fun onComplete() {
                    println("onComplete")
                }

                override fun onSubscribe(d: Disposable) {
                    println("onSubscribe")
                }

                override fun onNext(t: String) {
                    println(t)
                }

                override fun onError(e: Throwable) {
                    println("onError")
                }

            })
    }
//    2019-10-19 14:27:26.131 23135-23135/com.example.rxjava2operator I/System.out: onSubscribe
//    2019-10-19 14:27:26.131 23135-23135/com.example.rxjava2operator I/System.out: zyc
//    2019-10-19 14:27:26.131 23135-23135/com.example.rxjava2operator I/System.out: ys
//    2019-10-19 14:27:26.131 23135-23135/com.example.rxjava2operator I/System.out: onComplete
}