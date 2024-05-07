package br.senai.sp.jandira.contatos_ba.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.contatos_ba.R
import br.senai.sp.jandira.contatos_ba.model.Contato
import br.senai.sp.jandira.contatos_ba.repository.ContatoRepository

@Composable
fun FormularioCadastro(controleDeNavegacao: NavHostController) {

    val cr = ContatoRepository(LocalContext.current)

    val nomeState = remember {
        mutableStateOf("")
    }

    val foneState = remember {
        mutableStateOf("")
    }

    val emailState = remember {
        mutableStateOf("")
    }

    val dataNascimentoState = remember {
        mutableStateOf("")
    }

    val familiaState = remember {
        mutableStateOf(false)
    }

    var nomeError = remember {
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
                },
                isError = nomeError.value,
                trailingIcon = {
                    if(nomeError.value){
                        Icon(
                            imageVector = Icons.Default.Warning,
                            contentDescription = "",
                            tint = Color.Red
                        )
                    }
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
                onClick = {
                    //Criar um objetom contato

                    val contato = Contato(
                        nome = nomeState.value,
                        email = emailState.value,
                        telefone = foneState.value,
                        dataNascimento = dataNascimentoState.value,
                        isFamilia = familiaState.value
                    )



                    if(nomeState.value == ""){
                        nomeError.value == true
                    } else{
                        cr.salvar(contato = contato)
                        controleDeNavegacao.navigate("home")
                    }

                    controleDeNavegacao.navigate("home")

                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(id = R.string.save))
            }
        }
    }
}