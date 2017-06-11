package com.jospint.droiddevs.architecturecomponents.injection.module

import com.jospint.droiddevs.architecturecomponents.injection.annotation.ActivityScope
import com.jospint.droiddevs.architecturecomponents.lifecycleobserver.DebugLifecycleObserver
import dagger.Module
import dagger.Provides

@Module
class LifecycleObserversModule {

    @Provides
    @ActivityScope
    fun providesDebugLifecycleModule(): DebugLifecycleObserver {
        return DebugLifecycleObserver()
    }

}