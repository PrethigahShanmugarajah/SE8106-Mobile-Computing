package com.example.activity06

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.foundation.background
import com.example.activity06.ui.theme.*
import androidx.compose.foundation.clickable
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Activity06Theme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "login") {

                    composable("login") {
                        LoginScreen(
                            onLogin = {
                                navController.navigate("home") {
                                    popUpTo("login") { inclusive = true }
                                }

                            },
                            onRegisterClick = {
                                navController.navigate("register") {}

                            }
                        )
                    }
                    composable("register") {
                        RegisterScreen(
                            onComplete = { navController.navigate("login") },
                            onLoginClick = { navController.navigate("login") }
                        )
                    }
                    composable("home") {
                        HomeScreen()
                    }

                }
            }
        }
    }
}

@Composable
fun LoginScreen(
    onLogin: () -> Unit,
    onRegisterClick: () -> Unit
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Login",
            color = TextColor,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = InputFieldColor,
                unfocusedContainerColor = InputFieldColor
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = InputFieldColor,
                unfocusedContainerColor = InputFieldColor
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onLogin,
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryColor)
        ) {
            Text("Login")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Don't have an account? ")
            Text(
                text = "Register",
                color = PrimaryColor,
                modifier = Modifier.clickable(onClick = onRegisterClick)
            )
        }
    }
}


@Composable
fun RegisterScreen(onComplete: () -> Unit, onLoginClick: () -> Unit){
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Register",
            color = TextColor,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = InputFieldColor,
                unfocusedContainerColor = InputFieldColor
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = InputFieldColor,
                unfocusedContainerColor = InputFieldColor
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = onComplete,
            colors = ButtonDefaults.buttonColors(containerColor = PrimaryColor)
        ){
            Text("Register")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("Already have an account? ")
            Text(
                text = "Login",
                color = PrimaryColor,
                modifier = Modifier.clickable(onClick = onLoginClick)
            )
        }
    }

}

@Composable
fun HomeScreen(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text("Logged In")
    }
}
