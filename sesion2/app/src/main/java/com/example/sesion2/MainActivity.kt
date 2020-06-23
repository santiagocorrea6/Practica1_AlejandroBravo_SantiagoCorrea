package com.example.sesion2 //Nombre del paquete

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity //Librerias de compatibilidad
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var fecha: String
    private var cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)  //Ciclo de vida
        setContentView(R.layout.activity_main) //Implementa contenido de vista
       // Log.d("OnCreate", "ok")

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, month)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                val format = "MM/dd/yyyy"
                val simpleDateFormat = SimpleDateFormat(format, Locale.US)
                fecha = simpleDateFormat.format(cal.time).toString()
                tv_fecha_nacimiento.text = fecha
            }
        }

        ib_calendario.setOnClickListener{
           // fun onCalendarioButtonClicked(view: View) {
                DatePickerDialog(
                    this,
                    dateSetListener,
                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
        //    }
        }

        bt_guardar.setOnClickListener {
            Log.d("ButtonClicked", "true")
            val nombre = et_nombre.text.toString()
            val cedula = et_cedula.text.toString()
            val correo = et_correo.text.toString()
            val contrasena = et_contrasena.text.toString()
            val rep_contrasena = et_contrasena2.text.toString()
            val genero = if (rb_masculino.isChecked) "Masculino" else "Femenino"
            var pasatiempos = ""
            var ciudadNacimiento = sp_ciudad_nacimiento.selectedItem.toString()

            if (ch_musica.isChecked) pasatiempos = "$pasatiempos \n cine"
            if (ch_deportes.isChecked) pasatiempos = "$pasatiempos \nps4"
            if (ch_netflix.isChecked) pasatiempos = "$pasatiempos \nseries"

            if (nombre.isEmpty()) {
                //tv_resultado.text = "Por favor ingrese su nombre"
                et_nombre.setError("Por favor ingrese su nombre");
            }

            else if (cedula.isEmpty()) {
                //tv_resultado.text = "Por favor ingrese su numero cedula"
                et_cedula.setError("Por favor ingrese su numero de cedula");
            }

            else if (correo.isEmpty()) {
                //tv_resultado.text = "Por favor ingrese su correo"
                et_correo.setError("Por favor ingrese su correo");
            }

            else if (contrasena.isEmpty()) {
                //tv_resultado.text = "Por favor ingrese una contraseña"
                et_contrasena.setError("Por favor ingrese una contraseña");
            }

            else if (rep_contrasena.isEmpty()) {
                //tv_resultado.text = "Por favor repita su contraseña"
                et_contrasena2.setError("Por favor repita su contraseña");
            }

            else if (contrasena == rep_contrasena) {
                tv_resultado.text = "DATOS PERSONALES \n Nombre: $nombre \n Cedula: $cedula \n Correo: $correo \n Genero: $genero \n Ciudad: $ciudadNacimiento"
            }

            else if (fecha.isEmpty()){
                tv_fecha_nacimiento.setError("Por favor ingrese su fecha de nacimiento");
            }

            else{
                et_contrasena2.setError("Las contraseñas no son iguales");
            }

            /*if (nombre.isEmpty()) {
                tv_resultado.text = "Por favor ingrese su nombre"
            } else if (cedula.isEmpty()) {
                tv_resultado.text = "Por favor ingrese su numero cedula"
            } else if (correo.isEmpty()) {
                tv_resultado.text = "Por favor ingrese su correo"
            } else if (contrasena.isEmpty()) {
                tv_resultado.text = "Por favor ingrese una contraseña"
            } else if (rep_contrasena.isEmpty()) {
                tv_resultado.text = "Por favor repita su contraseña"
            } else{ tv_resultado.text = ""}*/

            /*if (contrasena == rep_contrasena) {
                tv_resultado.text = "Nombre: $nombre \n " +
                        "cedula: $cedula \n " +
                        "correo: $correo \n " +
                        "Ciudad de Nacimiento: $ciudadNacimiento \n " +
                        "Fecha de Nacimiento: $fecha \n " +
                        "Genero: $genero \n " +
                        "Pasatiempos: $pasatiempos"
            } else {
                tv_resultado.text = "LAS CONTRASEÑAS NO SON IGUALES"
            }*/
        }
    }
}