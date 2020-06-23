package com.example.calculadoraderesistencias

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt_calcular.setOnClickListener {
            var banda1 = sp_banda_1.selectedItem.toString()
            var banda2 = sp_banda_2.selectedItem.toString()
            var banda3 = sp_banda_3.selectedItem.toString()
            var tolerancia = sp_tolerancia.selectedItem.toString()
            var first = 0
            var second = 0
            var tole = 0
            var total = 0

            when (banda1) {
                "Marron" -> first = 1
                "Rojo" -> first = 2
                "Naranja" -> first = 3
                "Amarillo" -> first = 4
                "Verde" -> first = 5
                "Azul" -> first = 6
                "Morado" -> first = 7
                "Gris" -> first = 8
                "Blanco" -> first = 9
                else -> {
                    first = 0
                }
            }

            when (banda2) {
                "Negro" -> second = 0
                "Marron" -> second = 1
                "Rojo" -> second = 2
                "Naranja" -> second = 3
                "Amarillo" -> second = 4
                "Verde" -> second = 5
                "Azul" -> second = 6
                "Morado" -> second = 7
                "Gris" -> second = 8
                "Blanco" -> second = 9
                else -> {
                    second = 0
                }
            }

            when (tolerancia) {
                "Marron" -> tole = 1
                "Rojo" -> tole = 2
                "Oro" -> tole = 5
                "Plata" -> tole = 10
                "Ninguno" -> tole = 20
                else -> {
                    tole = 20
                }
            }

            total = ((first*10) + second)

            when (banda3) {
                "Negro" -> {
                    total = total * 1
                    tv_resultado.text = "  $total Ω \n  ± $tole%"}

                "Marron" -> {
                    total = total * 10
                    tv_resultado.text = "  $total Ω \n  ± $tole%"}

                "Rojo" -> tv_resultado.text = "  $first.$second KΩ \n  ± $tole%"

                "Naranja" ->  tv_resultado.text = "  $total KΩ \n  ± $tole%"

                "Amarillo" -> {
                    total = total * 10
                    tv_resultado.text = "  $total KΩ \n  ± $tole%"}

                "Verde" -> tv_resultado.text = "  $first.$second MΩ \n  ± $tole%"

                "Azul" -> tv_resultado.text = "  $total MΩ \n  ± $tole%"

                else -> {
                    tv_resultado.text = "NaN"
                }
            }
        }
    }
}