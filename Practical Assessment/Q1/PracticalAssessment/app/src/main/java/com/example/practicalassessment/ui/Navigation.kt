package com.example.practicalassessment.ui

import android.widget.Toast
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practicalassessment.data.AppDatabase
import com.example.practicalassessment.repository.UserRepository
import com.example.practicalassessment.ui.screens.HomeScreen
import com.example.practicalassessment.ui.screens.LoginScreen
import com.example.practicalassessment.ui.screens.RegisterScreen
import com.example.practicalassessment.viewmodel.AuthViewModel

@Composable
fun Navigation() {

    val context = LocalContext.current
    val navController = rememberNavController()

    val database = remember {
        AppDatabase.getDatabase(context)
    }

    val repository = remember {
        UserRepository(database.userDao())
    }

    val factory = remember {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(
                modelClass: Class<T>
            ): T {
                if (modelClass.isAssignableFrom(AuthViewModel::class.java)) {
                    @Suppress("UNCHECKED_CAST")
                    return AuthViewModel(repository) as T
                }
                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }
    }

    val authViewModel: AuthViewModel = viewModel(factory = factory)

    var loggedInUsername by remember {
        mutableStateOf("")
    }

    NavHost(
        navController = navController,
        startDestination = "register"
    ) {

        composable("register") {
            RegisterScreen(
                onRegister = { username, email, password ->
                    authViewModel.register(username, email, password) { success ->
                        if (success) {
                            Toast.makeText(
                                context,
                                "Registration successful",
                                Toast.LENGTH_SHORT
                            ).show()

                            navController.navigate("login")
                        } else {
                            Toast.makeText(
                                context,
                                "Registration failed",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                },
                onNavigateToLogin = {
                    navController.navigate("login")
                }
            )
        }

        composable("login") {
            LoginScreen(
                onLogin = { username, password ->
                    authViewModel.login(username, password) { success ->
                        if (success) {
                            loggedInUsername = username
                            navController.navigate("home")
                        } else {
                            Toast.makeText(
                                context,
                                "Invalid username or password",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                },
                onNavigateToRegister = {
                    navController.navigate("register")
                }
            )
        }

        composable("home") {
            HomeScreen(
                username = loggedInUsername,
                onLogout = {
                    loggedInUsername = ""
                    navController.navigate("login") {
                        popUpTo("home") {
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}