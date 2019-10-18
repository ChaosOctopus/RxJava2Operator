package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable

/**
 * Created by zhaoyuanchao on 2019-10-18.
 * repeat():重复发送被观察者的事件，times为发送次数
 * repeatWhen():返回一个新的观察者来设定以一定逻辑来决定是否重复发送事件，和reTryWhen差不多
 *          （1）如果返回onComplete或者onError事件，旧的被观察者不会继续发送事件
 *          （2）如果返回其他事件，旧的会重复发送事件
 *
 */
@SuppressLint("CheckResult")
class RepeatExa {
    init {
        Observable.just(1,2,3,4,5)
            .repeat(2)
            .subscribe {
                println(it)
            }
    }

//    2019-10-18 18:14:47.939 19371-19371/com.example.rxjava2operator I/System.out: 1
//    2019-10-18 18:14:47.939 19371-19371/com.example.rxjava2operator I/System.out: 2
//    2019-10-18 18:14:47.939 19371-19371/com.example.rxjava2operator I/System.out: 3
//    2019-10-18 18:14:47.939 19371-19371/com.example.rxjava2operator I/System.out: 4
//    2019-10-18 18:14:47.939 19371-19371/com.example.rxjava2operator I/System.out: 5
//    2019-10-18 18:14:47.939 19371-19371/com.example.rxjava2operator I/System.out: 1
//    2019-10-18 18:14:47.939 19371-19371/com.example.rxjava2operator I/System.out: 2
//    2019-10-18 18:14:47.939 19371-19371/com.example.rxjava2operator I/System.out: 3
//    2019-10-18 18:14:47.939 19371-19371/com.example.rxjava2operator I/System.out: 4
//    2019-10-18 18:14:47.939 19371-19371/com.example.rxjava2operator I/System.out: 5
}