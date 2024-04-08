package com.zack.instargm

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zack.instargm.ui.theme.InstargmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InstargmTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   Column {
                       HelloWorld(name = "Perpetual")
                       Spacer(modifier = Modifier.height(10.dp))
                       Button(
                           onClick = {
                               val intent = Intent(this@MainActivity,LoginActivity1::class.java)
                               startActivity(intent)
                           },
                           modifier = Modifier
                               .fillMaxWidth()
                               .padding(10.dp),
                           colors = ButtonDefaults.buttonColors(Color.Green)
                       ) {
                           Text(text = "Login Here ")
                       }
                       Spacer(modifier = Modifier.height(10.dp))
                       Button(
                           onClick = {},
                           modifier = Modifier
                               .fillMaxWidth()
                               .padding(12.dp),
                           colors = ButtonDefaults.buttonColors(Color.Red)
                       ) {
                           Text(text = "Register Here ")
                       }
                       Spacer(modifier = Modifier.height(20.dp))
                       Button(
                           onClick = {
                                     val intent = Intent(this@MainActivity,BackgroundActivity::class.java)
                                     startActivity(intent)
                           },
                           modifier = Modifier
                               .fillMaxWidth()
                               .padding(12.dp),
                           colors = ButtonDefaults.buttonColors(Color.Red)
                       ) {
                           Text(text = "Background Image")
                       }
                   }
                }
            }
        }
    }
}


@Composable
fun HelloWorld(name: String){
    Column {
        Text(
            text = "Hey $name! This is my first Android Project",
            fontSize = 23.sp,
            color = Color.White,
            fontFamily = FontFamily.SansSerif,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.Black)
                .padding(20.dp)
                .wrapContentHeight(align = Alignment.Top)
        )

        Spacer(modifier = Modifier.height(20.dp))
        TextFieldComponent()
        Spacer(modifier = Modifier.height(20.dp))
        TextFieldEmailComponent()
        Spacer(modifier = Modifier.height(20.dp))
        TextFieldLocationComponent()
        Spacer(modifier = Modifier.height(20.dp))
        TextFieldPasswordComponent()

        Spacer(modifier = Modifier.height(20.dp))



    }
TextAlignPasswordTextField()
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun HelloWorldPreview(){
    HelloWorld(name = "Perpetual")
}
@Composable
fun TextFieldComponent(){
    var text by remember {
        mutableStateOf(value = "")
    }
    TextField(modifier = Modifier.fillMaxWidth(),
        value = text , onValueChange = {newText -> text = newText
        },
        label = {Text(text = "Enter your name")},
        placeholder = {
            Text(text = "PLease enter your name")
        }
    )
}


@Composable
fun TextFieldEmailComponent(){
    var text by remember {
        mutableStateOf(value = "")
    }
    TextField(modifier = Modifier.fillMaxWidth(),
        value = text , onValueChange = {newText -> text = newText},
        label = {Text(text = "Enter your Email")},
        placeholder = {
            Text(text = "PLease enter your Email")
        }
    )
}

@Composable
fun TextFieldLocationComponent(){
    var text by remember {
        mutableStateOf(value = "")
    }
    TextField(modifier = Modifier.fillMaxWidth(),
        value = text , onValueChange = {newText -> text = newText
        },
        label = {Text(text = "Enter your Location")},
        placeholder = {
            Text(text = "PLease enter your Location")
        }
    )
}

@Composable
fun TextFieldPasswordComponent(){
    var text by remember {
        mutableStateOf(value = "")
    }
    TextField(modifier = Modifier.fillMaxWidth(),
        value = text , onValueChange = {newText -> text = newText
        },
        label = {Text(text = "Enter your Password")},
        placeholder = {
            Text(text = "PLease enter your Password")
        }
    )
}

@Composable
fun TextAlignPasswordTextField() {

    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    val icon = if (passwordVisibility)
        painterResource(id = R.drawable.design_ic_visibility)
    else
        painterResource(id = R.drawable.design_ic_visibility_off)

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = password,
        onValueChange = {
            password = it
        },
        placeholder = { Text(text = "Password") },
        label = { Text(text = "Password") },
        trailingIcon = {
            IconButton(onClick = {
                passwordVisibility = !passwordVisibility
            }) {
                Icon(
                    painter = icon,
                    contentDescription = "Visibility Icon"
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = if (passwordVisibility) VisualTransformation.None
        else PasswordVisualTransformation()
    )
}