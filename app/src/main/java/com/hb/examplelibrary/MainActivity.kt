package com.hb.examplelibrary

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.hb.examplelibrary.databinding.ActivityMainBinding
import com.hb.number_conversions.binaryToDecimal
import com.hb.number_conversions.binaryToHex
import com.hb.number_conversions.binaryToOctal
import com.hb.number_conversions.decimalToBinary
import com.hb.number_conversions.decimalToHexadecimal
import com.hb.number_conversions.decimalToOctal
import com.hb.number_conversions.hexToBinary
import com.hb.number_conversions.hexToDecimal
import com.hb.number_conversions.hexToOctal
import com.hb.number_conversions.octalToBinary
import com.hb.number_conversions.octalToDecimal
import com.hb.number_conversions.octalToHexadecimal

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val spinnerData1 = arrayListOf("Binary", "Decimal", "Octal", "Hexadecimal")
    private val spinnerData2 = arrayListOf("Binary", "Decimal", "Octal", "Hexadecimal")
    private var spinner1String = ""
    private var spinner2String = ""
    private var spinner1Position = 0
    private var spinner2Position = 0

    var userText = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter1 = ArrayAdapter(this, R.layout.simple_spinner_item, spinnerData1)
        binding.spinner1.adapter = adapter1
        binding.spinner1.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                spinner1String = spinnerData1[position]
                spinner1Position = position
                when(spinner1Position){
                    0->{
                        binding.question.text = "Enter binary number :"
                        binding.givenNumber.setText("")
                        binding.answerText.setText("")
                    }
                    1->{
                        binding.question.text = "Enter decimal number :"
                        binding.givenNumber.setText("")
                        binding.answerText.setText("")
                    }
                    2->{
                        binding.question.text = "Enter octal number :"
                        binding.givenNumber.setText("")
                        binding.answerText.setText("")
                    }
                    3->{
                        binding.question.text = "Enter hexadecimal number :"
                        binding.givenNumber.setText("")
                        binding.answerText.setText("")
                    }

                }

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        val adapter2 = ArrayAdapter(this, R.layout.simple_spinner_item, spinnerData2)
        binding.spinner2.adapter = adapter2
        binding.spinner2.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                spinner2String = spinnerData1[position]
                spinner2Position = position
                when(spinner2Position){
                    0->{
                        binding.answer.text = "binary number :"
                        binding.givenNumber.setText("")
                        binding.answerText.setText("")

                    }
                    1->{
                        binding.answer.text = "decimal number :"
                        binding.givenNumber.setText("")
                        binding.answerText.setText("")
                    }
                    2->{
                        binding.answer.text = "octal number :"
                        binding.givenNumber.setText("")
                        binding.answerText.setText("")
                    }
                    3->{
                        binding.answer.text = "hexadecimal number :"
                        binding.givenNumber.setText("")
                        binding.answerText.setText("")
                    }

                }

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        binding.givenNumber.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                userText = text?.trim().toString()
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
        binding.convertButton.setOnClickListener {
            when(spinner1Position){
                0-> when(spinner2Position){
                    0-> binding.answerText.setText(userText)
                    1-> binding.answerText.setText(binaryToDecimal(userText))
                    2-> binding.answerText.setText(binaryToOctal(userText))
                    3-> binding.answerText.setText(binaryToHex(userText))
                }
                1-> when(spinner2Position){
                    0-> binding.answerText.setText(decimalToBinary(userText.toInt()))
                    1-> binding.answerText.setText(userText)
                    2-> binding.answerText.setText(decimalToOctal(userText.toInt()))
                    3-> binding.answerText.setText(decimalToHexadecimal(userText.toInt()))
                }
                2-> when(spinner2Position){
                    0-> binding.answerText.setText(octalToBinary(userText))
                    1-> binding.answerText.setText(octalToDecimal(userText))
                    2-> binding.answerText.setText(userText)
                    3-> binding.answerText.setText(octalToHexadecimal(userText))
                }
                3-> when(spinner2Position){
                    0-> binding.answerText.setText(hexToBinary(userText))
                    1-> binding.answerText.setText(hexToDecimal(userText))
                    2-> binding.answerText.setText(hexToOctal(userText))
                    3-> binding.answerText.setText(userText)
                }
            }
        }
    }
}