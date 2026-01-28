package com.cyberstarege.kotfinance

import com.cyberstarege.kotfinance.feature.groups.groupsModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.includes
import org.koin.dsl.module

fun initKoin(config: KoinAppDeclaration? = null): KoinApplication {
    return startKoin {
        includes(config)
        modules(
            appModule
        )
    }
}

val appModule = module {
    includes(groupsModule)
}
