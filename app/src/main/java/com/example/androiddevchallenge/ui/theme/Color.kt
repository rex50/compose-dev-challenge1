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
package com.example.androiddevchallenge.ui.theme

import androidx.compose.ui.graphics.Color

val purple200 = Color(0xFFBB86FC)
val purple500 = Color(0xFF6200EE)
val purple700 = Color(0xFF3700B3)
val teal200 = Color(0xFF03DAC5)
val red200 = Color(0xFFffcdd2)
val pink200 = Color(0xFFF8BBD0)
val deepPurple200 = Color(0xFFD1C4E9)
val indigo200 = Color(0xFFC5CAE9)
val blue200 = Color(0xFFBBDEFB)
val lightBlue200 = Color(0xFFB3E5FC)
val cyan200 = Color(0xFFB2EBF2)
val green200 = Color(0xFFC8E6C9)
val lightGreen200 = Color(0xFFDCEDC8)

val lightGrey = Color(0xFF525252)

object ColorsUtil {

    private val colors = arrayListOf<Color>()
        get() {
            if (field.isEmpty()) {
                field.addAll(
                    arrayListOf(
                        teal200,
                        red200,
                        pink200,
                        deepPurple200,
                        indigo200,
                        blue200,
                        lightBlue200,
                        cyan200,
                        green200,
                        lightGreen200
                    )
                )
            }
            return field
        }

    fun getRandom(): Color = colors.random()
}
