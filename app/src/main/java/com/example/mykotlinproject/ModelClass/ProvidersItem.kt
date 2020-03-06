package com.example.mykotlinproject.ModelClass

import com.google.gson.annotations.SerializedName

data class ProvidersItem(

	@field:SerializedName("service_type_id")
	val serviceTypeId: String? = null,

	@field:SerializedName("service_type")
	val serviceType: String? = null,

	@field:SerializedName("fare_breakup")
	val fareBreakup: FareBreakup? = null,

	@field:SerializedName("insurance_amount")
	val insuranceAmount: Int? = null,

	@field:SerializedName("delivery_type")
	val deliveryType: String? = null,

	@field:SerializedName("provider_id")
	val providerId: String? = null,

	@field:SerializedName("est_amount")
	val estAmount: Int? = null,

	@field:SerializedName("provider_name")
	val providerName: String? = null,

	@field:SerializedName("provider_image")
	val providerImage: String? = null,

	@field:SerializedName("delivery_type_id")
	val deliveryTypeId: String? = null
)