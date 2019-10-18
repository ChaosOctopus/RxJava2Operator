package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.functions.Consumer

/**
 * Created by zhaoyuanchao on 2019-10-18.
 * 返回被观察者发送事件的数量
 *
 */
@SuppressLint("CheckResult")
class CountExa {
    init {
        Observable.just(1,2,3)
            .count()
            .subscribe(Consumer<Long> {
                println(it)
            })
    }

//    com.example.rxjava2operator I/System.out: 3
}