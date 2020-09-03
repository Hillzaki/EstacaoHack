package br.com.hildonaguiar.estacaohackimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        //Este app é composto por três activities (Splash, Main e Resultado).
        //- Neste app o usuário define seu peso e altura, ao clicar no botão calcular deve ser aberta
        // a tela de Resultado exibindo o IMC e a classificação (acima do peso, abaixo do peso, etc...)
        //- É necessário que o usuário possa recalcular seu IMC caso ele queira

        //Abrindo a Splash por 3 segundos
        Handler(Looper.getMainLooper()).postDelayed({
            //Transição de telas
            val mIntent = Intent(this, MainActivity::class.java)
            startActivity(mIntent)
            finish()
        },6000 )
    }
}