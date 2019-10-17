package com.example.rxjava2operator

import android.annotation.SuppressLint
import android.util.Log
import io.reactivex.Observable

/**
 * Created by zhaoyuanchao on 2019-10-17.
 * 直接发送一个集合数据给观察者
 */
@SuppressLint("CheckResult")
class FromIterableExa {
    val TAG = "FromIterableExa"
     init {
        val list = ArrayList<Int>()
        list.add(0)
        list.add(1)
        list.add(2)
        list.add(3)

        Observable.fromIterable(list)
            .subscribe {
                Log.e(TAG,"$it")
            }

    }
}