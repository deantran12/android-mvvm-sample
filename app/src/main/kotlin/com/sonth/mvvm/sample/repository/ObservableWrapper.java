package com.sonth.mvvm.sample.repository;


import io.reactivex.Observable;

public interface ObservableWrapper<T> {
    Observable<T> getObservable();
}
