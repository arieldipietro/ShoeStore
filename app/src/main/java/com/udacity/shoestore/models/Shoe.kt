package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(var name: String, var size: String, var company: String, var description: String,
                //I changed the image value to a var String, so I can ask the user for a URL and retrieve it in the ShoeListFragment
                var images: String
) : Parcelable