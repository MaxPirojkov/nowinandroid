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

import androidx.compose.ui.semantics.SemanticsNode
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import androidx.compose.ui.test.hasParent
import androidx.compose.ui.test.hasTestTag
import com.google.samples.apps.nowinandroid.core.designsystem.LazyListItemPositionSemantics
import com.google.samples.apps.nowinandroid.core.designsystem.LazyListLengthSemantics
import io.github.kakaocup.compose.node.element.ComposeScreen
import io.github.kakaocup.compose.node.element.KNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListItemNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListNode

class MainScreen(semanticsProvider: SemanticsNodeInteractionsProvider) :
    ComposeScreen<MainScreen>(semanticsProvider) {

    val doneButton = KNode(semanticsProvider) {
        hasText("Done")
        useUnmergedTree = true
    }

    val topBarTitle = child<KNode> {
        hasTestTag("NiaTopAppBarTitle")
    }

    val search = child<KNode> {
        hasTestTag("NiaTopAppBarIconSearch")
        useUnmergedTree = true
    }

    val setting = child<KNode> {
        hasTestTag("NiaTopAppBarIconSetting")
        useUnmergedTree = true
    }

    val title = child<KNode> {
        hasTestTag("title")
        useUnmergedTree = true
    }

    val subTittle = child<KNode> {
        hasTestTag("subTitle")
        useUnmergedTree = true
    }

}

class LazyListScreen(
    semanticsProvider: SemanticsNodeInteractionsProvider,
    val list: KLazyListNode = KLazyListNode(
        semanticsProvider = semanticsProvider,
        viewBuilderAction = { hasTestTag("forYou:topicSelection") },
        itemTypeBuilder = {
            itemType(::LazyListItemNode)
        },
        positionMatcher = { position ->
            SemanticsMatcher.expectValue(
                LazyListItemPositionSemantics,
                position,
            )
        },

        lengthSemanticsPropertyKey = LazyListLengthSemantics,
    )
)


class LazyListItemNode(
    semanticsNode: SemanticsNode,
    semanticsProvider: SemanticsNodeInteractionsProvider,
) : KLazyListItemNode<LazyListItemNode>(semanticsNode, semanticsProvider) {
    val button = child<KNode> { hasTestTag("topicTheme") }
}
