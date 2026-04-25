/*
 * Copyright 2026 The Android Open Source Project
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

package com.google.samples.apps.nowinandroid.ui.homeworks.lesson25

import androidx.compose.ui.test.ExperimentalTestApi
import com.google.samples.apps.nowinandroid.ui.homeworks.homework14.MainScreen
import com.kaspersky.components.composesupport.config.withComposeSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.compose.node.element.ComposeScreen.Companion.onComposeScreen
import kotlin.concurrent.atomics.AtomicReference
import kotlin.concurrent.atomics.ExperimentalAtomicApi
import kotlin.test.Test

class SampleTest: TestCase(Kaspresso.Builder.withComposeSupport()) {
    @OptIn(ExperimentalTestApi::class, ExperimentalAtomicApi::class)
    @Test
    fun checkElementOnScreen() = run {
            onComposeScreen<MainScreen> {
                val settingBtnText = AtomicReference<List<String>>(listOf())
                action {
                    click(setting)
                    extract(setting, settingBtnText) {
                        getText()
                    }
                }
            }
        }
}