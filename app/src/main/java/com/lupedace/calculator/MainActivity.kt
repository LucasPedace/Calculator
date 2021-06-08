package com.lupedace.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.core.content.ContextCompat
import com.lupedace.calculator.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression
import java.lang.Exception
import java.text.DecimalFormat


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val input = binding.input
        val output = binding.output

        binding.buttonClear.setOnClickListener {
            input.text = ""
            output.text = ""
        }

        binding.buttonBracketLeft.setOnClickListener {
            input.text = addToInputText("(")
        }
        binding.buttonBracketRight.setOnClickListener {
            input.text = addToInputText(")")
        }
        binding.button0.setOnClickListener {
            input.text = addToInputText("0")
        }
        binding.button1.setOnClickListener {
            input.text = addToInputText("1")
        }
        binding.button2.setOnClickListener {
            input.text = addToInputText("2")
        }
        binding.button3.setOnClickListener {
            input.text = addToInputText("3")
        }
        binding.button4.setOnClickListener {
            input.text = addToInputText("4")
        }
        binding.button5.setOnClickListener {
            input.text = addToInputText("5")
        }
        binding.button6.setOnClickListener {
            input.text = addToInputText("6")
        }
        binding.button7.setOnClickListener {
            input.text = addToInputText("7")
        }
        binding.button8.setOnClickListener {
            input.text = addToInputText("8")
        }
        binding.button9.setOnClickListener {
            input.text = addToInputText("9")
        }
        binding.buttonDot.setOnClickListener {
            input.text = addToInputText(".")
        }
        binding.buttonDivision.setOnClickListener {
            input.text = addToInputText("÷")
        }
        binding.buttonMultiply.setOnClickListener {
            input.text = addToInputText("×")
        }
        binding.buttonSubtraction.setOnClickListener {
            input.text = addToInputText("-")
        }
        binding.buttonAddition.setOnClickListener {
            input.text = addToInputText("+")
        }
        binding.buttonEquals.setOnClickListener {
            showResult()
        }
    }

    private fun addToInputText(buttonValue: String): String{
        return "${binding.input.text}$buttonValue"
    }
    private fun getInputExpression(): String{
        var expression = binding.input.text.replace(Regex("÷"),"/")
        expression = expression.replace(Regex("×"),"*")
        return expression
    }
    private fun showResult(){
        try{
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()){
                //Show Error Message
                binding.output.text = "Error"
                binding.output.setTextColor(ContextCompat.getColor(this, R.color.red))
            }else {
                //Show Result
                binding.output.text = DecimalFormat("0.#####").format(result).toString()
                binding.output.setTextColor(ContextCompat.getColor(this, R.color.green))
            }
        }catch (e: Exception){
            //Show Error Message
            binding.output.text = "Error"
            binding.output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }
}