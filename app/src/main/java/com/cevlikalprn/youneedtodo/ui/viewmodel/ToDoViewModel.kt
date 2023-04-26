package com.cevlikalprn.youneedtodo.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.cevlikalprn.youneedtodo.data.repository.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ToDoViewModel @Inject constructor(
    private val toDoRepository: ToDoRepository
) : ViewModel() {


}
