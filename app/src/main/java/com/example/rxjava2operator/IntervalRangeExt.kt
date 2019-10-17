package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by zhaoyuanchao on 2019-10-17.
 * 与interval()比较可以指定事件的开始值和数量
 */
@SuppressLint("CheckResult")
class IntervalRangeExt {

   init {
       //initialDelay 代表准备延迟
        Observable.intervalRange(2,5,2,1,TimeUnit.SECONDS)
            .subscribe {
                println(it)
            }

    }
}