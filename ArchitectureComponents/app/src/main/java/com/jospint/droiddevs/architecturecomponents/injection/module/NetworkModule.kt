package com.jospint.droiddevs.architecturecomponents.injection.module

import android.content.Context
import com.jakewharton.picasso.OkHttp3Downloader
import com.jospint.droiddevs.architecturecomponents.BuildConfig
import com.jospint.droiddevs.architecturecomponents.injection.annotation.ApplicationQualifier
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    @ApplicationQualifier
    fun provideOkHttpClient(): OkHttpClient {
        val client = OkHttpClient()
        if (BuildConfig.DEBUG) {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            return client.newBuilder().addInterceptor(logging).build()
        }
        return client
    }

    @Provides
    @Singleton
    fun providePicasso(@ApplicationQualifier context: Context, @ApplicationQualifier okHttpClient: OkHttpClient)
            = Picasso.Builder(context).downloader(OkHttp3Downloader(okHttpClient)).build()!!

    @Provides
    @Singleton
    fun provideMoshi() = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()!!

}