package br.senai.sp.jandira.contatos_ba.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity(tableName = "tbl_contatos")
data class Contato(

    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var nome: String = "",
    var telefone: String = "",
    var email: String = "",
    @ColumnInfo(name = "data_nascimento") var dataNascimento: String = "",
    @ColumnInfo(name = "is_familia") var isFamilia: Boolean = false
)
