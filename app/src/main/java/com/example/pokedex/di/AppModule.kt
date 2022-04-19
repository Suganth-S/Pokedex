package com.example.pokedex.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * When using dagger for DI, we need to define such modules in which we just define how we
 * construct our dependencies so that dagger is actually able to inject these into our classes
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    
}