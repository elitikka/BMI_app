package fi.oamk.bmi.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BmiViewModel: ViewModel() {
    var heightInput by mutableStateOf("")
    var weightInput by mutableStateOf("")

    private val height: Float
        get () {
            return heightInput.toFloatOrNull() ?: 0.0f
        }
    private val weight: Float
        get () {
            return weightInput.toFloatOrNull() ?: 0.0f
        }

    val bmi: Float
        get () {
            return if (height>0 && weight>0) {
                val heightInMeters = height/100
                weight / (heightInMeters * heightInMeters)
            } else {
                0.0f
            }
        }
}