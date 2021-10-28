package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var enter_a: EditText
    lateinit var enter_b: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enter_a = findViewById(R.id.editTextNumber_a)
        enter_b = findViewById(R.id.editTextNumber_b)

        val button_Ok: Button = findViewById(R.id.button_OK)

        button_Ok.setOnClickListener {
            val radiobutton_plus: RadioButton = findViewById(R.id.radiobutton_plus)
            val radiobutton_minus: RadioButton = findViewById(R.id.radiobutton_minus)
            val radiobutton_multiply: RadioButton = findViewById(R.id.radiobutton_multiply)
            val radiobutton_divide: RadioButton = findViewById(R.id.radiobutton_divide)
            var res: Double
            if (enter_a.text.isNullOrEmpty() && enter_b.text.isNullOrEmpty()) {
                Toast.makeText(this, "Make your choice firstly", Toast.LENGTH_SHORT).show()
            } else {
                if (radiobutton_plus.isChecked) {
                    val textView_plus: TextView = findViewById(R.id.textView_plus)

                    res =
                        enter_a.text.toString().toDouble() + enter_b.text.toString().toDouble()
                    textView_plus.text = res.toString()

                }
                if (radiobutton_minus.isChecked) {
                    val textView_minus: TextView = findViewById(R.id.textView_minus)

                    res =
                        enter_a.text.toString().toDouble() - enter_b.text.toString().toDouble()
                    textView_minus.text = res.toString()
                }
                if (radiobutton_multiply.isChecked) {
                    val textView_multiply: TextView = findViewById(R.id.textView_multiply)

                    res =
                        enter_a.text.toString().toDouble() * enter_b.text.toString().toDouble()
                    textView_multiply.text = res.toString()
                }
                if (radiobutton_divide.isChecked) {
                    val textView_divide: TextView = findViewById(R.id.textView_divide)

                    res =
                        enter_a.text.toString().toDouble() / enter_b.text.toString().toDouble()
                    textView_divide.text = res.toString()
                }
            }
        }
    }
}
