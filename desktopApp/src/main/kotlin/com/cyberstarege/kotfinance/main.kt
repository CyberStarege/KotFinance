package com.cyberstarege.kotfinance.com.cyberstarege.kotfinance

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.cyberstarege.kotfinance.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "kotfinance",
    ) {
        App()
    }
}