package com.example.mykotlinproject.ModelClass

import com.google.gson.annotations.SerializedName

data class ArrayObjectPojo(

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("userId")
	val userId: Int? = null
)