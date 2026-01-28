package com.cyberstarege.kotfinance

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class KotFinanceApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidLogger()
            androidContext(this@KotFinanceApplication)
        }
    }
}