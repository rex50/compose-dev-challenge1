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
package com.example.androiddevchallenge.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
private fun DefaultHomeToolbar() {
    HomeToolbar(
        title = "Home title", darkTheme = true,
        onThemeChange = {
            // TODO
        }
    )
}

@Preview
@Composable
private fun DefaultToolbarWithBack() {
    ToolBarWithBack(title = "Some title", onBackPressed = { /*TODO*/ })
}

@Composable
fun HomeToolbar(
    modifier: Modifier = Modifier,
    darkTheme: Boolean = false,
    title: String,
    backgroundColor: Color = MaterialTheme.colors.background,
    onThemeChange: (Boolean) -> Unit
) {

    Surface(color = backgroundColor) {

        Box(
            modifier = modifier
                .height(60.dp)
                .fillMaxWidth()
                .padding(PaddingValues(16.dp, 8.dp)),
        ) {

            Text(
                modifier = Modifier.align(Alignment.CenterStart),
                text = title,
                style = MaterialTheme.typography.h5.copy(
                    fontWeight = FontWeight.Bold
                )
            )

            IconButton(
                modifier = Modifier.align(Alignment.CenterEnd),
                onClick = {
                    onThemeChange(!darkTheme)
                }
            ) {

                Icon(
                    imageVector = if (darkTheme)
                        Icons.Default.LightMode
                    else
                        Icons.Default.DarkMode,
                    contentDescription = "Change theme button"
                )
            }
        }
    }
}

@Composable
fun ToolBarWithBack(
    modifier: Modifier = Modifier,
    title: String,
    backgroundColor: Color = MaterialTheme.colors.background,
    onBackPressed: () -> Unit
) {

    Surface(color = backgroundColor) {
        Row(
            modifier = modifier
                .height(60.dp)
                .fillMaxWidth()
                .padding(PaddingValues(8.dp, 8.dp)),
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                /*modifier = Modifier.align(Alignment.CenterEnd),*/
                onClick = {
                    onBackPressed()
                }
            ) {

                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back button"
                )
            }

            Spacer(
                modifier = Modifier.padding(5.dp, 0.dp)
            )

            Text(
                /*modifier = Modifier.align(Alignment.CenterStart),*/
                text = title,
                style = MaterialTheme.typography.h5.copy(
                    fontWeight = FontWeight.Bold
                )
            )
        }
    }
}
