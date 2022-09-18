package com.codefrnd.foodrecipesearch.api

import com.codefrnd.foodrecipesearch.db.entity.FoodResponse
import com.codefrnd.foodrecipesearch.util.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FoodApi {

    @GET("/api/json/v1/{apiKey}/search.php")
    suspend fun getFoodApi(
        @Query("q") query: String,
        @Path("apiKey") apiKey: String = API_KEY
    ) : Response<FoodResponse>
}