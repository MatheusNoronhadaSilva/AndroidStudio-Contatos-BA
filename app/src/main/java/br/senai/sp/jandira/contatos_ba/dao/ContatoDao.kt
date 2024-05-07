package br.senai.sp.jandira.contatos_ba.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.senai.sp.jandira.contatos_ba.model.Contato

//Estou dizendo que esta interface é propriedde do ROOM
//Fazendo ele executa-la
@Dao
interface ContatoDao {

    //uma funçao que recebe as informaçoes de Contato como contato
    //E retorna um Long ( que seria o Id criado)

    @Insert
    fun salvar(contato: Contato): Long


    @Query("SELECT * FROM tbl_contatos ORDER BY nome ASC")
    fun listarTodosOsContatos(): List<Contato>

    @Query("SELECT * FROM tbl_contatos WHERE id = :id")
    fun buscarContatoPeloId(id: Long): Contato

    @Delete
    fun deletarContatoPeloId(id: Long)
}