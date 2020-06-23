package com.alejandrobravo.conversor

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        bt_procesar.setOnClickListener {

            val divisaActual = sp_divisaActual.selectedItem.toString()
            val divisaCambio = sp_divisaCambio.selectedItem.toString()
            var importe = et_importe.text.toString()


            val factorDolarEuro = 0.887685
            val factorDolarCop = 3729.71
            val factorEuroCop = 4200.79

            if (importe.isNotEmpty()) {

                when (divisaActual) {
                    "USD" -> if (divisaCambio == "EUR") {
                        val valorResultado =
                            String.format("%.2f", importe.toDouble() * factorDolarEuro)
                        tv_resultado.text = "$importe USD" + " equivale a " + "$valorResultado EUR"
                    } else if (divisaCambio == "COP") {
                        val valorResultado =
                            String.format("%.2f", importe.toDouble() * factorDolarCop)
                        tv_resultado.text = "$importe USD" + " equivale a " + "$valorResultado COP"

                    } else if (divisaCambio == "USD") {
                        val valorResultado = String.format("%.2f", importe.toDouble())
                        tv_resultado.text = "$importe USD" + " equivale a " + "$valorResultado USD"
                    }
                    "EUR" -> if (divisaCambio == "USD") {
                        val valorResultado =
                            String.format("%.2f", importe.toDouble() / factorDolarEuro)
                        tv_resultado.text = "$importe EUR" + " equivale a " + "$valorResultado USD"
                    } else if (divisaCambio == "COP") {

                        var valorResultado =
                            String.format("%.2f", importe.toDouble() * factorEuroCop)
                        tv_resultado.text = "$importe EUR" + " equivale a " + "$valorResultado COP"
                    } else if (divisaCambio == "EUR") {
                        val valorResultado = String.format("%.2f", importe.toDouble())
                        tv_resultado.text = "$importe EUR" + " equivale a " + "$valorResultado EUR"
                    }
                    "COP" -> if (divisaCambio == "USD") {
                        var valorResultado =
                            String.format("%.2f", importe.toDouble() / factorDolarCop)
                        tv_resultado.text = "$importe COP" + " equivale a " + "$valorResultado USD"
                    } else if (divisaCambio == "EUR") {
                        var valorResultado =
                            String.format("%.2f", importe.toDouble() / factorEuroCop)
                        tv_resultado.text = "$importe COP" + " equivale a " + "$valorResultado EUR"

                    } else if (divisaCambio == "COP") {
                        val valorResultado = String.format("%.2f", importe)
                        tv_resultado.text = "$importe COP" + " equivale a " + "$valorResultado COP"
                    }
                }


            }else{
                Toast.makeText(applicationContext,"Escribe un importe",Toast.LENGTH_LONG).show()
            }

        }
    }
}


