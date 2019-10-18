package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.*
import io.reactivex.disposables.Disposable

/**
 * Created by zhaoyuanchao on 2019-10-18.
 * Retry()：如果出现错误事件，则会重新发送所有事件序列。times是代表重新发的次数
 * RetryUtil():出现错误事件后，可以通过此方法判断是否继续发送事件
 * RetryWhen():
 *             当被观察者接收到异常或者错误事件时会回调该方法，这个方法会返回一个新的被观察者。
 *             如果返回得被观察者发送Error()事件则之前的被观察者不会继续发送事件，
 *             如果是正常事件，则之前的被观察者会继续不断重试发送事件
 *
 */
@SuppressLint("CheckResult")
class RetryExa {
    init {

        /**
         * retry
         */
        Observable.create(ObservableOnSubscribe<Int> {
            it.onNext(1)
            it.onNext(2)
            it.onNext(3)
            it.onError(Exception("404"))
        })
            .retry(2)
            .subscribe(object :Observer<Int>{
                override fun onComplete() {
                    println("onComplete")
                }

                override fun onSubscribe(d: Disposable) {
                    println("onSubscribe")
                }

                override fun onNext(t: Int) {
                    println("$t")
                }

                override fun onError(e: Throwable) {
                    println("onError")
                }

            })

        /**
         * retryUtil
         */
        Observable.create(ObservableOnSubscribe<Int> {
            it.onNext(1)
            it.onNext(2)
            it.onNext(3)
            it.onError(Exception("404"))
        })
            .retryUntil {
                return@retryUntil true
            }
            .subscribe(object :Observer<Int>{
                override fun onComplete() {
                    println("onComplete")
                }

                override fun onSubscribe(d: Disposable) {
                    println("onSubscribe")
                }

                override fun onNext(t: Int) {
                    println("$t")
                }

                override fun onError(e: Throwable) {
                    println("onError")
                }

            })

        /**
         * retryWhen
         */
        Observable.create(ObservableOnSubscribe<String> { emitter ->
            emitter.onNext("a")
            emitter.onNext("b")
            emitter.onNext("c")
            emitter.onNext("d")
            emitter.onError(java.lang.Exception("404"))
            emitter.onNext("last")
        })
            .retryWhen {
                return@retryWhen Observable.error<String>(Throwable("终止。"))
            }
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
    /**
     * onRetry()：只有在重试次数完毕之后 才会调用onError()
     */

//    2019-10-18 17:46:37.478 17541-17541/com.example.rxjava2operator I/System.out: onSubscribe
//    2019-10-18 17:46:37.478 17541-17541/com.example.rxjava2operator I/System.out: 1
//    2019-10-18 17:46:37.478 17541-17541/com.example.rxjava2operator I/System.out: 2
//    2019-10-18 17:46:37.479 17541-17541/com.example.rxjava2operator I/System.out: 3
//    2019-10-18 17:46:37.479 17541-17541/com.example.rxjava2operator I/System.out: 1
//    2019-10-18 17:46:37.479 17541-17541/com.example.rxjava2operator I/System.out: 2
//    2019-10-18 17:46:37.479 17541-17541/com.example.rxjava2operator I/System.out: 3
//    2019-10-18 17:46:37.479 17541-17541/com.example.rxjava2operator I/System.out: 1
//    2019-10-18 17:46:37.479 17541-17541/com.example.rxjava2operator I/System.out: 2
//    2019-10-18 17:46:37.479 17541-17541/com.example.rxjava2operator I/System.out: 3
//    2019-10-18 17:46:37.479 17541-17541/com.example.rxjava2operator I/System.out: onError

    /**
     * retryUntil（）：
     *  true：不在重试
     *  false:重试
     */

//    2019-10-18 17:50:34.571 17953-17953/com.example.rxjava2operator I/System.out: onSubscribe
//    2019-10-18 17:50:34.571 17953-17953/com.example.rxjava2operator I/System.out: 1
//    2019-10-18 17:50:34.571 17953-17953/com.example.rxjava2operator I/System.out: 2
//    2019-10-18 17:50:34.571 17953-17953/com.example.rxjava2operator I/System.out: 3
//    2019-10-18 17:50:34.571 17953-17953/com.example.rxjava2operator I/System.out: onError

}