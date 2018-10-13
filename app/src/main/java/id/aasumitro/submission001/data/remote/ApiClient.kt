package id.aasumitro.submission001.data.remote

import id.aasumitro.submission001.util.AppConst
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Agus Adhi Sumitro on 28/08/2018.
 * https://aasumitro.id
 * aasumitro@gmail.com
 */

class ApiClient {

    private fun provideOkHttpClient(): OkHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY))
            .build()

    private fun provideRetrofit(): Retrofit = Retrofit
            .Builder()
            .baseUrl(AppConst.API_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttpClient())
            .build()

    fun apiServices(): ApiService = provideRetrofit()
            .create(ApiService::class.java)

}