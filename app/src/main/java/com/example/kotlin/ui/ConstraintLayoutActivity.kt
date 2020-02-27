package com.example.kotlin.ui

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputFilter
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.*
import com.example.kotlin.R
import com.example.kotlin.widget.CustomDialog
import com.example.kotlin.widget.CustomDialog2
import kotlinx.android.synthetic.main.activity_dialog.*
import kotlinx.android.synthetic.main.view_dialog.*


class ConstraintLayoutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_layout)
    }
}