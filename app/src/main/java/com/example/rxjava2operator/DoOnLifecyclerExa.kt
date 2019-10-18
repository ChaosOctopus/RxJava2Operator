package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Action
import io.reactivex.functions.Consumer

/**
 * Created by zhaoyuanchao on 2019-10-18.
 * 在回调onSubscribe之前回调该方法的第一个参数的回调方法，
 * 可以使用该回调方法决定是否取消订阅。
 * 第二个参数的回调方法的作用与doOnDispose()是一样的
 */
@SuppressLint("CheckResult")
class DoOnLifecyclerExa {
    init {
        var disposable:Disposable? = null
        Observable.create(ObservableOnSubscribe<Int> {
            it.onNext(1)
            it.onNext(2)
            it.onNext(3)
            it.onComplete()
        })
            .doOnLifecycle(
                {
                    println("doOnLifecycle accept")
            },
                {
                    println("doOnLifecycle action")
            })
            .doOnDispose {
                println("doOnDispose")
            }
            .subscribe(object :Observer<Int>{
                override fun onComplete() {
                    println("onComplete")
                }

                override fun onSubscribe(d: Disposable) {
                    disposable = d
                    println("onSubscribe")
                }

                override fun onNext(t: Int) {
                    println(t)
                    disposable!!.dispose()
                }

                override fun onError(e: Throwable) {
                    println("onError")
                }

            })

        /**
         * 如果用doOnLifeCycle取消订阅
         *
         */
        Observable.create(ObservableOnSubscribe<Int> {
            it.onNext(1)
            it.onNext(2)
            it.onNext(3)
            it.onComplete()
        })
            .doOnLifecycle(
                {
                    println("doOnLifecycle accept")
                    it.dispose()
                },
                {
                    println("doOnLifecycle action")
                })
            .doOnDispose {
                println("doOnDispose")
            }
            .subscribe(object :Observer<Int>{
                override fun onComplete() {
                    println("onComplete")
                }

                override fun onSubscribe(d: Disposable) {
                    disposable = d
                    println("onSubscribe")
                }

                override fun onNext(t: Int) {
                    println(t)
                    disposable!!.dispose()
                }

                override fun onError(e: Throwable) {
                    println("onError")
                }

            })
    }

//    2019-10-18 16:38:44.286 13716-13716/? I/System.out: doOnLifecycle accept
//    2019-10-18 16:38:44.286 13716-13716/? I/System.out: onSubscribe
//    2019-10-18 16:38:44.286 13716-13716/? I/System.out: 1
//    2019-10-18 16:38:44.286 13716-13716/? I/System.out: doOnDispose
//    2019-10-18 16:38:44.286 13716-13716/? I/System.out: doOnLifecycle action

    /**
     * onLifeCycler取消订阅 只会执行到onSubscribe()
     */
//    第二种情况
//    2019-10-18 16:40:53.511 13922-13922/com.example.rxjava2operator I/System.out: doOnLifecycle accept
//    2019-10-18 16:40:53.512 13922-13922/com.example.rxjava2operator I/System.out: onSubscribe
}