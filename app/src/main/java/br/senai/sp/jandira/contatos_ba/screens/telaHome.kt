package br.senai.sp.jandira.contatos_ba.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import br.senai.sp.jandira.contatos_ba.repository.ContatoRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TelaHome(controleDeNavegacao: NavHostController?) {

    val cr = ContatoRepository(LocalContext.current)
    val contatos = cr.buscarTodosOsContatos()

    val idContato = remember {
        mutableListOf("")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                colors = topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text("Meus contatos")
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { controleDeNavegacao?.navigate("cadastro") }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            LazyColumn{
                items(contatos){
                    Card (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp)
                            .padding(horizontal = 16.dp, vertical = 4.dp)
                    ){
                        Column (
                            verticalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxSize()
                        ){
                            Row (
                                modifier = Modifier
                                    .padding(16.dp)
                                    .fillMaxWidth()
                                    .background(Color.Red)
                            ){
                                Card (
                                    modifier= Modifier.size(
                                        width = 50.dp, height = 50.dp
                                    ),
                                    shape = CircleShape,
                                    colors = CardDefaults.cardColors(containerColor = Color.Magenta)
                                ){
                                    Box (
                                        modifier = Modifier.fillMaxSize(),
                                        contentAlignment = Alignment.Center
                                    ){
                                        Text(
                                            text = it.nome.substring(0..0),
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 24.sp,
                                            color = Color.White
                                        )
                                    }
                                }
                                Spacer(modifier = Modifier.width(32.dp))
                                Column {
                                    Text(
                                        text = it.nome,
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.Bold)
                                    Text(
                                        text = it.email,
                                        fontSize = 18.sp
                                    )
                                }
                            }
                            Box (
                                contentAlignment = Alignment.CenterEnd,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(Color.Gray)
                                    .padding(5.dp)
                            ){
                                Icon(
                                    imageVector = Icons.Default.Delete,
                                    contentDescription = ""
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun TelaHomePreview(){
        TelaHome(controleDeNavegacao = null)
}