package com.example.rxjava2operator

import android.annotation.SuppressLint
import android.util.Log
import io.reactivex.Observable
import java.util.concurrent.Callable
import java.util.concurrent.FutureTask
import java.util.function.Consumer

/**
 * Created by zhaoyuanchao on 2019-10-17.
 *  参数中的Future的作用是增加了cancel()等方法来操作Callable,
 *  它可以通过get()方法来获取Callable返回的值
 */
@SuppressLint("CheckResult")
class FromFutureExa {
    val TAG = "FromFutureExa"
     init {
        var futureTask = FutureTask<String>(Callable<String> {
            Log.e(TAG,"执行futureTask")
            "Future的返回结果"
        })

        Observable.fromFuture(futureTask)
            .doOnSubscribe {
                //doOnSubscribe 只有在订阅时才会执行
                Log.e(TAG,"doOnSubscribe")
                futureTask.run()
            }
            .subscribe {
                Log.e(TAG,it)
            }

    }
}