package com.example.aula19_11_resolucao_prova

import retrofit2.Call
import retrofit2.http.GET

interface EndPoint {

    @GET("notas")
    fun getNotas():Call<List<Notas>>
}