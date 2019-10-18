package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.*
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Function
import java.lang.NullPointerException

/**
 * Created by zhaoyuanchao on 2019-10-18.
 * onErrorReturn():当接受到一个onError()事件之后回调，返回的值会回调onNext()方法，并正常结束该事件序列
 * onErrorResumeNext():当接收到OnError()事件时,返回一个新的Observable,并正常结束事件序列
 * onExceptionResumeNext():与onErrorResumeNext()作用基本一致,但是这个方法只能捕捉Exception
 */
@SuppressLint("CheckResult")
class OnErrorReturnExa {
    init {
        /**
         * onErrorReturn()
         */
        Observable.create(ObservableOnSubscribe<Int> {
            it.onNext(1)
            it.onNext(2)
            it.onNext(3)
            it.onError(NullPointerException())
        })
            .onErrorReturn {
                println("$it")
                return@onErrorReturn 404
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
                    println("onError:$e")
                }

            })

        /**
         * onErrorResumeNext()
         */
        Observable.create(ObservableOnSubscribe<Int> { emitter ->
            emitter.onNext(1)
            emitter.onNext(2)
            emitter.onNext(3)
            emitter.onError(NullPointerException())
        })
            .onErrorResumeNext(Function<Throwable, ObservableSource<Int>> {
                println("$it")
                return@Function Observable.just(1,2,4)
            })
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
    }

    /**
     * onErrorReturn
     */
//    2019-10-18 17:21:48.000 15761-15761/com.example.rxjava2operator I/System.out: onSubscribe
//    2019-10-18 17:21:48.000 15761-15761/com.example.rxjava2operator I/System.out: 1
//    2019-10-18 17:21:48.000 15761-15761/com.example.rxjava2operator I/System.out: 2
//    2019-10-18 17:21:48.000 15761-15761/com.example.rxjava2operator I/System.out: 3
//    2019-10-18 17:21:48.000 15761-15761/com.example.rxjava2operator I/System.out: java.lang.NullPointerException
//    2019-10-18 17:21:48.000 15761-15761/com.example.rxjava2operator I/System.out: 404
//    2019-10-18 17:21:48.000 15761-15761/com.example.rxjava2operator I/System.out: onComplete


    /**
     * onErrorResumeNext
     */
//    2019-10-18 17:34:53.843 16857-16857/com.example.rxjava2operator I/System.out: onSubscribe
//    2019-10-18 17:34:53.843 16857-16857/com.example.rxjava2operator I/System.out: 1
//    2019-10-18 17:34:53.843 16857-16857/com.example.rxjava2operator I/System.out: 2
//    2019-10-18 17:34:53.843 16857-16857/com.example.rxjava2operator I/System.out: 3
//    2019-10-18 17:34:53.844 16857-16857/com.example.rxjava2operator I/System.out: java.lang.NullPointerException
//    2019-10-18 17:34:53.844 16857-16857/com.example.rxjava2operator I/System.out: 1
//    2019-10-18 17:34:53.844 16857-16857/com.example.rxjava2operator I/System.out: 2
//    2019-10-18 17:34:53.844 16857-16857/com.example.rxjava2operator I/System.out: 4
//    2019-10-18 17:34:53.844 16857-16857/com.example.rxjava2operator I/System.out: onComplete
}