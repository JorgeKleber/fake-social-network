package com.example.core.models

import com.google.gson.annotations.SerializedName


data class Root (

  @SerializedName("results" ) var results : ArrayList<Results> = arrayListOf(),
  @SerializedName("info"    ) var info    : Info?              = Info()

)