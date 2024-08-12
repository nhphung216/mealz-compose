package com.phung.mealzcompose.model

import com.phung.mealzcompose.model.api.MealsWebService
import com.phung.mealzcompose.model.response.MealsCategoriesResponse
import retrofit2.Call

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {

    suspend fun getMeals(): MealsCategoriesResponse = webService.getMeals()
}