package com.example.bmi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bmi.ui.theme.BmiTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.material3.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bmi.viewmodels.BmiViewModel
import java.text.DecimalFormat
import androidx.compose.foundation.layout.Arrangement




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Bmi(

                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Bmi ( modifier: Modifier = Modifier,
bmiViewModel: BmiViewModel = viewModel()
){


    Column{
        Text(
                    text = stringResource(R.string.body_mass_index),
                     fontSize = 24.sp,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 16.dp)
                )

                OutlinedTextField(
                    value = bmiViewModel.heightInput,
                    onValueChange = { bmiViewModel.heightInput = it.replace(',', '.') },
                    label = { Text(stringResource(R.string.height)) },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp)
                )

                OutlinedTextField(
                    value = bmiViewModel.weightInput,
                    onValueChange = { bmiViewModel.weightInput = it.replace(',', '.') },
                    label = { Text(stringResource(R.string.weight)) },
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    modifier = Modifier.fillMaxWidth(). padding(start = 8.dp, end = 8.dp)
                )

                Text(
                    text = stringResource(R.string.body_mass_index_is)+ " " + (bmiViewModel.bmi),
                    modifier = Modifier.fillMaxWidth(). padding(start = 16.dp, top = 16.dp)
                )
            }
        }









@Preview(showBackground = true)
@Composable
fun BmiPreview() {
    BmiTheme {
        Bmi()
    }
}