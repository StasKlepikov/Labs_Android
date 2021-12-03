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
            var res: Double

            if (binding.enterA.text.isNullOrEmpty() || binding.enterB.text.isNullOrEmpty()) {
                Toast.makeText( activity,"Make your choice firstly", Toast.LENGTH_SHORT).show()
            } else {

                if (binding.rbtnPlus.isChecked) {
                    res = binding.enterA.text.toString().toDouble() + binding.enterB.text.toString().toDouble()
                    binding.tVPlus.text = res.toString()

                }
                if (binding.rbtnMinus.isChecked) {
                    res = binding.enterA.text.toString().toDouble() - binding.enterB.text.toString().toDouble()
                    binding.tVMinus.text = res.toString()
                }
                if (binding.rbtnMultiply.isChecked) {

                    res = binding.enterA.text.toString().toDouble() * binding.enterB.text.toString().toDouble()
                    binding.tVMultiply.text = res.toString()
                }
                if (binding.rbtnDivide.isChecked) {

                    res = binding.enterA.text.toString().toDouble() / binding.enterB.text.toString().toDouble()
                    binding.tVDivide.text = res.toString()
                }
            }
        }
        binding.buttonCancel.setOnClickListener {
            binding.rbtnPlus.isChecked = false
            binding.rbtnMinus.isChecked = false
            binding.rbtnMultiply.isChecked = false
            binding.rbtnDivide.isChecked = false
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentCalc()

    }
}