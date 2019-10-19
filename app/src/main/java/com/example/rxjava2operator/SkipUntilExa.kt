package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by zhaoyuanchao on 2019-10-19.
 * skipUtil中的被观察者发送事件之后，源被观察者才会发送事件
 * 注意：skipUtil的事件不会被观察者接受
 */
@SuppressLint("CheckResult")
class SkipUntilExa {
    init {
        Observable.intervalRange(1,5,1,1,TimeUnit.SECONDS)
            .skipUntil(Observable.intervalRange(1,3,3,1,TimeUnit.SECONDS))
            .subscribe {
                println(it)
            }
    }

    /**
     * 所以3s后才会接收3个事件
     */

//    2019-10-19 15:14:00.483 25835-25867/com.example.rxjava2operator I/System.out: 3
//    2019-10-19 15:14:01.483 25835-25867/com.example.rxjava2operator I/System.out: 4
//    2019-10-19 15:14:02.483 25835-25867/com.example.rxjava2operator I/System.out: 5
}