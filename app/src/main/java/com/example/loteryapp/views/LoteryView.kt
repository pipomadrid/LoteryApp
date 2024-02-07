package com.example.loteryapp.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loteryapp.R
import com.example.loteryapp.viewModels.LoteryViewModel


@Composable
fun LoteryView(loteryViewModel: LoteryViewModel) {


    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        if (loteryViewModel._loteryNumbers.isEmpty()) {
            Text(
                text = "Lotery", fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 20.dp)
            )
        } else {

            LoteryCard(loteryViewModel._loteryNumbers)
        }
        Button(
            onClick = { loteryViewModel.generateNumbers() },
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
            ), elevation = ButtonDefaults.buttonElevation(8.dp)
        )
        {
            Text(text = "Generar", fontSize = 20.sp)
        }

    }
}

@Composable
fun LoteryCard(loteryNumbers: List<Int>) {
    LazyRow(contentPadding = PaddingValues(15.dp)) {
        items(loteryNumbers) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(
                        horizontal = 4.dp
                    )
                    .size(48.dp)
                    .background(MaterialTheme.colorScheme.primary, CircleShape)
            ) {
                Text(text = it.toString(), color = MaterialTheme.colorScheme.onPrimary)
            }
        }
    }


}