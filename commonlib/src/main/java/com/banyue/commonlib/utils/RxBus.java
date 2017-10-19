package com.banyue.commonlib.utils;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * Created by Administrator on 2017/8/16.
 */

public class RxBus {
    private final Subject<Object> mBus;
    private Disposable mDisposable;

    private RxBus() {
        // toSerialized method made bus thread safe
        mBus = PublishSubject.create().toSerialized();
    }

    public static RxBus get() {
        return Holder.BUS;
    }

    public void post(Object obj) {
        mBus.onNext(obj);
    }

    //该方法在无法注销时使用，如view中
    public <T> Observable<T> toObservable(Class<T> tClass) {
        return mBus.ofType(tClass).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Object> toObservable() {
        return mBus;
    }

    public boolean hasObservers() {
        return mBus.hasObservers();
    }

    //在activity/Fragment中使用
    public <T> void subscribe(Class<T> tClass, Consumer<T> consumer) {
        mDisposable = toObservable(tClass).subscribe(consumer);
    }

    //在activity/Fragment中使用
    public void unSubscribe() {
        if (mDisposable != null && !mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }

    private static class Holder {
        private static final RxBus BUS = new RxBus();
    }
}
