package br.com.fiap.pomar

import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    //Declarando variáveis
    private val context:Context = this
    private var quantidade:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Deixando o TextView contador invisivel
        txvContador01.visibility = View.INVISIBLE
        txvContador02.visibility = View.INVISIBLE
        txvContador03.visibility = View.INVISIBLE
        txvContador04.visibility = View.INVISIBLE
        txvContador05.visibility = View.INVISIBLE
        txvContador06.visibility = View.INVISIBLE
        txvContador07.visibility = View.INVISIBLE
        txvContador08.visibility = View.INVISIBLE
        txvContador09.visibility = View.INVISIBLE
        txvContador10.visibility = View.INVISIBLE

        //Clique das imagens
        imbFruta01.setOnClickListener{showAlert(txvContador01)}
        imbFruta02.setOnClickListener{showAlert(txvContador02)}
        imbFruta03.setOnClickListener{showAlert(txvContador03)}
        imbFruta04.setOnClickListener{showAlert(txvContador04)}
        imbFruta05.setOnClickListener{showAlert(txvContador05)}
        imbFruta06.setOnClickListener{showAlert(txvContador06)}
        imbFruta07.setOnClickListener{showAlert(txvContador07)}
        imbFruta08.setOnClickListener{showAlert(txvContador08)}
        imbFruta09.setOnClickListener{showAlert(txvContador09)}
        imbFruta10.setOnClickListener{showAlert(txvContador10)}
    }

    //Função/Método que executa o Alert Dialog
    fun showAlert(textView: TextView){

        //Declarando o Alert
        val builder = AlertDialog.Builder(this)

        //Adicionando um título ao Alert
        builder.setTitle("Selecione a quantidade")

        //Inflando o layout personalizado
        val inflater:LayoutInflater = layoutInflater
        val view = inflater.inflate(R.layout.alert_seekbar,null)

        //Vinculando os componentes do Alert
        val txvAlert = view.findViewById<TextView>(R.id.txvAlert)
        val skbQuantidade = view.findViewById<SeekBar>(R.id.skbQuantidade)

        //Atribuindo um valor máximo ao SeekBar
        skbQuantidade.max = 30

        //Adicionando um listener ao SeekBar
        skbQuantidade.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            //Método que controla o SeekBar em tempo real
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {

                //Atribuindo valor ao TextView do Alert conforme ação do SeekBar
                txvAlert.setText(""+progress)

                //Atribuindo valor a variável quantidade
                quantidade = progress
            }

            //Método que controla o SeekBar quando inicia a ação
            override fun onStartTrackingTouch(seekBar: SeekBar) {   }

            //Método que controla o SeekBar quando termina a ação
            override fun onStopTrackingTouch(seekBar: SeekBar) {   }
        })

        //Adicionando o layout personalizado ao Alert
        builder.setView(view)

        //Adicionando botões ao Alert e seus respectivos listeners
        builder.setPositiveButton("Adiconar", DialogInterface.OnClickListener { dialogInterface, i ->

            //Colocar aqui a ação desejada ao clicar no botão  Adicionar
            //Atribuindo valor ao TextView contador
            textView.text = "$quantidade"

            //Deixando o TextView contador visivel
            textView.visibility = View.VISIBLE

        })
        builder.setNegativeButton("Cancelar", DialogInterface.OnClickListener { dialogInterface, i ->

            //Colocar aqui a ação desejada ao clicar no botão  Cancelar
            //Deixando o TextView contador invisivel
            textView.visibility = View.INVISIBLE

        })

        //Criando e executando o Alert
        builder.create().show()
    }
}