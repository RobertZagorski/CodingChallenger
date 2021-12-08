package com.shiftkey.codingchallenge.data.datasource

import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Inject

class ShiftApiProvider
@Inject constructor(
    private val retrofitBuilder: Retrofit.Builder,
    private val apiConfigurationProvider: ApiConfigurationProvider,
    private val okHttpClient: OkHttpClient,
    private val converterFactory: Converter.Factory,
    private val callAdapterFactory: CallAdapter.Factory
) {

    fun provideApi(): ShiftApi {
        val retrofit = retrofitBuilder
            .baseUrl(apiConfigurationProvider.provideApiEndpoint())
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(callAdapterFactory)
            .client(okHttpClient)
            .build()
        return retrofit.create(ShiftApi::class.java)
    }
}
