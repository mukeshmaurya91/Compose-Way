package com.maurya91.composeway.ui

import androidx.compose.Composable
import androidx.compose.Model
import androidx.ui.foundation.selection.ToggleableState
import androidx.ui.graphics.Color
import androidx.ui.material.Checkbox
import androidx.ui.material.TriStateCheckbox

@Composable
fun CheckboxComponent() {
    Checkbox(
        checked = true,
        onCheckedChange = {}
    )
}

@Composable
fun TriStateCheckboxComponent(formState: TriStateFormState) {
    TriStateCheckbox(
        state = formState.optionChecked,
        onClick = {
            when (formState.optionChecked) {
                ToggleableState.Off -> formState.optionChecked = ToggleableState.Indeterminate
                ToggleableState.On -> formState.optionChecked = ToggleableState.Off
                ToggleableState.Indeterminate -> formState.optionChecked = ToggleableState.On
            }
        }
    )
}

@Model
class TriStateFormState(var optionChecked: ToggleableState = ToggleableState.Indeterminate)