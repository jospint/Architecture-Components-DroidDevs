package com.jospint.droiddevs.architecturecomponents.view

import android.arch.lifecycle.LifecycleActivity
import android.os.Bundle
import com.jospint.droiddevs.architecturecomponents.lifecycleobserver.DebugLifecycleObserver
import dagger.android.AndroidInjection
import org.jetbrains.anko.act
import javax.inject.Inject

abstract class BaseActivity : LifecycleActivity() {

    @Inject
    lateinit var debugLifecycleObserver: DebugLifecycleObserver;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(act)
        lifecycle.addObserver(debugLifecycleObserver)
        debugLifecycleObserver.activityName = localClassName.toString()
    }
}