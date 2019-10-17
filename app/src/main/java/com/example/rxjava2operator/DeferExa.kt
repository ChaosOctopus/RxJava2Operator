package com.example.rxjava2operator

import android.annotation.SuppressLint
import android.util.Log
import io.reactivex.Observable
import java.util.function.Consumer

/**
 * Created by zhaoyuanchao on 2019-10-17.
 * 直到被观察者被订阅之后才会创建被观察者
 */
@SuppressLint("CheckResult")
class DeferExa {
    val TAG = "DeferExa"
     init {
        var i = 2000
        //定义一个被观察者，发送一个时间，由于是defer创建的 所以被观察者不会被立即创建
        var observable = Observable.defer {
            return@defer Observable.just(i)
        }

        i = 2019

         //所以应该打出的是2019
        observable.subscribe {
            Log.e(TAG,"$i")
        }

    }
}