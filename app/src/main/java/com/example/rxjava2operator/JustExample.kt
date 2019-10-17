package com.example.rxjava2operator

import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by zhaoyuanchao on 2019-10-17.
 * 作用：创建一个被观察者，发送事件，发送的事件不可以超过10个
 *
 */
class JustExample {
    val TAG = "JustExample"
    init {

        Observable.just(1,2,3)
            .subscribe(object :Observer<Int>{
                override fun onComplete() {
                    Log.e(TAG,"onComplete")
                }

                override fun onSubscribe(d: Disposable) {
                    Log.e(TAG,"onSubscribe")
                }

                override fun onNext(t: Int) {
                    Log.e(TAG,"$t")
                }

                override fun onError(e: Throwable) {
                    Log.e(TAG,e.message.toString())
                }

            })

    }
}