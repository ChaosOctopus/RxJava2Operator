package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable

/**
 * Created by zhaoyuanchao on 2019-10-19.
 * 通过一定逻辑来过滤观察者发送的事件，如果true则会发送事件，否则不会发送
 */
@SuppressLint("CheckResult")
class FilterExa {
    init {
        Observable.just(1,2,3,45)
            .filter {
                return@filter it <= 2
            }
            .subscribe {
                println(it)
            }
    }

//    2019-10-19 14:15:41.419 21319-21319/com.example.rxjava2operator I/System.out: 1
//    2019-10-19 14:15:41.419 21319-21319/com.example.rxjava2operator I/System.out: 2
}