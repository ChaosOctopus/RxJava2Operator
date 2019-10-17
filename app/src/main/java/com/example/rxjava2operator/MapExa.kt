package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable

/**
 * Created by zhaoyuanchao on 2019-10-17.
 * map可以将被观察者发送的数据类型转换变成其他类型
 * 注意：是事件的数据类型
 */
@SuppressLint("CheckResult")
class MapExa {
    init {
        //将int  chang to string
        Observable.just(1,2,3)
            .map {
                return@map "$it with mapChange"
            }
            .subscribe {
                println(it)
            }
    }
}