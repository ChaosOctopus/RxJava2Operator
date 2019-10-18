package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable

/**
 * Created by zhaoyuanchao on 2019-10-18.
 *  可以将多个观察者组合在一起，按照之前发送的顺序发送事件。
 *  需要注意的是，concat()最多只可以发送4个事件
 *  注意：串行
 *
 *  ConcatArray 比起 concat 同样是串行，但是发送参数可以大于4个
 */
@SuppressLint("CheckResult")
class ConcatExa {
    init {
        Observable.concat(
            Observable.just(1,2),
            Observable.just(3,4),
            Observable.just(5,6)
        ).subscribe {
            println(it)
        }
    }
}