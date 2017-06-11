package com.jospint.droiddevs.architecturecomponents.util

import android.arch.lifecycle.*
import io.reactivex.Flowable


class FlowableLiveData<T>(private val flowable: Flowable<T>) : MutableLiveData<T>() {

    override fun observe(owner: LifecycleOwner?, observer: Observer<T>?) {
        LiveDataReactiveStreams.fromPublisher(flowable).observe(owner, observer)
    }
}