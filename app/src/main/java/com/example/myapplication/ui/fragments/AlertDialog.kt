package com.example.myapplication.ui.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class AlertDialog : DialogFragment() {

    lateinit var positiveClick: () -> Unit
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction.
            val builder: AlertDialog.Builder = AlertDialog.Builder(context)
            builder
                .setMessage("You has no Camera Permission grated, cause of this some features like a camera feature may be not used by you")
                .setTitle("Educational Rationale")
                .setPositiveButton("Set Permission") { dialog, which ->
                    positiveClick.invoke()
                }
                .setNeutralButton("Okay") { dialog, which ->
                    dismiss()
                }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}