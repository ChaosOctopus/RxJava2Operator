package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable


/**
 * Created by zhaoyuanchao on 2019-10-17.
 * 从需要发送的事件当中获取一定数量的事件，并将这些事件放到缓冲区当中一并发出
 */
@SuppressLint("CheckResult")
class BufferExa {
    init {
        //count 缓冲区的大小  skip:跳过的元素数量
        Observable.just(1,2,3,4,5)
            .buffer(2,1)
            .subscribe { it ->
                println("缓冲区大小：${it.size}")
                it.map {
                    println("打印值：$it")
                }
            }
    }

    /**
     * 2019-10-17 17:27:42.744 32548-32548/com.example.rxjava2operator I/System.out: 缓冲区大小：2
     * 2019-10-17 17:27:42.745 32548-32548/com.example.rxjava2operator I/System.out: 打印值：1
     * 2019-10-17 17:27:42.745 32548-32548/com.example.rxjava2operator I/System.out: 打印值：2
       2019-10-17 17:27:42.745 32548-32548/com.example.rxjava2operator I/System.out: 缓冲区大小：2
       2019-10-17 17:27:42.745 32548-32548/com.example.rxjava2operator I/System.out: 打印值：2
       2019-10-17 17:27:42.745 32548-32548/com.example.rxjava2operator I/System.out: 打印值：3
       2019-10-17 17:27:42.745 32548-32548/com.example.rxjava2operator I/System.out: 缓冲区大小：2
       2019-10-17 17:27:42.745 32548-32548/com.example.rxjava2operator I/System.out: 打印值：3
       2019-10-17 17:27:42.745 32548-32548/com.example.rxjava2operator I/System.out: 打印值：4
       2019-10-17 17:27:42.745 32548-32548/com.example.rxjava2operator I/System.out: 缓冲区大小：2
       2019-10-17 17:27:42.745 32548-32548/com.example.rxjava2operator I/System.out: 打印值：4
       2019-10-17 17:27:42.745 32548-32548/com.example.rxjava2operator I/System.out: 打印值：5
       2019-10-17 17:27:42.745 32548-32548/com.example.rxjava2operator I/System.out: 缓冲区大小：1
       2019-10-17 17:27:42.745 32548-32548/com.example.rxjava2operator I/System.out: 打印值：5
     */
}