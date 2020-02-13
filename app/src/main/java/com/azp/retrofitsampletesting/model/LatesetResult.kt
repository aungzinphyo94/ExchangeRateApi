package com.azp.retrofitsampletesting.model

import com.google.gson.annotations.SerializedName

data class LatesetResult(

	@field:SerializedName("rates")
	val rates: Rates? = null,

	@field:SerializedName("description")
	val description: String? = null,

	@field:SerializedName("info")
	val info: String? = null,

	@field:SerializedName("timestamp")
	val timestamp: String? = null
)