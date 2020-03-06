package com.example.mykotlinproject.ModelClass

import com.google.gson.annotations.SerializedName

data class ObjWithMultiPojo(

	@field:SerializedName("response")
	val response: Response? = null,

	@field:SerializedName("message")
	val message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)