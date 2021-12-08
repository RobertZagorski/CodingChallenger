package com.shiftkey.codingchallenge.data

import android.content.Context
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.shiftkey.codingchallenge.data.datasource.ApiConfigurationProvider
import com.shiftkey.codingchallenge.data.datasource.DATE_AND_TIME_WITH_TIMEZONE
import com.shiftkey.codingchallenge.data.datasource.DATE_FORMAT
import com.shiftkey.codingchallenge.data.datasource.ShiftApiProvider
import com.shiftkey.codingchallenge.data.datasource.jsondeserialiser.CalendarDeserializer
import com.shiftkey.codingchallenge.data.datasource.jsondeserialiser.TimezoneDeserializer
import com.shiftkey.codingchallenge.data.repository.ShiftListRepositoryImpl
import com.shiftkey.codingchallenge.repositories.ShiftListRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.Calendar
import java.util.TimeZone
import javax.inject.Singleton

@Module(includes = [RepositoriesModule::class])
@InstallIn(SingletonComponent::class)
class DataModule {

    @Singleton
    @Provides
    fun provideApiConfigurationProvider(@ApplicationContext appContext: Context): ApiConfigurationProvider {
        return ApiConfigurationProvider(appContext)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()

    @Singleton
    @Provides
    fun provideCallAdapterFactory(): CallAdapter.Factory = RxJava3CallAdapterFactory.createWithScheduler(Schedulers.io())

    @Singleton
    @Provides
    fun provideApiConverter(): Converter.Factory = GsonConverterFactory.create(
        GsonBuilder()
            .registerTypeAdapter(
                Calendar::class.java,
                CalendarDeserializer(
                    DATE_AND_TIME_WITH_TIMEZONE,
                    DATE_FORMAT
                )
            )
            .registerTypeAdapter(
                TimeZone::class.java,
                TimezoneDeserializer()
            )
            .setFieldNamingStrategy { field ->
                FieldNamingPolicy
                    .LOWER_CASE_WITH_UNDERSCORES
                    .translateName(field)
            }
            .create()
    )

    @Singleton
    @Provides
    fun provideRetrofitBuilder(): Retrofit.Builder = Retrofit.Builder()

    @Singleton
    @Provides
    fun provideShiftApi(
        retrofitBuilder: Retrofit.Builder,
        apiConfigurationProvider: ApiConfigurationProvider,
        okHttpClient: OkHttpClient,
        converterFactory: Converter.Factory,
        callAdapterFactory: CallAdapter.Factory
    ) = ShiftApiProvider(
        retrofitBuilder,
        apiConfigurationProvider,
        okHttpClient,
        converterFactory,
        callAdapterFactory
    )
        .provideApi()
}

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoriesModule {
    @Binds
    abstract fun provideShiftListRepository(shiftListRepository: ShiftListRepositoryImpl): ShiftListRepository
}
