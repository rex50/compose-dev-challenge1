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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.models.Pet
import com.example.androiddevchallenge.models.pets
import com.example.androiddevchallenge.ui.theme.ColorsUtil
import com.example.androiddevchallenge.ui.theme.lightGrey
import dev.chrisbanes.accompanist.coil.CoilImage

@Preview
@Composable
private fun DefaultPetCard() {
    PetCard(isPreview = true)
}

@Composable
fun PetCard(
    modifier: Modifier = Modifier,
    pet: Pet = pets[0],
    isPreview: Boolean = false,
) {

    Card(
        modifier = modifier,
        elevation = 8.dp,
        shape = RoundedCornerShape(8.dp),
        backgroundColor = ColorsUtil.getRandom()
    ) {

        Column {

            if (isPreview) {
                Image(
                    modifier = Modifier
                        .padding(PaddingValues(8.dp))
                        .fillMaxWidth()
                        .height(177.dp),
                    painter = painterResource(R.mipmap.img_sample),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            } else {
                CoilImage(
                    modifier = Modifier
                        .padding(PaddingValues(8.dp))
                        .fillMaxWidth()
                        .height(177.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    data = pet.photo,
                    contentDescription = "Image of ${pet.name}",
                    fadeIn = true,
                    contentScale = ContentScale.Crop
                )
            }

            Box(
                modifier = Modifier
                    .height(IntrinsicSize.Min)
                    .fillMaxWidth()
            ) {

                Text(
                    modifier = Modifier
                        .padding(PaddingValues(8.dp)),
                    text = pet.name,
                    style = MaterialTheme.typography.h4.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color.DarkGray
                    )
                )

                Row(
                    modifier = Modifier
                        .padding(8.dp, 0.dp, 8.dp, 8.dp)
                        .align(Alignment.BottomEnd)
                        .offset(y = (-6).dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {

                    Text(
                        modifier = Modifier
                            .wrapContentHeight(),
                        text = pet.location,
                        textAlign = TextAlign.Center,
                        style = TextStyle(color = lightGrey)
                    )

                    Icon(
                        Icons.Default.LocationOn,
                        contentDescription = "",
                        tint = lightGrey,
                    )
                }
            }
        }
    }
}
