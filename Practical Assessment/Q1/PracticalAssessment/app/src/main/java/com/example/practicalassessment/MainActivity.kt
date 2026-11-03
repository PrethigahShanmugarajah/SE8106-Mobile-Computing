package com.example.practicalassessment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.practicalassessment.ui.Navigation
import com.example.practicalassessment.ui.theme.PracticalAssessmentTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            PracticalAssessmentTheme {
                Navigation()
            }
        }
    }
}