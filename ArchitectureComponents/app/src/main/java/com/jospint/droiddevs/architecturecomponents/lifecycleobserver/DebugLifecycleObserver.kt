package com.jospint.droiddevs.architecturecomponents.lifecycleobserver

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.OnLifecycleEvent
import android.arch.lifecycle.LifecycleObserver
import timber.log.Timber

class DebugLifecycleObserver : LifecycleObserver {

    var activityName: String = "";

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Timber.d(activityName + ".onCreate() has been called")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Timber.d(activityName + ".onStart() has been called!")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Timber.d(activityName + ".onResume() has been called!")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Timber.d(activityName + ".onPause() has been called!")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Timber.d(activityName + ".onStop() has been called!")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Timber.d(activityName + ".onDestroyed() has been called")
    }

}