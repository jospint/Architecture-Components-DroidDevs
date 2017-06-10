package com.jospint.droiddevs.architecturecomponents.data.darksky

import com.jospint.droiddevs.architecturecomponents.injection.module.NetworkModule
import com.jospint.droiddevs.architecturecomponents.injection.annotation.ApplicationQualifier
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module(includes = arrayOf(NetworkModule::class))
class DarkSkyModule {

    @Provides
    @Singleton
    fun provideDarkSkyApi(
            @ApplicationQualifier okHttpClient: OkHttpClient, moshi: Moshi) =
            Retrofit.Builder()
                    .baseUrl(DarkSkyApi.BASE_URL)
                    .client(okHttpClient)
                    .addConverterFactory(MoshiConverterFactory.create(moshi))
                    .build().create(DarkSkyApi::class.java)!!

}