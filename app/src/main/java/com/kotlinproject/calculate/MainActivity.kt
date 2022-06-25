package com.kotlinproject.calculate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.kotlinproject.calculate.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(){
    private lateinit var tasarim:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
       tasarim=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(tasarim.root)

    }


    fun btn_Click(view: View) {
        if (newOperator){
            dataView.setText("")
        }
        newOperator=false
        var btnSelect = view as Button
        var btnClickValue:String = dataView.text.toString()
        when(btnSelect.id){
            btnZero.id->{
                btnClickValue+="0"
            }
            btnOne.id->{
                btnClickValue+="1"
            }
            btnTwo.id->{
                btnClickValue+="2"
            }
            btnThree.id->{
                btnClickValue+="3"
            }
            btnFour.id->{
                btnClickValue+="4"
            }
            btnFive.id->{
                btnClickValue+="5"
            }
            btnSix.id->{
                btnClickValue+="6"
            }
            btnSeven.id->{
                btnClickValue+="7"
            }
            btnEight.id->{
                btnClickValue+="8"
            }
            btnNine.id->{
                btnClickValue+="9"
            }


        }
        dataView.setText(btnClickValue)
    }

    var operator = "*"
    var oldCount=""
    var newOperator=true
    fun btn_Operator(view: View) {
        var btn_Select= view as Button
        when(btn_Select.id){
            btnDivide.id->{
                operator="/"
            }
            btnMultiply.id->{
                operator="*"
            }
            buttonMinus.id->{
                operator="-"
            }
            buttonPlus.id->{
                operator="+"
            }
        }
        oldCount=dataView.text.toString()
        newOperator=true
    }
    fun Equals(view: View) {
        var newCount=dataView.text.toString()
        var result:Double?=null
        when(operator){
            "/"->{
                result=oldCount.toDouble()/newCount.toDouble()
            }
            "*"->{
                result=oldCount.toDouble()*newCount.toDouble()
            }
            "-"->{
                result=oldCount.toDouble()-newCount.toDouble()
            }
            "+"->{
                result=oldCount.toDouble()+newCount.toDouble()
            }
        }
        dataView.setText(result.toString())
        newOperator=true

    }
    fun Ac(view: View) {
        dataView.setText("0")
        newOperator=true
    }
    fun Per(view: View) {
        //sayi veri tipini double yaptık , edit textin ilk stringe sonra double cevirdik ve 100 e bolduk
        var count:Double=dataView.text.toString().toDouble()/100
        dataView.setText(count.toString())
        newOperator=true
    }

}
