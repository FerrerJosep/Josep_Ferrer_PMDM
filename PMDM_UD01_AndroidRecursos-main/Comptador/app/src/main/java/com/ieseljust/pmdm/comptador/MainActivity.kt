package com.ieseljust.pmdm.comptador


import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var comptador=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Es comprova si existeix algun estat, si existeix es restaura el contador
        if (savedInstanceState != null) {
            comptador = savedInstanceState.getInt("contador", 0)
        }

        // Referencia al TextView
        val textViewContador=findViewById<TextView>(R.id.textViewComptador)

        // Inicialitzem el TextView amb el comptador a 0
        textViewContador.setText(comptador.toString())

        // Referencia al botón
        val btAdd=findViewById<Button>(R.id.btAdd)

        // Boton de restars
        val btSubtract = findViewById<Button>(R.id.btSubtract)

        //Boton Reset
        val btReset= findViewById<Button>(R.id.btReset)


        // Asociaciamos una expresióin lambda como
        // respuesta (callback) al evento Clic sobre
        // el botón
        btAdd.setOnClickListener {
            comptador++
            textViewContador.setText(comptador.toString())
        }

        btSubtract.setOnClickListener {
            comptador--
            textViewContador.text = comptador.toString()
        }

        btReset.setOnClickListener{
            comptador=0
            textViewContador.setText(comptador.toString())
        }

        //Se actualiza el text view con el valor del contador
        textViewContador.text = comptador.toString()



    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("contador", comptador)
        super.onSaveInstanceState(outState)
    }


}