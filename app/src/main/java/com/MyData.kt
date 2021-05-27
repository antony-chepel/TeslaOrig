package com

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MyData {
    @SerializedName("proceedWith")
    @Expose
    var pr: String = ""
    @SerializedName("redirectUrl")
    @Expose
    var redirect: String = ""
}