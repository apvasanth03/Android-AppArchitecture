package com.vasanth.apparchitecture.data.di

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.vasanth.apparchitecture.data.datasource.remote.service.UserService
import com.vasanth.apparchitecture.data.repository.BaseUserRepository
import com.vasanth.apparchitecture.data.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    companion object {

        @Provides
        @Singleton
        fun provideGson(): Gson {
            val gson = GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create()
            return gson
        }

        @Provides
        @Singleton
        fun provideGsonConverterFactory(
            gson: Gson
        ): GsonConverterFactory {
            return GsonConverterFactory.create(gson)
        }

        @Singleton
        @Provides
        fun provideUserService(
            gsonConverterFactory: GsonConverterFactory
        ): UserService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(gsonConverterFactory)
                .build()
            return retrofit.create(UserService::class.java)
        }
    }

    @Binds
    abstract fun bindUserRepository(baseUserRepository: BaseUserRepository): UserRepository
}