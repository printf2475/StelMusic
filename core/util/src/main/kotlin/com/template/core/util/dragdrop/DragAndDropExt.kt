package com.template.core.util.dragdrop

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.zIndex

inline fun <T> LazyListScope.draggableItems(
    state: DraggableListState,
    items: List<T>,
    noinline key: ((item: T) -> Any)? = null,
    crossinline contentType: (item: T) -> Any? = { _ -> null },
    crossinline itemContent: @Composable LazyItemScope.(item: T, isDragging: Boolean) -> Unit
) = draggableItemsIndexed(
    state = state,
    items = items,
    key = key?.let { block -> { _, item -> block(item) } },
    contentType = { _, item -> contentType(item) },
    itemContent = { _, item, isDragging -> itemContent(item, isDragging) }
)


fun Modifier.dragHandle(
    state: DraggableListState,
    key: Any,
    onlyAfterLongPress: Boolean = false
): Modifier = composed {
    this.pointerInput(state) {
        if (onlyAfterLongPress) {
            detectDragGesturesAfterLongPress(
                onDrag = { change, offset ->
                    change.consume()
                    state.onDrag(offset = offset)
                },
                onDragStart = { state.onDragStart(key = key) },
                onDragEnd = { state.onDragInterrupted() },
                onDragCancel = { state.onDragInterrupted() }
            )
        } else {
            detectDragGestures(
                onDrag = { change, offset ->
                    change.consume()
                    state.onDrag(offset = offset)
                },
                onDragStart = { state.onDragStart(key = key) },
                onDragEnd = { state.onDragInterrupted() },
                onDragCancel = { state.onDragInterrupted() }
            )
        }
    }
}

fun Modifier.dragHandle(
    state: DraggableListState,
    index: Int,
    onlyAfterLongPress: Boolean = false
): Modifier = composed {
    this.pointerInput(state) {
        if (onlyAfterLongPress) {
            detectDragGesturesAfterLongPress(
                onDrag = { change, offset ->
                    change.consume()
                    state.onDrag(offset = offset)
                },
                onDragStart = { state.onDragStart(index = index) },
                onDragEnd = { state.onDragInterrupted() },
                onDragCancel = { state.onDragInterrupted() }
            )
        } else {
            detectDragGestures(
                onDrag = { change, offset ->
                    change.consume()
                    state.onDrag(offset = offset)
                },
                onDragStart = { state.onDragStart(index = index) },
                onDragEnd = { state.onDragInterrupted() },
                onDragCancel = { state.onDragInterrupted() }
            )
        }
    }
}


inline fun <T> LazyListScope.draggableItemsIndexed(
    state: DraggableListState,
    items: List<T>,
    noinline key: ((index: Int, item: T) -> Any)? = null,
    crossinline contentType: (index: Int, item: T) -> Any? = { _, _ -> null },
    crossinline itemContent: @Composable LazyItemScope.(index: Int, item: T, isDragging: Boolean) -> Unit
) = itemsIndexed(
    items = items,
    key = key,
    contentType = contentType
) { index, item ->
    val isDragging = index == state.draggingItemIndex
    val draggingModifier = if (isDragging) {
        Modifier
            .zIndex(1f)
            .graphicsLayer { translationY = state.draggingItemOffset }
    } else if (index == state.previousIndexOfDraggedItem) {
        Modifier
            .zIndex(1f)
            .graphicsLayer { translationY = state.previousItemOffset.value }
    } else {
        Modifier.animateItem(fadeInSpec = null, fadeOutSpec = null)
    }
    Box(modifier = draggingModifier) {
        itemContent(index, item, isDragging)
    }
}
