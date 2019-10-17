package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable

/**
 * Created by zhaoyuanchao on 2019-10-17.
 * 同时发送一定范围内的事件序列
 */
@SuppressLint("CheckResult")
class RangeExa {
    init {
        //从 2开始 包含2 发送5个事件
        Observable.range(2,5)
            .subscribe {
                println(it)
            }
    }
}