package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable

/**
 * Created by zhaoyuanchao on 2019-10-18.
 *
 * doOnNext（）:onNext方法执行之前触发
 * doAfterNext():onNext方法执行之后触发
 * doOnComplete()：onComplete之前回调
 * doOnError():onError之前回调
 * doOnSubscribe():每次发送onSubScribe之前会回调这个方法
 * doOnDispose()：当调用Disposable的dispose()之后回调该方法
 */
@SuppressLint("CheckResult")
class DoOnNextExa {
    init {
        Observable.just(1,23,45,6)
            .doOnNext {
                println("$it:doOnNext")
            }
            .subscribe {
                println("$it:subscribe")
            }
    }

    /**
     * 由于只监听onNext事件的触发，所以onComplete,onError并不会触发doOnNext()
     */


//    2019-10-18 16:19:55.316 12963-12963/com.example.rxjava2operator I/System.out: 1:doOnNext
//    2019-10-18 16:19:55.317 12963-12963/com.example.rxjava2operator I/System.out: 1:subscribe
//    2019-10-18 16:19:55.317 12963-12963/com.example.rxjava2operator I/System.out: 23:doOnNext
//    2019-10-18 16:19:55.317 12963-12963/com.example.rxjava2operator I/System.out: 23:subscribe
//    2019-10-18 16:19:55.317 12963-12963/com.example.rxjava2operator I/System.out: 45:doOnNext
//    2019-10-18 16:19:55.317 12963-12963/com.example.rxjava2operator I/System.out: 45:subscribe
//    2019-10-18 16:19:55.317 12963-12963/com.example.rxjava2operator I/System.out: 6:doOnNext
//    2019-10-18 16:19:55.317 12963-12963/com.example.rxjava2operator I/System.out: 6:subscribe
}