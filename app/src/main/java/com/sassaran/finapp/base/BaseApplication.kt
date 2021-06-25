package com.inspirenetz.netzapp.base

import android.app.Activity
import android.app.Application
import android.content.pm.ActivityInfo
import android.os.Bundle
import com.google.gson.GsonBuilder
import com.sassaran.finapp.network.ApiInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

public class BaseApplication : Application() {

    var baseApplication: BaseApplication? = null

    private var apiClient: ApiInterface? = null


    override fun onCreate() {
        super.onCreate()

        baseApplication = this

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder().addInterceptor(interceptor)
            .readTimeout(120, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(120, TimeUnit.SECONDS)
            .build()

        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        apiClient = retrofit.create(ApiInterface::class.java)

        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(
                activity: Activity,
                savedInstanceState: Bundle?
            ) {
                activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            }

            override fun onActivityStarted(activity: Activity) {}
            override fun onActivityResumed(activity: Activity) {}
            override fun onActivityPaused(activity: Activity) {}
            override fun onActivityStopped(activity: Activity) {}
            override fun onActivitySaveInstanceState(
                activity: Activity,
                outState: Bundle
            ) {
            }

            override fun onActivityDestroyed(activity: Activity) {}
        })

    }

    companion object {
        private lateinit var INSTANCE : BaseApplication
        val instance: BaseApplication?
            get() {
                    synchronized(BaseApplication::class.java) {
                            INSTANCE =
                                BaseApplication()
                    }

                return INSTANCE
            }
    }





  /*  override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val component: ApplicationComp =
            DaggerApplicationComponent.builder().application(this).build()
        component.inject(this)
        return applicationInjector()
    }*/
  open fun getApiClient(): ApiInterface? {
      return apiClient
  }


}