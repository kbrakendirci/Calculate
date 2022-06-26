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
    var operator = "*"
    var oldResult=""
    var newOperator=true
    override fun onCreate(savedInstanceState: Bundle?) {
       tasarim=ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(tasarim.root)
    }
//Kullanılan Butonlara layout dosyasında onclick özelliği verilmiştir.
// Verilen Onclick id'lere göre tuşların işlevleri tanımlanmıştır.
    fun btn_Click(view: View) {
        if (newOperator){
            tvResult.setText("")
        }

        newOperator=false
        var btnSelect = view as Button
        var btnClickValue:String = tvResult.text.toString()
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
        tvResult.setText(btnClickValue)
    }


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
        oldResult=tvResult.text.toString()
        newOperator=true
    }
    fun Equals(view: View) {
        var newResult=tvResult.text.toString()
        var result:Double?=null
        when(operator){
            "/"->{
                result=oldResult.toDouble()/newResult.toDouble()
            }
            "*"->{
                result=oldResult.toDouble()*newResult.toDouble()
            }
            "-"->{
                result=oldResult.toDouble()-newResult.toDouble()
            }
            "+"->{
                result=oldResult.toDouble()+newResult.toDouble()
            }
        }
        tasarim.tvResult.setText(result.toString())
        newOperator=true

    }
    fun Ac(view: View) {
        tvResult.setText("0")
        newOperator=true
    }
    fun Percent(view: View) {
        //Kullanıcıdan alınan sayının veri tipi double yaptık ,
        // edit text ilk stringe sonra double cevirildi 100 e bolündü
        var count:Double=tvResult.text.toString().toDouble()/100
        tasarim.tvResult.setText(count.toString())
        newOperator=true
    }

}
