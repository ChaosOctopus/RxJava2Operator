package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import java.util.concurrent.TimeUnit

/**
 * Created by zhaoyuanchao on 2019-10-19.
 * 如果两事件发送的时间间隔小于设定的时间间隔则前一个事件就不会发送给观察者
 */
@SuppressLint("CheckResult")
class DebounceExa {
    init {
        Observable.create(object : ObservableOnSubscribe<Int>{
            override fun subscribe(emitter: ObservableEmitter<Int>) {
                emitter.onNext(1)
                Thread.sleep(900)
                emitter.onNext(2)
            }

        })
            .debounce(1,TimeUnit.SECONDS)
            .subscribe {
                println(it)
            }
    }

//    2019-10-19 14:43:59.937 24272-24296/com.example.rxjava2operator I/System.out: 2
}