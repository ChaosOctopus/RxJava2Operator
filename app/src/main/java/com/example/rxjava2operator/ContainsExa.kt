package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.functions.Consumer

/**
 * Created by zhaoyuanchao on 2019-10-19.
 * 判断事件序列中是否包含某个元素
 */
@SuppressLint("CheckResult")
class ContainsExa {
    init {
        Observable.just(1,2,3,4)
            .contains(3)
            .subscribe(Consumer<Boolean> {
                println(it)
            })

    }

//    2019-10-19 15:46:28.145 26531-26531/com.example.rxjava2operator I/System.out: true
}