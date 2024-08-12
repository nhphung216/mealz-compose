package com.phung.mealzcompose.ui.meals

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.phung.mealzcompose.model.MealsRepository
import com.phung.mealzcompose.model.response.MealResponse

class MealsCategoriesViewModel(
    private val repository: MealsRepository = MealsRepository()
) : ViewModel() {

//    val meals: MutableLiveData<ArrayList<MealResponse>> = MutableLiveData<ArrayList<MealResponse>>()

    suspend fun getMeals(): ArrayList<MealResponse> {
        return repository.getMeals().categories
    }
}