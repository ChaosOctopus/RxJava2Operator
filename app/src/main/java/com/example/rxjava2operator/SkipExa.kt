package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable

/**
 * Created by zhaoyuanchao on 2019-10-19.
 * 跳过正序某些事件，count代表跳过的数量
 */
@SuppressLint("CheckResult")
class SkipExa {

    init {
        Observable.just(1,2,3)
            .skip(2)
            .subscribe {
                println(it)
            }
    }

//    2019-10-19 14:30:03.229 23304-23304/com.example.rxjava2operator I/System.out: 3
}