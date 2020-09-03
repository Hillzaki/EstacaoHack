package br.com.hildonaguiar.estacaohackimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMainCalcular.setOnClickListener {
            val peso  = edtMainPeso.text.toString().trim()
            val altura  = edtMainAltura.text.toString().trim()



            if(peso.isEmpty()){
                edtMainPeso.error = "Campo Obrigatório"
                edtMainPeso.requestFocus()


            }else if(altura.isEmpty()){
                edtMainAltura.error = "Campo Obrigatório"
                edtMainAltura.requestFocus()
            }else{
                //Abrindo a resultado
                val resultado = (peso.toDouble()/(altura.toDouble()*altura.toDouble()))
                val mIntent = Intent(this, ResultadoActivity::class.java)
                //Passando informações através da Intent
                mIntent.putExtra("RESULTADO", resultado)
                startActivity(mIntent)

                //Tirando as telas do empilhameto
                finishAffinity()
            }
        }
    }
}
