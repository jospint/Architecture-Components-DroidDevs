package com.jospint.droiddevs.architecturecomponents.util.extension

import android.arch.lifecycle.MutableLiveData
import com.jospint.droiddevs.architecturecomponents.util.Resource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun <T> Call<T>.enqueueToResource(): MutableLiveData<Resource<T>> {
    return enqueueToResource(null, null)
}

fun <T> Call<T>.enqueueToResource(errorMessage: String?): MutableLiveData<Resource<T>> {
    return enqueueToResource(errorMessage, null)
}

fun <T> Call<T>.enqueueToResource(errorMessage: String?, loadingMessage: String?): MutableLiveData<Resource<T>> {
    val liveData = MutableLiveData<Resource<T>>()
    liveData.value = Resource.loading(loadingMessage);
    this.enqueue(object : Callback<T> {
        override fun onResponse(call: Call<T>?, response: Response<T>?) {
            liveData.value = Resource.success(response?.body()!!);
        }

        override fun onFailure(call: Call<T>?, t: Throwable?) {
            liveData.value = Resource.error(errorMessage ?: t.toString())
        }
    })
    return liveData
}
