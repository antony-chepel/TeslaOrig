package com

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class InfoClass {
    @SerializedName("status")
    @Expose
    var status: String = ""
    @SerializedName("data")
    @Expose
    var data: MyData? = null
}