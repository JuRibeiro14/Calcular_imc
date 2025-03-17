package br.edu.fatecpg.com.calcularimc.dao

import br.edu.fatecpg.com.calcularimc.model.Imc

class ImcDao {
    companion object {
        private var imc: Imc? = null

        fun definirImc(imcRecebido: Imc) {
            imc = imcRecebido
        }

        fun retornarImc(): Imc {
            return imc ?: Imc(0.0, 0.0, 0.0)
        }
    }
}