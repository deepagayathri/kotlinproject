package com.example.mykotlinproject.ModelClass

import com.google.gson.annotations.SerializedName

data class FareBreakup(

	@field:SerializedName("per_unit_weight")
	val perUnitWeight: Int? = null,

	@field:SerializedName("est_delivery_duration")
	val estDeliveryDuration: String? = null,

	@field:SerializedName("base_fare")
	val baseFare: Int? = null,

	@field:SerializedName("tax")
	val tax: Int? = null,

	@field:SerializedName("min_weight")
	val minWeight: Int? = null
)