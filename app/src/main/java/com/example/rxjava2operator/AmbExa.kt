package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable

/**
 * Created by zhaoyuanchao on 2019-10-19.
 * amb()要传入一个Observable集合，但是只会发送最先发送事件的Observable，其余的Observable不会发送事件
 */
@SuppressLint("CheckResult")
class AmbExa {
    init {
        var list = ArrayList<Observable<Long>>()
        list.add(Observable.just(1,2,3))
        list.add(Observable.just(3,4,56))
        list.add(Observable.just(3,5))
        Observable.amb(list)
            .subscribe {
                println(it)
            }
    }

    /**
     * 只会执行到第一个
     */
//    2019-10-19 15:53:33.258 26787-26787/? I/System.out: 1
//    2019-10-19 15:53:33.258 26787-26787/? I/System.out: 2
//    2019-10-19 15:53:33.258 26787-26787/? I/System.out: 3
}