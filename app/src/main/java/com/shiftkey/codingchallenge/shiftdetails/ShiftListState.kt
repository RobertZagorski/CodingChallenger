package com.shiftkey.codingchallenge.shiftdetails

sealed class ShiftListState {
    object Loading : ShiftListState()
    object Loaded : ShiftListState()
    object NoResults : ShiftListState()
}
