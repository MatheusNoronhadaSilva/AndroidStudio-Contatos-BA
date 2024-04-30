package br.senai.sp.jandira.contatos_ba.dao

import androidx.room.Dao
import androidx.room.Insert
import br.senai.sp.jandira.contatos_ba.model.Contato

//Estou dizendo que esta interface é propriedde do ROOM
//Fazendo ele executa-la
@Dao
interface ContatoDao {

    //uma funçao que recebe as informaçoes de Contato como contato
    //E retorna um Long ( que seria o Id criado)

    @Insert
    fun salvar(contato: Contato): Long
}