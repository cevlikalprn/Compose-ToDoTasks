package com.cevlikalprn.youneedtodo.presentation.model

enum class Action {
    ADD,
    UPDATE,
    DELETE,
    DELETE_ALL,
    UNDO,
    NO_ACTION;

    companion object {
        fun String?.getActionFromString(): Action {
            return try {
                if (this.isNullOrEmpty()) {
                    NO_ACTION
                } else {
                    Action.valueOf(this)
                }
            } catch (e: Exception) {
                NO_ACTION
            }
        }
    }
}