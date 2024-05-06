package com.example.myapplication.util

import android.content.Context
import android.content.Intent
import android.net.Uri

fun openAppSettings(context: Context) {
    val intent = Intent()
    intent.action = android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS
    intent.data = Uri.fromParts("package", context.packageName, null)
    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
    context.startActivity(intent)
}