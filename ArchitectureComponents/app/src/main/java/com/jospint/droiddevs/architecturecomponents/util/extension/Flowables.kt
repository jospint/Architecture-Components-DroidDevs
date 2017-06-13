package com.jospint.droiddevs.architecturecomponents.util.extension

import android.arch.lifecycle.*
import com.jospint.droiddevs.architecturecomponents.util.Resource
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Flowable<T>.enqueueToResource(): MutableLiveData<Resource<T>> {
    return enqueueToResource(null, null)
}

fun <T> Flowable<T>.enqueueToResource(errorMessage: String?): MutableLiveData<Resource<T>> {
    return enqueueToResource(errorMessage, null)
}

fun <T> Flowable<T>.enqueueToResource(errorMessage: String?, loadingMessage: String?): MutableLiveData<Resource<T>> {
    val result = MutableLiveData<Resource<T>>()
    result.value = Resource.loading(loadingMessage)
    this.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(
            { response -> result.value = Resource.success(response); },
            { e -> result.value = Resource.error(errorMessage ?: e.toString()) })
    return result
}

fun <T> Flowable<T>.enqueueToResourcealt(errorMessage: String?, loadingMessage: String?): MutableLiveData<Resource<T>> {
    val safeFlowable = this.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).doOnError {}
    val liveData = LiveDataReactiveStreams.fromPublisher(safeFlowable) as MutableLiveData<T>
    val result = MediatorLiveData<Resource<T>>()
    result.value = Resource.loading(loadingMessage)
    result.addSource(liveData) { emittedValue ->
        result.value = if (emittedValue is T) Resource.success(emittedValue) else Resource.error(errorMessage ?: emittedValue.toString());
    }
    return result
}