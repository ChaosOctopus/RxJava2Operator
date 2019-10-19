package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable

/**
 * Created by zhaoyuanchao on 2019-10-19.
 * 可以设置条件,当某个数据满足条件时不发送数据，反之发送数据
 */
@SuppressLint("CheckResult")
class SkipWhileExa {
    init {
        Observable.just(1,2,3,4)
            .skipWhile {
                return@skipWhile it < 3
            }
            .subscribe {
                println(it)
            }
    }

//    2019-10-19 15:01:36.125 25237-25237/com.example.rxjava2operator I/System.out: 3
//    2019-10-19 15:01:36.125 25237-25237/com.example.rxjava2operator I/System.out: 4
}