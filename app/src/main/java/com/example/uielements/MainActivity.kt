@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.uielements

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.uielements.ui.theme.UiElementsTheme
import androidx.compose.material3.Icon as Icon1

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UiElementsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Column {
                        ButtonSection()
                        UserInputSection()
                        SwitchMinimalExample()
                     ExampleButton(onClick = { Log.d("FAB", "FAB clicked.") })
                    }
                }
            }
        }
    }

    @Composable
    fun ButtonSection() {
        val scrollState = rememberScrollState()
        Column {

            Text("Buttons in Jetpack Compose")
            Row(
                modifier = Modifier
                    .horizontalScroll(scrollState)
                    .padding(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Button(onClick = {}) {
                    Text("Basic Button")
                }
                FilledTonalButton(onClick = {}) {
                    Text("Tonal Button")
                }
                OutlinedButton(onClick = { }) {
                    Text(text = "Outlined Button")
                }
                ElevatedButton(onClick = { }) {
                    Text(text = "Elevated Button")
                }
                IconButton(onClick = {}) {
                    Icon1(
                        imageVector = Icons.Outlined.FavoriteBorder,
                        contentDescription = null
                    )
                }
                Button(onClick = { }) {
                    Icon1(
                        imageVector = Icons.Filled.Call,
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "Basic Button With Icon")

                }


            }
        }

    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun UserInputSection() {
        Column {
            Text(
                text = "User Input in Jetpack Compose",
                modifier = Modifier.padding(top = 16.dp, start = 16.dp)
            )
            val scrollState = rememberScrollState()
            var text by remember { mutableStateOf("Hello") }
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .verticalScroll((scrollState)),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                TextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Label") }
                )
                OutlinedTextField(
                    value = text,
                    onValueChange = { text = it },
                    label = {
                        Text("Outlined Label")
                    },
                    leadingIcon = {
                        Icon1(
                            painter = painterResource(id = R.drawable.fitness_cycle),
                            contentDescription = null,
                            modifier = Modifier
                                .size(30.dp)
                                .offset(x = 4.dp)
                        )
                    }, shape = CircleShape
                )
            }
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Enter text") },
                maxLines = 2,
                textStyle = TextStyle(
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold
                ),
            )
            val brush = remember {
                Brush.verticalGradient(
                    colors = listOf(
                        Color.Red,
                        Color.White
                    )
                )
            }
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Enter") },
                textStyle = TextStyle(brush = brush),
                leadingIcon = {
                    Icon1(
                        Icons.Default.AccountCircle,
                        contentDescription = null
                    )
                },
                trailingIcon = {
                    IconButton(onClick = { }) {
                        Icon1(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = null
                        )

                    }
                },
                supportingText = {
                    Text("marr khaoge galat bhara toh")
                },
                isError = true,
                shape = RoundedCornerShape(
                    topEnd = 16.dp,
                    topStart = 16.dp
                ),
            )

        }
    }

    @Composable
    fun SwitchMinimalExample() {


            val scrollState = rememberScrollState()
            Text(text = "Switch Buttons",
            modifier = Modifier.padding(6.dp) )
            var checked by remember { mutableStateOf(true) }

            Row (
                modifier = Modifier
                    .padding(16.dp)
                    .horizontalScroll((scrollState)),
               horizontalArrangement = Arrangement.spacedBy(16.dp)
            ){
                Switch(checked = checked, onCheckedChange = { checked = it })



                Switch(
                    checked = checked,
                    onCheckedChange = {
                        checked = it
                    },
                    thumbContent = if (checked) {
                        {
                            Icon1(
                                imageVector = Icons.Filled.Add,
                                contentDescription = null,
                                modifier = Modifier.size(SwitchDefaults.IconSize),
                            )
                        }
                    } else {
                        null
                    }
                )
                var check by remember { mutableStateOf(true) }

                Switch(
                    checked = check,
                    onCheckedChange = {
                        check = it
                    },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = MaterialTheme.colorScheme.primary,
                        checkedTrackColor = MaterialTheme.colorScheme.primaryContainer,
                        uncheckedThumbColor = MaterialTheme.colorScheme.secondary,
                        uncheckedTrackColor = MaterialTheme.colorScheme.background,
                    )
                )
            }

        }
    @Composable
    fun ExampleButton(onClick: () -> Unit) {
        Text(
            text = "Floating Action Button",
            modifier = Modifier.padding(3.dp, 4.dp, 4.dp, 16.dp)
        )
        Row(
            modifier = Modifier.
            padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)

        ) {
            FloatingActionButton(
                onClick = { onClick() },
            ) {
                Icon1(
                    Icons.Filled.Add,
                    "Floating action button."
                )
            }
            ExtendedFloatingActionButton(
                onClick = { onClick() },
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onBackground,
                icon = { Icon1(Icons.Filled.Edit,
                    "Extended floating action button.") },
                text = { Text(text = "Compose") },
            )
            LargeFloatingActionButton(
                onClick = { onClick() },
                shape = CircleShape,
            ) {
                Icon1(Icons.Filled.Add,
                    "Large floating action button")
            }
            SmallFloatingActionButton(
                onClick = { onClick() },
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onBackground
            ) {
                Icon1(Icons.Filled.MoreVert, "Small floating action button.")
            }

        }
    }

}





