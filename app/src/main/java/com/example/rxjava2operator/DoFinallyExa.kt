package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by zhaoyuanchao on 2019-10-18.
 * 在所有事件发送完毕之后回调该方法
 */
@SuppressLint("CheckResult")
class DoFinallyExa {
    init {
        Observable.create(ObservableOnSubscribe<Int> { emitter ->
            emitter.onNext(1)
            emitter.onNext(2)
            emitter.onNext(3)
            emitter.onComplete()
        })
            .doFinally {
                println("doFinally")
            }
            .doOnDispose {
                println("doOnDispose")
            }
            .doAfterTerminate {
                println("doAfterTerminate")
            }
            .subscribe(object :Observer<Int>{
                var disposable:Disposable? = null
                override fun onComplete() {
                    println("onComplete")
                }

                override fun onSubscribe(d: Disposable) {
                    println("onSubscribe")
                    disposable = d
                }

                override fun onNext(t: Int) {
                    println(t)
//                    disposable?.dispose()
                }

                override fun onError(e: Throwable) {
                    println("onError")
                }

            })
    }

    /**
     * doFinally(): 无论怎么样都会在最后执行，就算取消订阅也是
     * doAfterTerminate(): 取消订阅就不会被回调，而且在doFinally()之前回调
     */

//    2019-10-18 17:04:40.747 15098-15098/? I/System.out: onSubscribe
//    2019-10-18 17:04:40.748 15098-15098/? I/System.out: 1
//    2019-10-18 17:04:40.748 15098-15098/? I/System.out: 2
//    2019-10-18 17:04:40.748 15098-15098/? I/System.out: 3
//    2019-10-18 17:04:40.748 15098-15098/? I/System.out: onComplete
//    2019-10-18 17:04:40.748 15098-15098/? I/System.out: doAfterTerminate
//    2019-10-18 17:04:40.748 15098-15098/? I/System.out: doFinally
}