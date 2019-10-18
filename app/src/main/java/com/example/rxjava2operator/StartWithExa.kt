package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable

/**
 * Created by zhaoyuanchao on 2019-10-18.
 * 在发送事件之前追加事件
 * startWith(): 追加一个
 * startWithArray(): 追加多个
 */
@SuppressLint("CheckResult")
class StartWithExa {
    init {
        Observable.just(1,2,3)
            .startWith(0)
            .startWithArray(-1,-2,-3)
            .subscribe {
                println(it)
            }
    }
    /**
     * startwith 和 startWithArray优先级一致，谁在下面谁先执行
     */
}