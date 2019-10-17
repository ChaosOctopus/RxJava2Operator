package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable

/**
 * Created by zhaoyuanchao on 2019-10-17.
 * 发送指定数量的事件时,将这些事件分为一组，window中count的参数就是代表指定的数量，
 * 列如将count指定为2，那么每发2个数据就会将这两个数据分成一组
 */
@SuppressLint("CheckResult")
class WindowExa {
    init {
        Observable.just(1,2,3,4,5)
            .window(2)
            .subscribe {
                it.subscribe {count->
                    println(count)
                }
            }
    }
}