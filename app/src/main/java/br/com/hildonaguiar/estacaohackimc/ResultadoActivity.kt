package br.com.hildonaguiar.estacaohackimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_resultado.*

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        //Obter o dado passado pela intent
        val resultado = intent.getDoubleExtra("RESULTADO", 0.0)

        //Exibindo as informações para o usuário




         if(resultado  <= 18.5){
            edtResultadoExec.text = "Perigo! Você está abaixo do peso"
            edtResultadoRec.text = "Procure uma unidade de saúde do SUS ou ligue 136."
          }else if(resultado > 18.5 && resultado <= 24.9){
            edtResultadoExec.text = "Parabéns! Você Está com o Peso Normal"
            edtResultadoRec.text = "Continue assim."
          }else if(resultado > 25 && resultado <= 29.9 ){
            edtResultadoExec.text = "Atenção! Você Está um pouco acima do Peso"
            edtResultadoRec.text = "Procure um nutricionista"
         }else if(resultado in 30.0..34.9){
            edtResultadoExec.text = "Perigo! Você Está Obeso nível I"
            edtResultadoRec.text = "Procure uma unidade de saúde do SUS ou ligue 136. "
        }else if (resultado in 35.0..39.9){
            edtResultadoExec.text = "Perigo! Você está com Obesidade nível II"
            edtResultadoRec.text = "Procure uma unidade de saúde do SUS ou ligue 136. "
        }else{
            edtResultadoExec.text = "Perigo! Você Está com obesidade nível III"
            edtResultadoRec.text = "Procure uma unidade de saúde do SUS ou ligue 136. "
        }

        edtResultadoImc.text = resultado.toString()

        btnResultadoFechar.setOnClickListener {
            //Criando Alerta
            AlertDialog.Builder(this)
                .setTitle("Atenção")
                .setMessage("Você realmente deseja Recalcular?")
                .setPositiveButton("Sim"){_,_ ->
                    //executando o clique do botão SIM
                    val mIntent = Intent(this, MainActivity::class.java)
                    startActivity(mIntent)
                    finishAffinity()
                }
                .setNeutralButton("Cancelar"){_,_ -> }
                .setCancelable(false)
                .create()
                .show()

        }
    }
}