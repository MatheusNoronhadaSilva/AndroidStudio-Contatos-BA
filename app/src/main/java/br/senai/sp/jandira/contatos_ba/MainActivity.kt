package br.senai.sp.jandira.contatos_ba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.contatos_ba.ui.theme.ContatosBATheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContatosBATheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    FormularioCadastro()
                }
            }
        }
    }
}

@Composable
fun FormularioCadastro() {

    var nomeState = remember {
        mutableStateOf("")
    }

    var foneState = remember {
        mutableStateOf("")
    }

    var emailState = remember {
        mutableStateOf("")
    }

    var dataNascimentoState = remember {
        mutableStateOf("")
    }

    var familiaState = remember {
        mutableStateOf(false)
    }

    Column {
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
        ){
            Text(
                text = stringResource(id = R.string.title),
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Magenta
            )
            OutlinedTextField(
                value = nomeState.value,
                onValueChange = { nomeState.value = it},
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = stringResource(id = R.string.contact_name))
                }
            )
            OutlinedTextField(
                value = foneState.value,
                onValueChange = { foneState.value = it},
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = stringResource(id = R.string.contact_phone))
                }
            )
            OutlinedTextField(
                value = emailState.value,
                onValueChange = { emailState.value = it},
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = stringResource(id = R.string.contact_email))
                }
            )
            OutlinedTextField(
                value = dataNascimentoState.value,
                onValueChange = { dataNascimentoState.value = it},
                modifier = Modifier.fillMaxWidth(),
                label = {
                    Text(text = stringResource(id = R.string.contact_birthday))
                }
            )
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Checkbox(
                    checked = familiaState.value,
                    onCheckedChange = { familiaState.value = it },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color(0xffcf08ef),
                        uncheckedColor = Color(0xffcf08ef)
                    )
                )
                Text(text = stringResource(id = R.string.family))
            }
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(id = R.string.save))
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    ContatosBATheme {
        FormularioCadastro()
    }
}