package com.example.rxjava2operator

import android.annotation.SuppressLint
import android.util.Log
import io.reactivex.Observable
import java.util.concurrent.Callable
import java.util.function.Consumer

/**
 * Created by zhaoyuanchao on 2019-10-17.
 * 给观察者发送一个结果值. Callable 是 java.util.concurrent中的Callable
 */
@SuppressLint("CheckResult")
class FromCallableExa {
    val TAG = "FromCallableExa"
   init {
        Observable.fromCallable {
            return@fromCallable "Hello"
        }.subscribe {
            Log.e(TAG,it)
        }
    }
}