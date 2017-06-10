package com.jospint.droiddevs.architecturecomponents.view.start

import com.jospint.droiddevs.architecturecomponents.injection.annotation.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class StartModule {

    @Provides
    @ActivityScope
    fun providesAdapter(): PlacesAdapter {
        return PlacesAdapter()
    }

}