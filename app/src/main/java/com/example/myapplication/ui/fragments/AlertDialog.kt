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
                .setMessage("This lets you to take photos. You can change this anytime in your device settings")
                .setTitle("Allow app to access your camera")
                .setPositiveButton("Set Permission") { _, _ ->
                    positiveClick.invoke()
                }
                .setNeutralButton("Okay") { _, _ ->
                    dismiss()
                }

            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}