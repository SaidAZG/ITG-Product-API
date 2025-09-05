package com.example.itgproductapiapp.di.repository

import com.example.itgproductapiapp.data.api.ProductApi
import com.example.itgproductapiapp.data.repository.ProductRepositoryImpl
import com.example.itgproductapiapp.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductRepositoryModule {
    @Provides
    @Singleton
    fun provideMyRepository(api: ProductApi): ProductRepository {
        return ProductRepositoryImpl(api)
    }

}