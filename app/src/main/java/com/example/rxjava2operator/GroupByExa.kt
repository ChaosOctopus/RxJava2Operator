package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable

/**
 * Created by zhaoyuanchao on 2019-10-17.
 * 将发送的数据进行分组,每个分组会返回一个被观察者对象
 */
@SuppressLint("CheckResult")
class GroupByExa {

    init {
        Observable.just(5,2,3,4,1,7,8,9,6,0)
            .groupBy {
                return@groupBy it % 3
            }

            .subscribe {
                it.subscribe {count->
                    println("Group:${it.key} --- Info:$count")
                }
            }
    }
}