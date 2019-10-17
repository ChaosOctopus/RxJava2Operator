package com.example.rxjava2operator

import android.annotation.SuppressLint
import android.util.Log
import io.reactivex.Observable
import java.util.concurrent.TimeUnit


/**
 * Created by zhaoyuanchao on 2019-10-17.
 * 当到指定时间时就会发送一个0L的值给观察者
 */
@SuppressLint("CheckResult")
class TimerExa {
    val TAG = "TimerExa"
    init {
        Observable.timer(2L,TimeUnit.SECONDS)
            .subscribe {
                Log.e(TAG,"$it")
            }
    }
}