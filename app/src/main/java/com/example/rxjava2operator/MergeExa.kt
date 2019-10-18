package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable

/**
 * Created by zhaoyuanchao on 2019-10-18.
 *  作用：跟concat()的作用一致，但是是并行
 *  mergeArray 也可传超过4个参数
 */
@SuppressLint("CheckResult")
class MergeExa {
    init {
        Observable.merge(
            Observable.just(1, 2, 3),
            Observable.just(4, 5, 6),
            Observable.just(0, 9),
            Observable.just(11,23,32,3,333,4134 )

        )
            .subscribe {
                println(it)
            }
    }
}