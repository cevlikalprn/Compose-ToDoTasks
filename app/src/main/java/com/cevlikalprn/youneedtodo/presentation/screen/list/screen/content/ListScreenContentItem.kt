package com.cevlikalprn.youneedtodo.presentation.screen.list.screen.content

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.cevlikalprn.youneedtodo.common.NavigateToTaskScreen
import com.cevlikalprn.youneedtodo.common.SimpleComposableContent
import com.cevlikalprn.youneedtodo.common.SimpleOnClick
import com.cevlikalprn.youneedtodo.domain.model.Priority
import com.cevlikalprn.youneedtodo.domain.model.ToDoTask
import com.cevlikalprn.youneedtodo.presentation.theme.LARGE_PADDING
import com.cevlikalprn.youneedtodo.presentation.theme.TASK_ITEM_ELEVATION
import com.cevlikalprn.youneedtodo.presentation.theme.taskItemBackgroundColor
import com.cevlikalprn.youneedtodo.presentation.theme.taskItemTextColor
import com.cevlikalprn.youneedtodo.presentation.uipack.component.priorityItem.AppPriorityItemShape

@Composable
fun ListScreenContentItem(
    toDoTask: ToDoTask,
    navigateToTaskScreen: NavigateToTaskScreen
) {
    ItemSurface(
        onClick = {
            navigateToTaskScreen(toDoTask.id)
        },
        content = {
            ItemContent(
                title = toDoTask.title,
                description = toDoTask.description,
                priorityColor = toDoTask.priority.color
            )
        }
    )
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun ItemSurface(
    onClick: SimpleOnClick,
    content: SimpleComposableContent
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colors.taskItemBackgroundColor,
        shape = RectangleShape,
        elevation = TASK_ITEM_ELEVATION,
        onClick = onClick,
        content = content
    )
}

@Composable
private fun ItemContent(
    title: String,
    description: String,
    priorityColor: Color
) {
    Column(
        modifier = Modifier
            .padding(LARGE_PADDING)
            .fillMaxWidth()
    ) {
        ItemContentHeadline(
            title = title,
            priorityColor = priorityColor
        )
        ItemContentDescription(description = description)
    }
}

@Composable
private fun ItemContentHeadline(
    title: String,
    priorityColor: Color
) {
    Row {
        Text(
            modifier = Modifier.weight(8f),
            text = title,
            color = MaterialTheme.colors.taskItemTextColor,
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            maxLines = 1
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentAlignment = Alignment.TopEnd
        ) {
            AppPriorityItemShape(
                color = priorityColor
            )
        }
    }
}

@Composable
private fun ItemContentDescription(
    description: String
) {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = description,
        color = MaterialTheme.colors.taskItemTextColor,
        style = MaterialTheme.typography.subtitle1,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis
    )
}

@Composable
@Preview
fun ListScreenContentItemPreview() {
    ListScreenContentItem(
        toDoTask = ToDoTask(
            id = 0,
            title = "Title",
            description = "Description",
            priority = Priority.HIGH
        ),
        navigateToTaskScreen = {
            // do nothing
        }
    )
}