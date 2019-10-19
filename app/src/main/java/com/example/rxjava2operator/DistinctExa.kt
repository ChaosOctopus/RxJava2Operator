package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable

/**
 * Created by zhaoyuanchao on 2019-10-19.
 * distinct()：过滤重复事件
 * distinctUntilChanged():过滤连续重复的事件
 */
@SuppressLint("CheckResult")
class DistinctExa {
    init {
        Observable.just(1,2,34,3,2,1)
            .distinct()
            .subscribe {
                println(it)
            }

        Observable.just(1,2,34,34,34,3,3,2,1)
            .distinctUntilChanged()
            .subscribe {
                println(it)
            }
    }

//    2019-10-19 14:37:04.341 23586-23586/com.example.rxjava2operator I/System.out: 1
//    2019-10-19 14:37:04.341 23586-23586/com.example.rxjava2operator I/System.out: 2
//    2019-10-19 14:37:04.341 23586-23586/com.example.rxjava2operator I/System.out: 34
//    2019-10-19 14:37:04.341 23586-23586/com.example.rxjava2operator I/System.out: 3


//    2019-10-19 14:39:07.708 23770-23770/com.example.rxjava2operator I/System.out: 1
//    2019-10-19 14:39:07.708 23770-23770/com.example.rxjava2operator I/System.out: 2
//    2019-10-19 14:39:07.708 23770-23770/com.example.rxjava2operator I/System.out: 34
//    2019-10-19 14:39:07.708 23770-23770/com.example.rxjava2operator I/System.out: 3
//    2019-10-19 14:39:07.708 23770-23770/com.example.rxjava2operator I/System.out: 2
//    2019-10-19 14:39:07.708 23770-23770/com.example.rxjava2operator I/System.out: 1
}