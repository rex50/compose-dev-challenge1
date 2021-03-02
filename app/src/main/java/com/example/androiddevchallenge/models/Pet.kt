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
package com.example.androiddevchallenge.models

data class Pet(
    val id: Int,
    val name: String,
    val desc: String,
    val breed: String,
    val location: String,
    val gender: Gender,
    val birthYear: Int,
    val photo: String
)

enum class Gender(val text: String) {
    MALE("Male"),
    FEMALE("Female")
}

val locations = arrayListOf(
    "Surat",
    "Bangalore",
    "Ahmedabad",
    "Rajkot",
    "Mumbai",
    "Delhi",
    "Pune"
)

val years = arrayListOf(
    2019,
    2020,
    2021
)

val pets = arrayListOf(
    Pet(
        1,
        "Lel",
        "These puppies, undeniably one of the cutest dog breeds, grow fast and reach adulthood by about six months and crave an active lifestyle to be happy and healthy.",
        "Labrador retriever",
        locations.random(),
        Gender.MALE,
        years.random(),
        "https://images.unsplash.com/photo-1525105087384-cb271c5563d8?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1049&q=80"
    ),
    Pet(
        2,
        "Shaun",
        "Known for their keen intelligence, high energy, and loyalty, the German Shepherd is one of the most popular breeds of dog in the world. Despite their fearsome reputation, most owners find they are loyal, docile, obedient, and a loving family pet",
        "German shepherd",
        locations.random(),
        Gender.MALE,
        years.random(),
        "https://images.unsplash.com/photo-1564364584591-1f920330f17d?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1352&q=80"
    ),
    Pet(
        3,
        "Browny",
        "It’s probably one of the cutest dog breeds because the beagle keeps its adorable puppy face for most of its life—until those gray hairs eventually creep in around its face.",
        "Beagle",
        locations.random(),
        Gender.MALE,
        years.random(),
        "https://images.unsplash.com/photo-1512546321483-c0468b7b8a95?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1267&q=80"
    ),
    Pet(
        4,
        "Poodle",
        "The fluffy and “foo-foo” appearance of poodles hardly conjures up what poodles were originally bred to do—retrieve prey from the water but all that fur (which is actually hair) protects joints from the cold water.",
        "Poodles",
        locations.random(),
        Gender.FEMALE,
        years.random(),
        "https://images.unsplash.com/photo-1568106640696-a04935b09b21?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=634&q=80"
    ),
    Pet(
        5,
        "Yuri",
        "Spunky and sassy these cute little divas are viewed as the pampered breed, but it’s origin began far away from the penthouse set. Back in 19th century England, they were bred to chase rats.",
        "Yorkshire terrier",
        locations.random(),
        Gender.FEMALE,
        years.random(),
        "https://images.unsplash.com/photo-1536055449612-f4bb488b243e?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80"
    ),
    Pet(
        6,
        "Koo",
        "The Siberian husky is part of the Spitz family, which is a breed of dogs that have thick furry coats to shield bitter cold, prick ears, and a wedge-shaped face.",
        "Siberian husky",
        locations.random(),
        Gender.MALE,
        years.random(),
        "https://images.unsplash.com/photo-1574273443477-87bf272e5100?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1352&q=80"
    )
)
