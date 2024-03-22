package com.example.nafapp

import android.os.Bundle
import android.renderscript.ScriptGroup.Input
import android.widget.EditText
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "first_screen"
            ){
               composable("first_screen"){
                    FirstScreen {
                        navController.navigate("second_screen")
                    }
               }
                composable("second_screen"){
                    SecondScreen {
                        navController.navigate("first_screen")
                    }
                }
            }

        }
    }
}

@Composable
private fun FirstScreen(onClick: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "MyGameStore", fontSize = 38.sp)
        Text(text = "Log in", fontSize = 34.sp, color = Color.White)
        OutlinedTextField(
            modifier = Modifier
                .padding(10.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(Color.White),

            value = "Login", onValueChange = {}
        )
        OutlinedTextField(
            modifier = Modifier
                .padding(10.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(Color.White),
            value = "Password", onValueChange = {}
        )

        Button(
            modifier = Modifier
                .padding(10.dp)
                .width(200.dp)
                .height(60.dp),
            onClick = { onClick() }) {
            Text(text = "GO", fontSize = 32.sp)
        }
    }
}

@Composable
private fun SecondScreen(onClick: () -> Unit){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
    Item()
    }
}
@Composable
private fun Item(){
    Column() {
        Row (){
            Card(
                modifier = Modifier
                    .background(Color.Blue)
                    .fillMaxSize()
            ) {
                Text(text = "The King")
            }

        }
    }
}


