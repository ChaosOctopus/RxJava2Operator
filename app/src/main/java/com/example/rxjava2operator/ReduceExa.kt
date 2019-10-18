package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable

/**
 * Created by zhaoyuanchao on 2019-10-18.
 * 将发送的数据以一定逻辑聚合在一起，
 * 注意：
 *      Scan:每处理一次数据，都会发送给观察者
 *      Reduce():会将所有数据聚合在一起才会发送事件给观察者
 */
@SuppressLint("CheckResult")
class ReduceExa {
    init {
        Observable.just(0,1,2,3)
            .reduce { t1: Int, t2: Int ->
                return@reduce t1+t2
            }
            .subscribe {
                println(it)
            }

        /**
         * 会将数据依次累加，返回一个最终结果 6
         */
    }
}