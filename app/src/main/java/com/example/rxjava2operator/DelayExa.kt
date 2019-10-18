package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by zhaoyuanchao on 2019-10-18.
 * 延迟一段时间发送事件
 */
@SuppressLint("CheckResult")
class DelayExa {
    init {
        Observable.just(1,2,3)
            .delay(2,TimeUnit.SECONDS)
            .subscribe {
                println(it)
            }
    }
}