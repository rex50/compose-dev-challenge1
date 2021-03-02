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

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Wc
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.androiddevchallenge.models.Pet
import com.example.androiddevchallenge.models.pets
import com.example.androiddevchallenge.ui.ToolBarWithBack
import com.example.androiddevchallenge.ui.theme.ColorsUtil
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.lightGrey
import com.example.androiddevchallenge.utils.Constants.Keys.KEY_DATA
import dev.chrisbanes.accompanist.coil.CoilImage

class PetFragment : Fragment() {

    var petId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getInt(KEY_DATA)?.let { id ->
            petId = id
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {

                // Find the pet
                val pet = pets.filter { it.id == petId }.let {
                    if (it.isEmpty()) {
                        null
                    } else
                        it[0]
                }

                val isDarkTheme = PetApplication.getInstance()?.isDarkTheme() ?: false

                MyTheme(darkTheme = isDarkTheme) {

                    if (pet == null) {
                        Text(text = "Oops! Something went wrong. Please try again.")
                    } else {
                        Column {

                            ToolBarWithBack(
                                title = pet.name,
                                onBackPressed = {
                                    findNavController().navigateUp()
                                }
                            )

                            PetDetailsView(pet = pet)
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun defaultPetDetailsView() {
    PetDetailsView(pet = pets[0])
}

@Composable
fun PetDetailsView(pet: Pet) {

    val context = LocalContext.current

    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        color = MaterialTheme.colors.background
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            item { PetDescHeaderView(pet = pet) }

            item {
                TextWithIconAtTop(
                    modifier = Modifier.padding(0.dp, 60.dp, 0.dp, 0.dp),
                    title = pet.location,
                    shortDesc = pet.birthYear.toString(),
                    icon = Icons.Default.LocationOn
                )
            }

            item {
                DescriptionView(
                    desc = pet.desc
                )
            }

            item {
                AdoptButton(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
                    onAdoptionClicked = {
                        Toast.makeText(context, "So kind of you ❤", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    }
}

@Composable
private fun DefaultPetDescHeaderView() {
    PetDescHeaderView(pet = pets[0])
}

@Composable
fun PetDescHeaderView(
    modifier: Modifier = Modifier,
    pet: Pet
) {

    Box(
        modifier = modifier
    ) {
        CoilImage(
            modifier = Modifier
                .padding(PaddingValues(8.dp))
                .fillMaxWidth()
                .aspectRatio(1F)
                .clip(RoundedCornerShape(8.dp)),
            data = pet.photo,
            contentDescription = "Image of ${pet.name}",
            fadeIn = true,
            contentScale = ContentScale.Crop
        )

        Card(
            modifier = Modifier
                .padding(28.dp, 0.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .offset(y = 25.dp),
            elevation = 8.dp,
            shape = RoundedCornerShape(8.dp),
            backgroundColor = ColorsUtil.getRandom()
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {

                ItemWithIcon(
                    modifier = Modifier.weight(1f),
                    title = "Breed",
                    desc = pet.breed,
                    Icons.Default.Pets
                )

                ItemWithIcon(
                    modifier = Modifier.weight(1f),
                    title = "Gender",
                    desc = pet.gender.text,
                    Icons.Default.Wc
                )
            }
        }
    }
}

@Composable
fun ItemWithIcon(
    modifier: Modifier = Modifier,
    title: String,
    desc: String,
    icon: ImageVector
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(
                imageVector = icon,
                contentDescription = "Icon for $title",
                tint = lightGrey,
            )

            Text(
                text = title,
                style = MaterialTheme.typography.h6.copy(
                    fontWeight = FontWeight.Bold,
                    color = lightGrey
                )
            )
        }

        Text(
            text = desc,
            style = MaterialTheme.typography.body1.copy(
                color = lightGrey
            )
        )
    }
}

@Composable
fun DefaultLocationView() {
    TextWithIconAtTop(title = "Delhi", icon = Icons.Default.LocationOn)
}

@Composable
fun TextWithIconAtTop(
    modifier: Modifier = Modifier,
    title: String,
    shortDesc: String = "",
    icon: ImageVector
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            modifier = Modifier
                .width(30.dp)
                .aspectRatio(1f),
            imageVector = icon,
            contentDescription = title,
            tint = if (MaterialTheme.colors.isLight) lightGrey else Color.White,
        )

        Spacer(modifier = Modifier.padding(0.dp, 1.dp))

        Text(
            text = title,
            style = MaterialTheme.typography.h5.copy(
                fontWeight = FontWeight.Bold,
            ),
            textAlign = TextAlign.Center
        )

        if (shortDesc.isNotBlank()) {
            Text(
                text = shortDesc,
                style = MaterialTheme.typography.h6.copy(
                    fontWeight = FontWeight.Medium,
                ),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun DefaultDescriptionView() {
    DescriptionView(desc = pets[0].desc)
}

@Composable
fun DescriptionView(
    modifier: Modifier = Modifier,
    desc: String
) {

    Text(
        modifier = modifier
            .padding(24.dp, 16.dp),
        text = desc,
        textAlign = TextAlign.Start,
        style = MaterialTheme.typography.body1
    )
}

@Composable
fun AdoptButton(
    modifier: Modifier = Modifier,
    onAdoptionClicked: () -> Unit
) {

    Button(
        modifier = modifier.padding(8.dp),
        onClick = {
            onAdoptionClicked()
        }
    ) {

        Icon(
            imageVector = Icons.Default.Favorite,
            contentDescription = "Adopt Button",
            tint = if (MaterialTheme.colors.isLight) Color.White else lightGrey,
        )

        Text(
            text = "Adopt this puppy",
            style = MaterialTheme.typography.button
        )
    }
}
