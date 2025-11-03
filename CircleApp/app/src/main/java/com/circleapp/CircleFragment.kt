package com.circleapp

import android.content.res.ColorStateList
import android.graphics.Color
import android.widget.Button
import android.widget.EditText
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

class CircleFragment : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Now you can call findViewById() on the 'view' object
        val radiusEditText = view.findViewById<EditText?>(R.id.radius_edit_text)
        val calcButton = view.findViewById<Button?>(R.id.calculate_button)
        calcButton.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#6B317A"))
        val answerLabel = view.findViewById<TextView>(R.id.answer_label)

        calcButton.setOnClickListener {
            val radius_val: Double = radiusEditText.text.toString().toDoubleOrNull() ?: 0.0
            if(radius_val == 0.0)
                Toast.makeText(requireContext(), "Invalid input. Please type any value > 0...", Toast.LENGTH_SHORT).show()
            else {
                val areaVal: Double = radius_val * radius_val * Math.PI
                val finalStr = getString(R.string.answer_label) + " " + String.format("%.2f", areaVal)
                answerLabel.text = finalStr
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_circle, container, false)
    }
}