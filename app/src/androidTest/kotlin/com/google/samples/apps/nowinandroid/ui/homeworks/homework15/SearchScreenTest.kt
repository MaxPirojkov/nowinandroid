/*
 * Copyright 2025 The Android Open Source Project
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

package com.google.samples.apps.nowinandroid.ui.homeworks.homework15

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.uiautomator.UiDevice
import com.google.samples.apps.nowinandroid.MainActivity
import com.google.samples.apps.nowinandroid.ui.homeworks.homework14.MainScreen
import com.kaspersky.components.composesupport.config.withComposeSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test

class SearchScreenTest: TestCase(Kaspresso.Builder.withComposeSupport()) {

    private lateinit var uiDevice: UiDevice

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()    // запускаем Активити
    val searchScreen = SearchScreen(composeTestRule)
    val mainScreen = MainScreen(composeTestRule)

    @Test
    fun checkBackButton() {
        run() {
            mainScreen.search.performClick()
            searchScreen {
                step("Back button is displayed") {
                    backButton.assertIsDisplayed()
                }
                step("Input field is display") {
                    textField.assertIsDisplayed()
                }
            }
        }
    }

}