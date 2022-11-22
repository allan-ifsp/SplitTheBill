package br.edu.ifsp.ads.pdm.splitthebill.model.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Integrante (
    @PrimaryKey(autoGenerate = true)
    var id: Int?,
    @NonNull
    var nome: String,
    @NonNull
    var valorPago: String,
    @NonNull
    var compras: String,
): Parcelable