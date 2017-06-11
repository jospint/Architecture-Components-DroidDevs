package com.jospint.droiddevs.architecturecomponents.data.googlemaps

import com.jospint.droiddevs.architecturecomponents.data.darksky.DarkSkyApi
import com.jospint.droiddevs.architecturecomponents.injection.annotation.ApplicationQualifier
import com.jospint.droiddevs.architecturecomponents.injection.module.NetworkModule
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module(includes = arrayOf(NetworkModule::class))
class GoogleMapsModule {

    @Provides
    @Singleton
    fun provideGoogleMapsApi(
            @ApplicationQualifier okHttpClient: OkHttpClient, moshi: Moshi) =
            Retrofit.Builder()
                    .baseUrl(GoogleMapsApi.BASE_URL)
                    .client(okHttpClient)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create(moshi))
                    .build().create(GoogleMapsApi::class.java)!!
}