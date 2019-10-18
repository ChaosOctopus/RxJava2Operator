package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function
import java.util.concurrent.TimeUnit

/**
 * Created by zhaoyuanchao on 2019-10-18.
 * combineLatest的作用与zip()类似，但是combineLatest发送事件的序列是发送的时间线有关的，
 * 当 combineLatest中所有的Observable都发送了事件，只要其中有一个Observable发送事件，
 * 这个事件就会和其它Observable最近发送的事件结合起来发送
 */
@SuppressLint("CheckResult")
class CombineLatestExa {
    init {
        Observable.combineLatest(
            Observable.intervalRange(1,4,1,1,TimeUnit.SECONDS)
                .map { t -> "A$t" },
            Observable.intervalRange(1,5,2,2,TimeUnit.SECONDS)
                .map { t -> "B$t" },
            BiFunction<String, String, String> { t1, t2 -> "$t1=====$t2" }
        ).subscribe {
            println(it)
        }
    }
    /**
     * 会与相邻的事件结合
     * 直到所有事件发送完毕，才会停止
     */

//    2019-10-18 10:38:04.018 827-868/com.example.rxjava2operator I/System.out: A2=====B1
//    2019-10-18 10:38:05.017 827-867/com.example.rxjava2operator I/System.out: A3=====B1
//    2019-10-18 10:38:06.017 827-867/com.example.rxjava2operator I/System.out: A4=====B1
//    2019-10-18 10:38:06.017 827-868/com.example.rxjava2operator I/System.out: A4=====B2
//    2019-10-18 10:38:08.018 827-868/com.example.rxjava2operator I/System.out: A4=====B3
//    2019-10-18 10:38:10.018 827-868/com.example.rxjava2operator I/System.out: A4=====B4
//    2019-10-18 10:38:12.019 827-868/com.example.rxjava2operator I/System.out: A4=====B5
}