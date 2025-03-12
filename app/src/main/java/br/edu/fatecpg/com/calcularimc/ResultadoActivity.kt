package br.edu.fatec.com.calcularimc

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.com.calcularimc.R

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val textViewResultado: TextView = findViewById(R.id.txt_resultado)
        val textViewClassificacao: TextView = findViewById(R.id.txt_classificacao)
        val buttonVoltar: Button = findViewById(R.id.btn_voltar)

        val imc = intent.getFloatExtra("IMC_RESULTADO", 0.0f)
        textViewResultado.text = "Seu IMC é: %.2f".format(imc)
        textViewClassificacao.text = classificarIMC(imc)

        buttonVoltar.setOnClickListener {
            finish()
        }
    }

    private fun classificarIMC(imc: Float): String {
        return when {
            imc < 18.5 -> "Abaixo do peso"
            imc in 18.5..24.9 -> "Peso ideal"
            imc in 25.0..29.9 -> "Sobrepeso"
            imc >= 30.0 -> "Obesidade"
            else -> "IMC inválido"
        }
    }
}
