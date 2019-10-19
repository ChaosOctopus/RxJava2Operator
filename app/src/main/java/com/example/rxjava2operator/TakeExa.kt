package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable

/**
 * Created by zhaoyuanchao on 2019-10-19.
 * 控制观察者接收事件的数量
 */
@SuppressLint("CheckResult")
class TakeExa {
    init {
        Observable.just(1,2,3,4,5,6,7)
            .take(3)
            .subscribe {
                println(it)
            }
    }

//    2019-10-19 14:40:42.986 23912-23912/? I/System.out: 1
//    2019-10-19 14:40:42.986 23912-23912/? I/System.out: 2
//    2019-10-19 14:40:42.987 23912-23912/? I/System.out: 3
}