package com.cevlikalprn.youneedtodo.presentation.screen.task

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.cevlikalprn.youneedtodo.R
import com.cevlikalprn.youneedtodo.common.PrioritySelectedClick
import com.cevlikalprn.youneedtodo.common.TextFieldValueChange
import com.cevlikalprn.youneedtodo.domain.model.Priority
import com.cevlikalprn.youneedtodo.domain.model.ToDoTask
import com.cevlikalprn.youneedtodo.presentation.theme.LARGE_PADDING
import com.cevlikalprn.youneedtodo.presentation.theme.MEDIUM_PADDING
import com.cevlikalprn.youneedtodo.presentation.uipack.component.priorityDropDown.AppPriorityDropDown
import com.cevlikalprn.youneedtodo.presentation.uipack.textField.AppToDoTaskField

@Composable
fun TaskScreenContent(
    paddingValues: PaddingValues,
    toDoTask: ToDoTask?,
    onTitleChange: TextFieldValueChange,
    onPrioritySelected: PrioritySelectedClick,
    onDescriptionChange: TextFieldValueChange
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background)
            .padding(paddingValues)
            .padding(LARGE_PADDING)
    ) {
        AppToDoTaskField(
            modifier = Modifier.fillMaxWidth(),
            onValueChange = onTitleChange,
            value = toDoTask?.title.orEmpty(),
            labelValue = stringResource(id = R.string.title),
            textStyle = MaterialTheme.typography.body1,
            singleLine = true
        )
        Divider(
            modifier = Modifier.height(MEDIUM_PADDING),
            color = MaterialTheme.colors.background
        )
        AppPriorityDropDown(
            priority = toDoTask?.priority ?: Priority.LOW,
            onPrioritySelected = onPrioritySelected
        )
        AppToDoTaskField(
            modifier = Modifier.fillMaxSize(),
            onValueChange = onDescriptionChange,
            value = toDoTask?.description.orEmpty(),
            labelValue = stringResource(id = R.string.description),
            textStyle = MaterialTheme.typography.body1
        )
    }
}

@Composable
@Preview
private fun TaskContentPreview() {
    TaskScreenContent(
        paddingValues = PaddingValues(),
        toDoTask = ToDoTask.NewToDoTask,
        onTitleChange = {},
        onPrioritySelected = {},
        onDescriptionChange = {}
    )
}