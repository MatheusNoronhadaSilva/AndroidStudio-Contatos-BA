package br.senai.sp.jandira.contatos_ba.repository

import android.content.Context
import br.senai.sp.jandira.contatos_ba.dao.ContatoDb
import br.senai.sp.jandira.contatos_ba.model.Contato

class ContatoRepository(context: Context) {

    private val db = ContatoDb.getBancoDeDados(context).contatoDao()

    fun salvar(contato: Contato): Long{
        return  db.salvar(contato)
    }

    fun deletarContatoPeloId(id: Long){
        return db.deletarContatoPeloId(id)
    }

    fun buscarTodosOsContatos(): List<Contato>{
        return db.listarTodosOsContatos()
    }

    fun buscarContatoPeloId(id: Long): Contato {
        return db.buscarContatoPeloId(id)
    }
}