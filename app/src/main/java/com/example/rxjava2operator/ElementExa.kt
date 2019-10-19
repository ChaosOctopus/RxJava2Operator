package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable

/**
 * Created by zhaoyuanchao on 2019-10-19.
 * firstElement():取事件序列的第一个元素
 * lastElement():取事件序列的最后一个元素
 * elementAt():可以指定取出事件序列中的事件，但是输入的index超出事件序列的总数的话就不会出现任何结果
 * elementAtOrError():用于超出事件序列，发出异常信息
 */
@SuppressLint("CheckResult")
class ElementExa {
    init {
            Observable.just(1,2,3,45)
                .firstElement()
                .subscribe {
                    println(it)
                }

        Observable.just(1,23,45,4,5,5)
            .elementAt(3)
            .subscribe {
                println(it)
            }
    }

//    2019-10-19 14:48:58.367 24495-24495/com.example.rxjava2operator I/System.out: 1

    /**
     * index初始值为0
     */
//    2019-10-19 14:52:23.543 24660-24660/com.example.rxjava2operator I/System.out: 4
}