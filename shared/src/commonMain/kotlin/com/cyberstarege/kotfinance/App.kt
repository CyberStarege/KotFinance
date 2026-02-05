package com.cyberstarege.kotfinance

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.cyberstarege.kotfinance.core.designsystem.theme.KotFinanceTheme
import com.cyberstarege.kotfinance.feature.groups.GroupsScreen
import com.cyberstarege.kotfinance.feature.groups.groupsModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.includes
import org.koin.dsl.module

@Composable
@Preview
fun App() {
    KotFinanceTheme {
    }
}