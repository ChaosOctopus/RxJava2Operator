package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by zhaoyuanchao on 2019-10-18.
 * 指定观察者的线程，没指定一次就会生效一次
 */
@SuppressLint("CheckResult")
class ObserverOnExa {
    init {
        Observable.just(1,2,3)
            .observeOn(Schedulers.newThread())
            .flatMap {
                println("flat map thread name is : ${Thread.currentThread()}")
                return@flatMap Observable.just("chan:$it")
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :Observer<String>{
                override fun onComplete() {
                    println("onComplete")
                }

                override fun onSubscribe(d: Disposable) {

                    println("onSubscribe")
                }

                override fun onNext(t: String) {
                    println("onSubscribe thread name is : ${Thread.currentThread()}")
                    println(t)
                }

                override fun onError(e: Throwable) {
                    println("onError")
                }

            })
    }

//    2019-10-18 18:31:01.797 20402-20402/? I/System.out: onSubscribe
//    2019-10-18 18:31:01.798 20402-20443/? I/System.out: flat map thread name is : Thread[RxNewThreadScheduler-1,5,main]
//    2019-10-18 18:31:01.799 20402-20443/? I/System.out: flat map thread name is : Thread[RxNewThreadScheduler-1,5,main]
//    2019-10-18 18:31:01.836 20402-20402/? I/System.out: onSubscribe thread name is : Thread[main,5,main]
//    2019-10-18 18:31:01.836 20402-20402/? I/System.out: chan:1
//    2019-10-18 18:31:01.837 20402-20402/? I/System.out: onSubscribe thread name is : Thread[main,5,main]
//    2019-10-18 18:31:01.837 20402-20402/? I/System.out: chan:2
//    2019-10-18 18:31:01.837 20402-20402/? I/System.out: onSubscribe thread name is : Thread[main,5,main]
//    2019-10-18 18:31:01.838 20402-20402/? I/System.out: chan:3
//    2019-10-18 18:31:01.838 20402-20402/? I/System.out: onComplete


//    Schedulers.computation( )
//    用于使用计算任务，如事件循环和回调处理
//
//
//    Schedulers.immediate( )
//    当前线程
//
//
//    Schedulers.io( )
//    用于 IO 密集型任务，如果异步阻塞 IO 操作。
//
//
//    Schedulers.newThread( )
//    创建一个新的线程
//
//
//    AndroidSchedulers.mainThread()
//    Android 的 UI 线程，用于操作 UI。


}