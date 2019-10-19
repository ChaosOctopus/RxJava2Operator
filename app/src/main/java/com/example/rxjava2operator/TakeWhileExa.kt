package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable

/**
 * Created by zhaoyuanchao on 2019-10-19.
 * 可以设置条件，当某个数据满足条件时就会发送该数据，反之则不发送
 */
@SuppressLint("CheckResult")
class TakeWhileExa {
    init {
        Observable.just(1,2,3,4)
            .takeWhile {
                return@takeWhile it < 3
            }
            .subscribe {
                println(it)
            }
    }

//    2019-10-19 14:59:16.085 25052-25052/com.example.rxjava2operator I/System.out: 1
//    2019-10-19 14:59:16.085 25052-25052/com.example.rxjava2operator I/System.out: 2
}