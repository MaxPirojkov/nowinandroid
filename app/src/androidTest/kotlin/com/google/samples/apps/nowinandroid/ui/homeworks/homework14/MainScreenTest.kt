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

package com.google.samples.apps.nowinandroid.ui.homeworks.homework14

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performScrollToIndex
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import com.google.samples.apps.nowinandroid.MainActivity
import com.kaspersky.components.composesupport.config.withComposeSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test

class MainScreenTest : TestCase(Kaspresso.Builder.withComposeSupport()) {
    private lateinit var uiDevice: UiDevice

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()    // запускаем Активити
    val mainScreen = MainScreen(composeTestRule)
    val screenLazyList = LazyListScreen(composeTestRule)

    @Test
    fun checkTopBar() = run {
        before {
            uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        }
        mainScreen {
            step("Icon search is displayed") {
                search.assertIsDisplayed()
            }
            step("Check icon setting") {
                setting.assertIsDisplayed()
            }
            step("Check text in topBar") {
                topBarTitle.assertTextEquals("Now in Android")
            }
        }
    }

    @Test
    fun checkText() {
        run() {
            mainScreen {
                step("Check text in title on MainScreen") {
                    title.assertTextEquals("What are you interested in?")
                }
                step("Check text in subtitle on MainScreen") {
                    subTittle.assertTextEquals("Updates from topics you follow will appear here. Follow some things to get started.")
                }
            }
        }
    }

    @Test
    fun checkButtonDone() {
        run() {
            mainScreen {
                step("Check text Done in button") {
                    doneButton.assertTextEquals("Done")
                }
            }
        }
    }

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun clickTopicTheme() {
        run() {
            mainScreen {
                step("Check text Done in button") {
                    doneButton.assertTextEquals("Done")
                }
            }
            step("click on theme") {
                screenLazyList.list.childAt<LazyListItemNode>(2) {
                    button.performClick()
                }

                Thread.sleep(10000)
            }

        }
    }
}

