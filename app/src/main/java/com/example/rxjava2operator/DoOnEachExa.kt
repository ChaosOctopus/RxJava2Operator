package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable

/**
 * Created by zhaoyuanchao on 2019-10-18.
 * 被观察者每发送一件事件之前都会先回调这个方法
 */
@SuppressLint("CheckResult")
class DoOnEachExa {
    init {
        Observable.just(1,2,3,4,5,6)
            .doOnEach {
                println("${it.value}:doOnEach")
            }
            .subscribe {
                println("$it:subscribe")
            }
    }
    /**
     * 因为有 onComplete 所以doOnEach会在回调一次
     */

//    2019-10-18 16:14:54.277 12682-12682/com.example.rxjava2operator I/System.out: 1:doOnEach
//    2019-10-18 16:14:54.278 12682-12682/com.example.rxjava2operator I/System.out: 1:subscribe
//    2019-10-18 16:14:54.278 12682-12682/com.example.rxjava2operator I/System.out: 2:doOnEach
//    2019-10-18 16:14:54.278 12682-12682/com.example.rxjava2operator I/System.out: 2:subscribe
//    2019-10-18 16:14:54.278 12682-12682/com.example.rxjava2operator I/System.out: 3:doOnEach
//    2019-10-18 16:14:54.278 12682-12682/com.example.rxjava2operator I/System.out: 3:subscribe
//    2019-10-18 16:14:54.278 12682-12682/com.example.rxjava2operator I/System.out: 4:doOnEach
//    2019-10-18 16:14:54.278 12682-12682/com.example.rxjava2operator I/System.out: 4:subscribe
//    2019-10-18 16:14:54.278 12682-12682/com.example.rxjava2operator I/System.out: 5:doOnEach
//    2019-10-18 16:14:54.278 12682-12682/com.example.rxjava2operator I/System.out: 5:subscribe
//    2019-10-18 16:14:54.278 12682-12682/com.example.rxjava2operator I/System.out: 6:doOnEach
//    2019-10-18 16:14:54.278 12682-12682/com.example.rxjava2operator I/System.out: 6:subscribe
//    2019-10-18 16:14:54.278 12682-12682/com.example.rxjava2operator I/System.out: null:doOnEach
}