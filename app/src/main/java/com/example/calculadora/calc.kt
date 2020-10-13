package com.example.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class calc : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calc)
        val objetoIntent: Intent = intent
        var user = objetoIntent.getStringExtra("user")
        setTitle("Bienvenido " + user);
    }

    fun onClick(v: View) {
        var num = findViewById<TextView>(R.id.textViewResul)
        val b: Button = v as Button
        val buttonText: String = b.getText().toString()
        val lastResul = num.text
        num.text = lastResul.toString() + buttonText
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        var num = findViewById<TextView>(R.id.textViewResul)
        savedInstanceState.putString("MyString", num.text.toString())
        super.onSaveInstanceState(savedInstanceState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        var num = findViewById<TextView>(R.id.textViewResul)
        super.onRestoreInstanceState(savedInstanceState)
        val myStr = savedInstanceState.getString("MyString")
        num.text = myStr
    }

    fun sumar(): Double {
        var num = findViewById<TextView>(R.id.textViewResul)
        val str = num.text
        val partes = str.split("\\+".toRegex()).toTypedArray()
        val parte1 = partes[0]
        val parte2 = partes[1]
        var opr = parte1.toDouble() + parte2.toDouble()

        return opr
    }

    fun restar(): Double {
        var num = findViewById<TextView>(R.id.textViewResul)
        val str = num.text
        val partes = str.split("\\-".toRegex()).toTypedArray()
        val parte1 = partes[0]
        val parte2 = partes[1]
        var opr = parte1.toDouble() - parte2.toDouble()
        num.text = opr.toString()

        return opr
    }

    fun multiplicar(): Double {
        var num = findViewById<TextView>(R.id.textViewResul)
        val str = num.text
        val partes = str.split("x".toRegex()).toTypedArray()
        val parte1 = partes[0]
        val parte2 = partes[1]
        var opr = parte1.toDouble() * parte2.toDouble()
        num.text = opr.toString()

        return opr

    }

    fun dividir(): Double {
        var num = findViewById<TextView>(R.id.textViewResul)
        val str = num.text
        var opr : Double = 0.0

        val partes = str.split("÷".toRegex()).toTypedArray()
        val parte1 = partes[0]
        val parte2 = partes[1]

        if (parte2.equals("0")) {
            Toast.makeText(applicationContext, "Error: No se puede dividir entre 0", Toast.LENGTH_SHORT).show()
        } else {
            opr = parte1.toDouble() / parte2.toDouble()
            num.text = opr.toString()

        }
        return opr
    }

    fun operar(view: View) {
        var num = findViewById<TextView>(R.id.textViewResul)
        val str = num.text
        if (str.contains("+")) {
            num.text = sumar().toString()
        }
        if (str.contains("-")) {
            num.text = restar().toString()
        }
        if (str.contains("x")) {
            num.text = multiplicar().toString()
        }
        if (str.contains("÷")) {
            num.text = dividir().toDouble().toString()
        }
    }

    fun borrar(view: View) {
        var borrar = findViewById<TextView>(R.id.textViewResul)
        borrar.text = ""
    }

}