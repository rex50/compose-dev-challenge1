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
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.androiddevchallenge.models.Pet
import com.example.androiddevchallenge.models.pets
import com.example.androiddevchallenge.ui.HomeToolbar
import com.example.androiddevchallenge.ui.PetCard
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.utils.Constants.Keys.KEY_DATA
import com.example.androiddevchallenge.utils.Constants.Keys.KEY_POSITION

class PetListFragment : Fragment() {

    companion object {
        const val TAG = "PetListFragment"
        const val APP_NAME = "Adopty"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {

                val isDarkTheme = PetApplication.getInstance()?.isDarkTheme() ?: false

                MyTheme(darkTheme = isDarkTheme) {
                    Column {
                        HomeToolbar(
                            title = MainActivity.APP_NAME, darkTheme = isDarkTheme,
                            onThemeChange = {
                                PetApplication.getInstance()?.toggleTheme()
                            }
                        )
                        PetsListView { index, pet ->
                            val bundle = bundleOf(
                                Pair(KEY_POSITION, index),
                                Pair(KEY_DATA, pet.id)
                            )
                            findNavController().navigate(R.id.viewPet, bundle)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PetsListView(onPetClicked: (Int, Pet) -> Unit) {
    Surface(color = MaterialTheme.colors.background) {
        LazyColumn(
            content = {
                itemsIndexed(pets) { index, item ->
                    PetCard(
                        modifier = Modifier
                            .padding(16.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .clickable {
                                onPetClicked(index, item)
                            },
                        pet = item
                    )
                }
            }
        )
    }
}

/*@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        HomeToolbar(title = APP_NAME, onThemeChange = { *//*TODO*//* })
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        HomeToolbar(title = APP_NAME, darkTheme = true, onThemeChange = { *//*TODO*//* })
        MyApp()
    }
}*/
