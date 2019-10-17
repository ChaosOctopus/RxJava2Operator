package com.example.rxjava2operator

import android.annotation.SuppressLint
import io.reactivex.Observable
import java.util.ArrayList

/**
 * Created by zhaoyuanchao on 2019-10-17.
 * 跟Map比较 FlatMap是将元素进行一个整合加工返回一个新的被观察者对象
 * 注意：返回的是新的被观察者对象
 *
 * 跟concatMap比较：
 *      concatMap是有序的
 *      flatMap是无序的
 */
@SuppressLint("CheckResult")
class FlatMapExa {
    init {
        //打印 每个人计划下的所有详情
        var actionList = ArrayList<String>()
        for (i in 0..10){
           actionList.add("这是计划的第${i}步骤")
        }
        var planList = ArrayList<Plan>()
        for (i in 0..6){
            var plan = Plan(actionList)
            planList.add(plan)
        }

        var student = ArrayList<Person>()
        for (i in 0..3) {
            var stu = Person("同学号码:$i",planList)
            student.add(stu)
        }

        //打印所有同学的计划行动列表

        Observable.fromIterable(student)
            .flatMap {
                return@flatMap Observable.fromIterable(it.planList)
            }
            .flatMap {
                return@flatMap Observable.fromIterable(it.actionList)
            }
            .subscribe {
                println(it)
            }


    }

}

data class Plan(

    val actionList:List<String>
)

data class Person(
    val name:String,
    val planList: List<Plan>
)

