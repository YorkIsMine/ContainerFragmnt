package com.yorkismine.containerfragmnt

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Tag(
    val text: String,
    val state: String
) : Parcelable