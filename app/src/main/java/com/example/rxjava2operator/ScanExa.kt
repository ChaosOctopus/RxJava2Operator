package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable

/**
 * Created by zhaoyuanchao on 2019-10-17.
 * 将数据以一定逻辑聚合起来
 */
@SuppressLint("CheckResult")
class ScanExa {
    init {
        //求发送事件数据的和
        Observable.just(1,2,3,4,5,6,7,8,9,0)
            .scan { t1: Int, t2: Int ->
                return@scan t1+t2
            }
            .subscribe {
                println(it)
            }
    }
}