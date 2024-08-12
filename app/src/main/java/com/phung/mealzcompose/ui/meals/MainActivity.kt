package com.phung.mealzcompose.ui.meals

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.phung.mealzcompose.model.response.MealResponse
import com.phung.mealzcompose.ui.theme.MealzAppTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val viewModel: MealsCategoriesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MealzAppTheme {
                MealsCategoriesScreen(viewModel, this)
            }
        }
    }
}

@SuppressLint("MutableCollectionMutableState")
@Composable
fun MealsCategoriesScreen(viewModel: MealsCategoriesViewModel, activity: MainActivity) {
    val rememberMeals: MutableState<List<MealResponse>> = remember { mutableStateOf(emptyList()) }
//    viewModel.meals.observe(activity) { data -> rememberMeals.value = data }

    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(key1 = "GET MEALS") {
        coroutineScope.launch(Dispatchers.IO) {
            val meals = viewModel.getMeals()
            rememberMeals.value = meals
        }
    }

    LazyColumn {
        items(rememberMeals.value) { cate ->
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = cate.name)
                Text(text = cate.description)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MealzAppTheme {
        // MealsCategoriesScreen()
    }
}