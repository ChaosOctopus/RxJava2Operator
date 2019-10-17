package com.example.rxjava2operator

import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by zhaoyuanchao on 2019-10-17.
 *  empty():直接发送onComplete()
 *  never():不发送任何事件
 *  error():发送onError()事件
 */
class ErrorAboutExt {
    init {
        //empty()
        Observable.empty<String>()
            .subscribe(object :Observer<String>{
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: String) {

                }

                override fun onError(e: Throwable) {

                }

            })

        //else pass
    }
}