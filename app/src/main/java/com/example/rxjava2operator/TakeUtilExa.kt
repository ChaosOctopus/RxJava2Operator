package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable

/**
 * Created by zhaoyuanchao on 2019-10-19.
 * 可以设置条件，当事件满足此条件时，下一次的事件就不会被发送了。
 */
@SuppressLint("CheckResult")
class TakeUtilExa {
    init {
        Observable.just(1,2,3,4,5,6)
            .takeUntil {
                return@takeUntil it>4
            }
            .subscribe {
                println(it)
            }
    }
    /**
     * 所以6没了
     */

//    2019-10-19 15:06:24.754 25438-25438/com.example.rxjava2operator I/System.out: 1
//    2019-10-19 15:06:24.754 25438-25438/com.example.rxjava2operator I/System.out: 2
//    2019-10-19 15:06:24.754 25438-25438/com.example.rxjava2operator I/System.out: 3
//    2019-10-19 15:06:24.754 25438-25438/com.example.rxjava2operator I/System.out: 4
//    2019-10-19 15:06:24.754 25438-25438/com.example.rxjava2operator I/System.out: 5
}