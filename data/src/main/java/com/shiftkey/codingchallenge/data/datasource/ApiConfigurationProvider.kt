package com.shiftkey.codingchallenge.data.datasource

import android.content.Context
import com.shiftkey.codingchallenge.R
import javax.inject.Inject

class ApiConfigurationProvider
@Inject constructor(private val context: Context) {

    fun provideApiEndpoint() = context.resources.getString(R.string.api_endpoint)
}
