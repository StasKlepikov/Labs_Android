package com.example.lab1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.lab1.databinding.FragmentCalcBinding

class FragmentCalc : Fragment() {

    lateinit var binding: FragmentCalcBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalcBinding.inflate(inflater)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.buttonOk.setOnClickListener {
            var resPlus: Double
            var resMinus: Double
            var resMultiply: Double
            var resDivide: Double

            if (binding.enterA.text.isNullOrEmpty() || binding.enterB.text.isNullOrEmpty()) {
                Toast.makeText( activity,"Make your choice firstly", Toast.LENGTH_SHORT).show()
            } else {
                clear()
                if (binding.rbtnPlus.isChecked) {

                    resPlus = binding.enterA.text.toString().toDouble() + binding.enterB.text.toString().toDouble()
                    binding.tVPlus.text = resPlus.toString()


                }
                if (binding.rbtnMinus.isChecked) {

                    resMinus = binding.enterA.text.toString().toDouble() - binding.enterB.text.toString().toDouble()
                    binding.tVMinus.text = resMinus.toString()
                }
                if (binding.rbtnMultiply.isChecked) {

                    resMultiply = binding.enterA.text.toString().toDouble() * binding.enterB.text.toString().toDouble()
                    binding.tVMultiply.text = resMultiply.toString()
                }
                if (binding.rbtnDivide.isChecked) {

                    resDivide = binding.enterA.text.toString().toDouble() / binding.enterB.text.toString().toDouble()
                    binding.tVDivide.text = resDivide.toString()
                }

                realm.executeTransaction { realm ->
                    realm.insert(Result(plus = binding.tVPlus.text.toString(),
                        minus = binding.tVMinus.text.toString(),
                        multiply = binding.tVMultiply.text.toString(),
                        divide = binding.tVDivide.text.toString(),
                        _partition = "123" ))
                }
            }
        }
        binding.buttonCancel.setOnClickListener {
            clear()
            binding.rbtnPlus.isChecked = false
            binding.rbtnMinus.isChecked = false
            binding.rbtnMultiply.isChecked = false
            binding.rbtnDivide.isChecked = false
        }
    }

    private fun clear(){
        binding.tVPlus.text = ""
        binding.tVMinus.text = ""
        binding.tVMultiply.text = ""
        binding.tVDivide.text = ""
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentCalc()
    }
}