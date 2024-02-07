package com.example.loteryapp.viewModels

import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoteryViewModel: ViewModel() {

    var _loteryNumbers by mutableStateOf(emptyList<Int>())
        private set


    fun generateNumbers(){
        _loteryNumbers = (1..60).shuffled().take(6).sorted()
    }

}