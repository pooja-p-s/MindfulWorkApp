package com.poojaps.mindfulwork.ui.screens

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.poojaps.mindfulwork.Routes
import com.poojaps.mindfulwork.data.repository.FirebaseAuthRepository
import com.poojaps.mindfulwork.ui.auth.AuthState
import com.poojaps.mindfulwork.ui.auth.AuthViewModel

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val repo = remember {
        FirebaseAuthRepository(FirebaseAuth.getInstance(), FirebaseFirestore.getInstance())
    }
    val viewModel = remember { AuthViewModel(repo) }
    val state by viewModel.state.collectAsState()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo
            Icon(
                imageVector = Icons.Default.Lock,
                contentDescription = "App Logo",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .size(72.dp)
                    .padding(bottom = 16.dp)
            )

            Text(
                text = "Mindful Work",
                fontSize = 28.sp,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(Modifier.height(8.dp))

            Text(
                text = "Stay focused • Stay balanced",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(Modifier.height(32.dp))

            // Card container
            Surface(
                shape = RoundedCornerShape(20.dp),
                tonalElevation = 4.dp,
                color = MaterialTheme.colorScheme.surfaceVariant,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(Modifier.height(16.dp))

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text("Password") },
                        singleLine = true,
                        visualTransformation = PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(Modifier.height(24.dp))

                    Crossfade(targetState = state) { currentState ->
                        when (currentState) {
                            is AuthState.Loading -> {
                                CircularProgressIndicator(
                                    modifier = Modifier.size(36.dp),
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                            is AuthState.Error -> {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Text(
                                        text = "Error: ${currentState.message}",
                                        color = MaterialTheme.colorScheme.error
                                    )
                                    Spacer(Modifier.height(8.dp))
                                    Button(
                                        onClick = { viewModel.login(email, password) },
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(52.dp),
                                        shape = RoundedCornerShape(12.dp)
                                    ) {
                                        Text("Retry")
                                    }
                                }
                            }
                            is AuthState.Success -> {
                                // Navigate on successful login
                                LaunchedEffect(Unit) {
                                    navController.navigate(Routes.HOME) {
                                        popUpTo(Routes.LOGIN) { inclusive = true }
                                    }
                                }
                            }
                            else -> {
                                Button(
                                    onClick = { viewModel.login(email, password) },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(52.dp),
                                    shape = RoundedCornerShape(12.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = MaterialTheme.colorScheme.primary
                                    )
                                ) {
                                    Text("Sign In")
                                }
                            }
                        }
                    }

                    Spacer(Modifier.height(12.dp))

                    TextButton(onClick = { /* forgot password flow */ }) {
                        Text("Forgot password?")
                    }
                }
            }

            Spacer(Modifier.height(28.dp))

            FilledTonalButton(
                onClick = {
                    navController.navigate(Routes.SIGNUP)
                },
                modifier = Modifier.fillMaxWidth(0.6f)
            ) {
                Text("Create Account")
            }
        }
    }
}
