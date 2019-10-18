package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Function
import java.util.concurrent.TimeUnit

/**
 * Created by zhaoyuanchao on 2019-10-18.
 *
 * 会将多个被观察者合并，根据各个被观察者发送事件的顺序一个个结合，最终发送事件数量
 * 会与源Observable中最少事件的数量一致
 */
@SuppressLint("CheckResult")
class ZipExa {
    init {
        Observable.zip(
            Observable.intervalRange(1,5,1,1,TimeUnit.SECONDS)
                .map { t -> "A$t"
                },
            Observable.intervalRange(1,7,1,1,TimeUnit.SECONDS)
                .map {t-> "B$t"
                },
            BiFunction<String, String, String> { t1, t2 -> "$t1 === $t2" }

        ).subscribe {
            println(it)
        }
    }
    /**
     * 可以发现最终接收到的事件数量是5，那么为什么第二个Observable没有发送第7个事件呢？
     * 因为在这第一个Observable已经发送了onComplete事件，所以第二个Observable不会再发送事件
     */

//    2019-10-18 10:16:42.149 32344-32368/com.example.rxjava2operator I/System.out: A1 === B1
//    2019-10-18 10:16:43.150 32344-32368/com.example.rxjava2operator I/System.out: A2 === B2
//    2019-10-18 10:16:44.150 32344-32367/com.example.rxjava2operator I/System.out: A3 === B3
//    2019-10-18 10:16:45.150 32344-32368/com.example.rxjava2operator I/System.out: A4 === B4
//    2019-10-18 10:16:46.150 32344-32368/com.example.rxjava2operator I/System.out: A5 === B5

}