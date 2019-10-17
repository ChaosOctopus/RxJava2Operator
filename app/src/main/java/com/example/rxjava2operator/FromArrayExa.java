package com.example.rxjava2operator;

import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by zhaoyuanchao on 2019-10-17.
 *  和Just差不多，只不过是支持十个数据以上，并且支持数组
 */
public class FromArrayExa {
    public static final String TAG = "FromArrayExa";
    public FromArrayExa() {
        Integer[] array = {1, 3, 5};
        Observable.fromArray(array)
                .subscribe(new Observer<Integer>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(TAG,"onSubscribe");
                    }

                    @Override
                    public void onNext(Integer integer) {
                        Log.e(TAG,integer+"");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(TAG,"onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG,"onComplete");
                    }
                });
    }
}
