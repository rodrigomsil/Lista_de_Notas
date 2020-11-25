package com.example.aula19_11_resolucao_prova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buscaDados();
    }

    private fun buscaDados() {
        val serviceRetrofit = RetrofitService()
        serviceRetrofit.api?.getNotas()?.enqueue(object : Callback<List<Notas>> {
            override fun onResponse(call: Call<List<Notas>?>?, response: Response<List<Notas>?>?) {
                val listaDeNotas = response?.body()

                nome1.text = listaDeNotas?.get(0)?.nome
                nome2.text = listaDeNotas?.get(1)?.nome
                nome3.text = listaDeNotas?.get(2)?.nome

                imagem1.setImageResource(if(listaDeNotas?.get(0)?.nota!! <6)R.drawable.vermelho else R.drawable.azul)
                imagem2.setImageResource(if(listaDeNotas?.get(1)?.nota!! <6)R.drawable.vermelho else R.drawable.azul)
                imagem3.setImageResource(if(listaDeNotas?.get(2)?.nota!! <6)R.drawable.vermelho else R.drawable.azul)

                nota1.text = listaDeNotas?.get(0)?.nota.toString()
                nota2.text = listaDeNotas?.get(1)?.nota.toString()
                nota3.text = listaDeNotas?.get(2)?.nota.toString()

            }

            override fun onFailure(call: Call<List<Notas>?>?, t: Throwable?) {
                Log.e("Erro", "************** erro **********\n" + t?.message.toString())
            }
        })

    }
}