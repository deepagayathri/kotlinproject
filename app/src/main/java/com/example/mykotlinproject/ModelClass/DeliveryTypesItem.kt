package com.example.mykotlinproject.ModelClass

import com.google.gson.annotations.SerializedName

data class DeliveryTypesItem(

	@field:SerializedName("delivery_type")
	val deliveryType: String? = null,

	@field:SerializedName("delivery_type_id")
	val deliveryTypeId: String? = null
)