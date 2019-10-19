package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.functions.Consumer

/**
 * Created by zhaoyuanchao on 2019-10-19.
 * 判断事件序列是否全部满足某个事件，如果都全部满足则返回true,else false
 */
@SuppressLint("CheckResult")
class AllExa {
    init {
        Observable.just(1,2,3,4)
            .all {
                return@all it > 5
            }
            .subscribe(Consumer<Boolean> {
                println(it)
            })

    }

//    2019-10-19 14:56:46.124 24857-24857/com.example.rxjava2operator I/System.out: false
}