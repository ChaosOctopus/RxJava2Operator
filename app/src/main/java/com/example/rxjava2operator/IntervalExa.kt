package com.example.rxjava2operator

import android.annotation.SuppressLint
import android.util.Log
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by zhaoyuanchao on 2019-10-17.
 * 每隔指定的时间会发送一个事件
 */
@SuppressLint("CheckResult")
class IntervalExa {
    val TAG = "IntervalExa"
    init {
        Observable.interval(1,TimeUnit.SECONDS)
            .subscribe {
               Log.e(TAG,"$it")
            }
    }
}