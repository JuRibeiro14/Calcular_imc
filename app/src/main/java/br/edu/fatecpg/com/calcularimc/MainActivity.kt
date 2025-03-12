package br.edu.fatecpg.com.calcularimc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatec.com.calcularimc.ResultadoActivity
import br.edu.fatecpg.com.calcularimc.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextPeso: EditText = findViewById(R.id.edt_peso)
        val editTextAltura: EditText = findViewById(R.id.edt_altura)
        val buttonCalcular: Button = findViewById(R.id.btn_calcular)

        buttonCalcular.setOnClickListener {
            val peso = editTextPeso.text.toString().toFloatOrNull()
            val altura = editTextAltura.text.toString().toFloatOrNull()

            if (peso != null && altura != null && altura > 0) {
                val imc = peso / (altura * altura)

                val intent = Intent(this, ResultadoActivity::class.java)
                intent.putExtra("IMC_RESULTADO", imc)
                startActivity(intent)
            } else {
                editTextPeso.error = "Insira um peso válido"
                editTextAltura.error = "Insira uma altura válida"
            }
        }
    }
}
