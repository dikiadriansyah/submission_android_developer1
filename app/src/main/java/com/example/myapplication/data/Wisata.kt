package com.example.myapplication.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Wisata(
    var nama: String ="",
    var poto: String="",
    var deskripsi: String= "",
    var kecamatan: String="",
    var tahun: String=""
):Parcelable
