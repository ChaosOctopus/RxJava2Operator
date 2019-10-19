package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable

/**
 * Created by zhaoyuanchao on 2019-10-19.
 * 判断两个被观察者发送的事件是否相同
 */
@SuppressLint("CheckResult")
class SequenceEqualExa {
    init {

        Observable.sequenceEqual(Observable.just(1,2,3),
            Observable.just(1,2,3))
            .subscribe {
                    t -> println(t)
            }


    }
    /**
     * 非常鸡肋
     */
//    2019-10-19 15:25:19.912 26121-26121/? I/System.out: true
}