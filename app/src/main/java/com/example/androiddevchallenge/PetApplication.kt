/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.app.Application
import android.content.res.Configuration
import androidx.compose.runtime.mutableStateOf

class PetApplication : Application() {

    companion object {

        private var app: PetApplication? = null

        fun getInstance(): PetApplication? {
            if (app == null)
                app = PetApplication()

            return app
        }
    }

    // TODO: store this value in local storage
    private val isDark = mutableStateOf(false)

    fun isDarkTheme(): Boolean {
        return isDark.value
    }

    fun toggleTheme(darkTheme: Boolean = !isDark.value) {
        isDark.value = darkTheme
    }

    override fun onCreate() {
        super.onCreate()
        app = this
        if (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES)
            toggleTheme()
    }

    override fun onTerminate() {
        super.onTerminate()
        app = null
    }
}
