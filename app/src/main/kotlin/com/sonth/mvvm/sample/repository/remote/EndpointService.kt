package com.sonth.mvvm.sample.repository.remote

import retrofit2.Retrofit

class EndpointService(retrofit: Retrofit) {
    val endpointInterface: EndpointInterface = retrofit.create(EndpointInterface::class.java)
}