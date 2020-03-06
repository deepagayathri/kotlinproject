package com.example.mykotlinproject.ModelClass

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("delivery_types")
	val deliveryTypes: List<DeliveryTypesItem?>? = null,

	@field:SerializedName("providers")
	val providers: List<ProvidersItem?>? = null
)