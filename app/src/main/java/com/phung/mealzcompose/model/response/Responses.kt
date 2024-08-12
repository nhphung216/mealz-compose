package com.phung.mealzcompose.model.response

import com.google.gson.annotations.SerializedName

data class MealsCategoriesResponse(
    @SerializedName("categories") var categories: ArrayList<MealResponse> = arrayListOf()
)

data class MealResponse(
    @SerializedName("idCategory") var id: String = "",
    @SerializedName("strCategory") var name: String = "",
    @SerializedName("strCategoryThumb") var thumbnail: String = "",
    @SerializedName("strCategoryDescription") var description: String = "",
)